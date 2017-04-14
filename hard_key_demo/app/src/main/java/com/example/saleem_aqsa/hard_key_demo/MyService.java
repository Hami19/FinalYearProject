package com.example.saleem_aqsa.hard_key_demo;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.Toast;

public class MyService extends Service {



    @Override
    public IBinder onBind(Intent intent) {



        return null;
    }

    @Override
    public void onCreate() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.media.VOLUME_CHANGED_ACTION");
        System.out.println("Service startsss");

    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // do your jobs here

        System.out.println("Service startcommand");
        BroadcastReceiver rece= new BroadcastReceiver() {


            @Override
            public void onReceive(Context context, Intent intent) {
                KeyEvent ke = (KeyEvent)intent.getExtras().get(Intent.EXTRA_KEY_EVENT);
                if (ke .getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP) {
                    System.out.println("I got volume up event");
                }else if (ke .getKeyCode() == KeyEvent.KEYCODE_VOLUME_DOWN) {
                    System.out.println("I got volume key down event");
                }
            }
        };



        return super.onStartCommand(intent, flags, startId);
    }




    /*private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals("android.provider.Telephony.SMS_RECEIVED")){
                //action for sms received
                android.media.VOLUME_CHANGED_ACTION;
            }
            else if(action.equals(android.telephony.TelephonyManager.ACTION_PHONE_STATE_CHANGED)){
                //action for phone state changed
            }
        }
    };*/

 /*   private final CallBroadcastReceiver receiver = new CallBroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            Intent i = new Intent();
            i.setClass(MyService.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
    };*/


}
