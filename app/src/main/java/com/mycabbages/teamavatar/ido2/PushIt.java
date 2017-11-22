package com.mycabbages.teamavatar.ido2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import

/**
 * Created by Conrad on 11/15/2017.
 */

public class PushIt extends BroadcastReceiver {







    @Override
    public void onReceive(final Context context, Intent intent) {
        PushNotification push = new PushNotification();
        push.alarmSet();

        push.checknotifications();

        push.checknotifications(goal);
    }
}
