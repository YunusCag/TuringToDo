package com.yunuscagliyan.turingtodo.asistants;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class TuringApp extends Application {

    public static void writeSharedFirstTime(Context context, boolean firstTime){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(Constants.FIRST_TIME_SHARED_PREFERENCE,firstTime);
        editor.apply();
    }
    public static boolean readSharedFirstTime(Context context){
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        boolean firstTime=preferences.getBoolean(Constants.FIRST_TIME_SHARED_PREFERENCE, true);
        return firstTime;

    }
}
