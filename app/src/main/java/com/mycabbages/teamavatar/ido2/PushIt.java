package com.mycabbages.teamavatar.ido2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.FileNotFoundException;


/**
 * Created by Conrad on 11/15/2017.
 */

public class PushIt extends BroadcastReceiver {

    @Override
public void onReceive(final Context context, Intent intent) {
        pushImplimentation push = new pushImplimentation();
            push.alarmSet(context);
            try {
            push.checkNotifications(context);
        }catch (Exception e) {
            new FileNotFoundException();
        }

    }
}
