package com.example.saleem_aqsa.hard_key_demo;

/**
 * Created by saleem_aqsa on 3/2/17.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CallBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int volume = (Integer)intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE");
        Log.i("Tag", "Action : "+ intent.getAction() + " / volume : "+volume);
    }

}