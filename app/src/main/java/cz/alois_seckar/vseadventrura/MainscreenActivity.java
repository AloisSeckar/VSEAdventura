package cz.alois_seckar.vseadventrura;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IGameG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.DemoGSMFactory;

public class MainscreenActivity extends AppCompatActivity {

    IGameG game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        TextView vystup = (TextView) findViewById(R.id.odpovedText);
        vystup.setMovementMethod(new ScrollingMovementMethod());

        DemoGSMFactory factory = new DemoGSMFactory();
        game = factory.getGame();
        if (!game.isAlive()) {
            vystup.append("\n" + game.executeCommand(""));
        }
    }

    public void reakceNaVstup(View v) {
        EditText vstup = (EditText) findViewById(R.id.prikazText);
        TextView vystup = (TextView) findViewById(R.id.odpovedText);

        String command = vstup.getText().toString();

        vystup.append("\n\n" + getString(R.string.command_reaction) + " " + command);

        if (command.equalsIgnoreCase("end")) {
            this.finish();
        } else {
            vystup.append("\n" + game.executeCommand(command));
            vstup.setText("");

            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                String action = extras.getString("action");
                String item = extras.getString("item");
                if (action != null && !action.equals("")) {
                    TextView vystup = (TextView) findViewById(R.id.odpovedText);
                    vystup.append("\n\n" + getString(R.string.command_reaction) + " " + action + " " + item);
                    vystup.append("\n" + game.executeCommand(action + " " + item));
                }
            }
        }
    }

    public void showRoom(View v) {
        Intent ide = new Intent(MainscreenActivity.this, RoomActivity.class);
        startActivityForResult(ide, 0);
    }

    public void showBag(View v) {
        Intent ide = new Intent(MainscreenActivity.this, BagActivity.class);
        startActivityForResult(ide, 0);
    }

    public void showMap(View v) {
        Intent ide = new Intent(MainscreenActivity.this, MapActivity.class);
        startActivity(ide);
    }

    public void showHelp(View v) {
        TextView vystup = (TextView) findViewById(R.id.odpovedText);
        vystup.append("\n\n" + getString(R.string.command_reaction) + " ?");
        vystup.append("\n" + game.executeCommand("?"));

        URL source = game.getHelpURL();
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(source.toString()));
            startActivity(browserIntent);
        } catch (Exception e) {
            // cannot start browser
        }
    }

    public void endGame(View v) {
        finish();
    }
}

