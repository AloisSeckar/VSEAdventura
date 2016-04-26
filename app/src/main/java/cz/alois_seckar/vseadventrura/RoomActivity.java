package cz.alois_seckar.vseadventrura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Collection;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IGameG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IItemG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.ISpaceG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.DemoGSMFactory;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);


        DemoGSMFactory factory = new DemoGSMFactory();
        IGameG game = factory.getGame();
        ISpaceG currentRoom = game.getWorld().getCurrentSpace();

        ImageView roomImage = (ImageView) findViewById(R.id.roomImage);
        roomImage.setImageResource(getResources().getIdentifier(currentRoom.getPicture(), "drawable", getPackageName()));

        String name = currentRoom.getName();
        TextView roomName = (TextView) findViewById(R.id.roomNameLabel);
        roomName.setText(getString(R.string.room_name) + " " + name);

        Collection<IItemG> items = (Collection<IItemG>) currentRoom.getItems();
        TableLayout roomItems = (TableLayout) findViewById(R.id.roomItems);
        roomItems.removeAllViews();
        for (IItemG current : items) {
            ImageButton button = new ImageButton(RoomActivity.this);
            button.setImageResource(getResources().getIdentifier(current.getPicture(), "drawable", getPackageName()));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent();
                    i.putExtra("action", "Take");
                    i.putExtra("item", current.getName());
                    setResult(0, i);
                    finish();
                }
            });
            roomItems.addView(button);
        }
    }

    public void goBack(View v) {
        finish();
    }
}
