package com.mycabbages.teamavatar.ido2;

import android.app.Notification;
import android.content.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Conrad on 11/8/2017.
 */

public class ReadWrite  {
    private SharedPreferences saveSettings;
    private SharedPreferences loadSettings;
    //File file = new File(this.getFilesDir(), "notifications");
    private final String saveLocation = "user/data";
    public String readFromFirebace(String key){
        return "String FB";
    }
    public void writeToFirebace(String key, String data){

    }
    public String readFromPhone(String key){
        //loadSettings = getSharedPreferences(saveLocation, Context.MODE_PRIVATE);
        return "String Phone";
    }

    public void writeToPhone(String key, String data){
        //saveSettings = getSharedPreferences();
        SharedPreferences.Editor editor = saveSettings.edit();
        editor.putString(key, data);
        editor.apply();
    }

    public void savePushNotifications(Notification notification){
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {

            fout = new FileOutputStream("notifications");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(notification);

            System.out.println("Done");

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}