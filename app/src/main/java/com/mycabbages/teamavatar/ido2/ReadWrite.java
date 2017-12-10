package com.mycabbages.teamavatar.ido2;

import android.app.Activity;
import android.app.Notification;
import android.content.SharedPreferences;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Pair;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Conrad on 11/8/2017.
 */

public class ReadWrite extends Activity {

    public String readFromFirebace(String key){
        return "String FB";
    }
    public void writeToFirebace(String key, String data){

    }

    public String readFromPhone(String key){ return "String Phone"; }
    public void writeToPhone(String key, String data){

    }
    // this adds a new nodification to the arraylist and saves the list to the phone
    public void addNotification(Context context, String title, String message,long sendTime)throws FileNotFoundException{
        System.out.println("added new notification");
        List<PushNotification> newlist = loadPushNotificationList(context);

        PushNotification notification = new PushNotification();
        notification.setTimeToSend(sendTime);
        notification.setMessage(message);
        notification.setNotificationTitle(title);
        newlist.add(notification);

        savePushNotificationList(context, newlist);
    }
    // this loads the push notifications saved to the phone to memory
    public List<PushNotification> loadPushNotificationList(Context context) throws FileNotFoundException {
        List<PushNotification> loadList;
        SharedPreferences sharedPreferences = context.getSharedPreferences("notifications", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Notification list",null);
        Type type = new TypeToken<ArrayList<PushNotification>>() {}.getType();
        loadList = gson.fromJson(json,type);

        if (loadList == null){
            loadList = new ArrayList<>();
        }
        return loadList;
    }
    //this saves all the new notifications that need to be pushed later onto the phone
    public void savePushNotificationList(Context context , List<PushNotification> notification) throws FileNotFoundException{
        SharedPreferences sharedPreferences = context.getSharedPreferences("notifications", MODE_PRIVATE);
        SharedPreferences.Editor editor  = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(notification);
        editor.putString("Notification list", json);
        editor.apply();
    }
}