package cz.alois_seckar.vseadventrura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;

import java.util.Collection;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IBagG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IGameG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IItemG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.DemoGSMFactory;


public class BagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);

        DemoGSMFactory factory = new DemoGSMFactory();
        IGameG game = factory.getGame();
        IBagG currentBag = game.getBag();

        Collection<IItemG> items = (Collection<IItemG>) currentBag.getItems();
        TableLayout bagItems = (TableLayout) findViewById(R.id.bagItems);
        bagItems.removeAllViews();
        for (IItemG current : items) {
            ImageButton button = new ImageButton(BagActivity.this);
            button.setImageResource(getResources().getIdentifier(current.getPicture(), "drawable", getPackageName()));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent();
                    i.putExtra("action", "Put_down");
                    i.putExtra("item", current.getName());
                    setResult(0, i);
                    finish();
                }
            });
            bagItems.addView(button);
        }
    }

    public void goBack(View v) {
        finish();
    }
}
