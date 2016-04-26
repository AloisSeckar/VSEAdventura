package cz.alois_seckar.vseadventrura;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IGameG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.ISpaceG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.DemoGSMFactory;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        DemoGSMFactory factory = new DemoGSMFactory();
        IGameG game = factory.getGame();
        ISpaceG currentRoom = game.getWorld().getCurrentSpace();

        String name = currentRoom.getName();
        TextView roomName = (TextView) findViewById(R.id.roomNameLabel);
        roomName.setText(getString(R.string.room_name) + " " + name);

        //Get bitmap to draw
        Bitmap playerPic = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(game.getPlayer(), "drawable", getPackageName()));
        //Create a new image bitmap and attach a brand new canvas to it
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inMutable = true;
        Bitmap mapPic = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(game.getMap(), "drawable", getPackageName()), opts);
        Canvas tempCanvas = new Canvas(mapPic);
        //Draw the image bitmap into the cavas
        Point playerCoords = game.getWorld().getCurrentSpace().getPosition();
        tempCanvas.drawBitmap(playerPic, playerCoords.x * mapPic.getWidth() / 10, playerCoords.y * mapPic.getHeight() / 10, null);
        //Attach the canvas to the ImageView
        ImageView mapImage = (ImageView) findViewById(R.id.mapImage);
        mapImage.setImageDrawable(new BitmapDrawable(getResources(), mapPic));
    }

    public void goBack(View v) {
        finish();
    }
}
