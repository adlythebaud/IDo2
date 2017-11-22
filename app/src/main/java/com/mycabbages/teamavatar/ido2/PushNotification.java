package com.mycabbages.teamavatar.ido2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;

import com.mycabbages.teamavatar.ido2.fragment.GoalsFragment;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Preston on 11/17/2017.
 */

public class PushNotification extends Activity {
    //private boolean sent;
    private Date timeToSend;
    private String message;

    private String saveNotification;
    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";




    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;



    private static final String TAG = PushNotification.class.getSimpleName();
    public void setSent(boolean sent){
        this.sent = sent;
    }

    public boolean isSent() {
        return sent;
    }

    public Date getTimeToSend() {
        return timeToSend;
    }

    public void setTimeToSend(Date timeToSend) {
        this.timeToSend = timeToSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public void makeTheNotification(String notification, String title,int delay){
//
//        Notification.Builder noti = new Notification.Builder(this);
//        noti.setContentTitle(title);
//        noti.setContentText(notification);
//        noti.setSmallIcon(R.mipmap.ic_launcher);
//        scheduleThePushNotification(noti.build(),delay);
//
//    }
//    private  void scheduleThePushNotification(Notification notification, int delay) {
//
//        Intent notificationIntent = new Intent(this, PushIt.class);
//
//        notificationIntent.putExtra(PushIt.NOTIFICATION_ID, 1);
//        notificationIntent.putExtra(PushIt.NOTIFICATION, notification);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
//                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        long futureInMillis = SystemClock.elapsedRealtime() + delay;
//        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
//    }




//    public void pushthenotification(Context context, String title, String text,int delay,int notificationId) {
//        Intent intent = new Intent(this, PushNotification.class);
//        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
//        Notification.Builder builder = new Notification.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentText(text)
//                .setContentTitle(title)
//                .setContentIntent(pIntent)
//                .setAutoCancel(true);
//
//
//        NotificationManager notificationManager = (NotificationManager)getSystemService
//                (NOTIFICATION_SERVICE);
//
//
//        notificationManager.notify(0,builder.build() );
//
//    }


    public void alarmSet(){
        alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent2 = new Intent(this, PushNotification.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent2, 0);

        // Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);

        // setRepeating() lets you specify a precise custom interval--in this case,
        // 20 minutes.
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 10 /* 20*/, alarmIntent);
    }

    public void checknotifications(Goal goal){

    }


    public void scheduleAnNotification(Context context, String title, String text,int delay,int notificationId){
        Notification.Builder builder = new Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(text)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                //.setLargeIcon(R.mipmap.ic_launcher_round)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        //Intent intent = new Intent(context, PushNotification.class);
        //PendingIntent activity = PendingIntent.getActivity(context, notificationId,intent, PendingIntent.FLAG_CANCEL_CURRENT);
        //builder.setContentIntent(activity);
        Notification notification = builder.build();

        //Intent NotificationIntent = new Intent(context, PushIt.class);
        //NotificationIntent.putExtra(NOTIFICATION_ID, notificationId);
        //NotificationIntent.putExtra(NOTIFICATION, notification);
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(context, notificationId, NotificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService
                (Context.NOTIFICATION_SERVICE);

        //Notification notification1 = intent.getParcelableExtra(NOTIFICATION);
        //int id = intent.getIntExtra(NOTIFICATION_ID, 0);
        notificationManager.notify(0, notification);

//
//        long delayInMills = SystemClock.elapsedRealtime() + delay;
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, delayInMills, pendingIntent);
    }
}
