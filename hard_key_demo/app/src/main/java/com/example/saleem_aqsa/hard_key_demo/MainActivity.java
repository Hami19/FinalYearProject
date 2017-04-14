package com.example.saleem_aqsa.hard_key_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    boolean flag = false;

    boolean flag2 = false;
    public static int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, MyService.class));
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Log.d("Test", "Long press!");
            flag = true;
           // flag2 = true;
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }


    @Override
    protected void onPause() {
        super.onPause();
        startService(new Intent(this, MyService.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        startService(new Intent(this, MyService.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startService(new Intent(this, MyService.class));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {

            event.startTracking();

                j++;
                Log.d("Test", "key press " + j);

            if(j==3)
            {
                startActivity(new Intent(this,Main2Activity.class));
            }
           /* if (flag2 == true) {
                flag = false;
            } else {
                flag = true;
                flag2 = false;
            }
            */
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }




    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {

            event.startTracking();
            Log.d("Test", "Up press!");
        }
        return true;
    }

  /*  @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {

            event.startTracking();
            if (flag) {
                Log.d("Test", "Short");
            }
            flag = true;
            flag2 = false;
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }*/

}
