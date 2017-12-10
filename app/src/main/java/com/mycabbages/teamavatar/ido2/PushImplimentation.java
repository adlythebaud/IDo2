package com.mycabbages.teamavatar.ido2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Creates and handles the AlarmManager needed to push notifications to the Users phone.
 * @author Conrad
 */

public class PushImplimentation extends Activity {
    private static final String TAG = "Push_Implementation";
    private Date timeToSend;
    private String message;

    private String saveNotification;
    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION   = "notification";

    private PendingIntent pendingIntent;
    private AlarmManager alarmMgr;


    /*
    * Sets the alarm to allow the notifications to be sent after the app closes.
    */
    public void alarmSet(Context context) {
        Intent dialogIntent = new Intent(context, PushIt.class);

        alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        pendingIntent = PendingIntent.getBroadcast(context, 0, dialogIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 21600000, pendingIntent);

    }

    /*
    * this loads the code from shared prefrences and checks to see if any of the notifications
    * are ready to be pushed
    */
    public void checkNotifications(Context context) throws FileNotFoundException {
        ReadWrite read = new ReadWrite();
        List<PushNotification> notify = read.loadPushNotificationList(context);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int notifyId = 0;

        for (int i = 0; i < notify.size(); i++){
            if(notify.get(i).getTimeToSend() >= System.currentTimeMillis() - 100000000
                    && notify.get(i).getTimeToSend() <= System.currentTimeMillis() + 100000
                    && !notify.get(i).isSent()){

                    scheduleAnNotification(context ,notify.get(i).getNotificationTitle(),
                                            notify.get(i).getMessage(),0,notifyId);
                    notifyId++;
                    notify.get(i).setSent(true);
                }
            }
            for (int i = 0; i < notify.size(); i++){
               if(notify.get(i).isSent() == true){
                   notify.remove(i);
               }
            }
            read.savePushNotificationList(context, notify);
        }


    public void scheduleAnNotification(Context context, String title, String text,int delay,int notificationId){

        Notification.Builder builder = new Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(text)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        Notification notification = builder.build();
        NotificationManager notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notificationId, notification);
    }

}
