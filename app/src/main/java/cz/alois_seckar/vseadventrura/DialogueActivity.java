package cz.alois_seckar.vseadventrura;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGame;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.DemoGSMFactory;

public class DialogueActivity extends AppCompatActivity {

    IGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);

        TextView vystup = (TextView) findViewById(R.id.odpovedText);
        vystup.setMovementMethod(new ScrollingMovementMethod());

        DemoGSMFactory factory = new DemoGSMFactory();
        game = factory.getGame();
        vystup.append("\n" + game.executeCommand(""));
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
}
