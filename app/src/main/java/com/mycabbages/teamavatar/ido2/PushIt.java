package com.mycabbages.teamavatar.ido2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.FileNotFoundException;


/**
 * Created by Conrad on 11/15/2017.
 */

public class PushIt extends BroadcastReceiver {
    // this listens to the phones alarm to activate the push notifications and sets new alarm
    @Override
public void onReceive(final Context context, Intent intent) {
        PushImplimentation push = new PushImplimentation();
            push.alarmSet(context);
        try {
            push.checkNotifications(context);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
