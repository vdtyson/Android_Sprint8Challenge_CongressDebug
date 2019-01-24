package com.lambdaschool.congressdata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


public class themeUtils {

    private static SharedPreferences prefs;
    private static int cTheme, counter;

    public static void nextTheme(Activity activity) {
        prefs = activity.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        switch (counter) {
            case 0:
                cTheme = R.style.AppTheme_Lambda_Dark;
                break;
            case 1:
                cTheme = R.style.AppTheme;
                break;
            case 2:
                cTheme = R.style.AppTheme_Dark;
                break;
            case 3:
                cTheme = R.style.AppTheme_Lambda;
                break;
        }
        counter = (counter + 1) % 4;

        editor.putInt("Theme", cTheme);
        editor.putInt("Counter", counter);
        editor.apply();
        changeToTheme(activity, cTheme);
    }

    public static void changeToTheme(Activity activity, int theme) {
        cTheme = theme;
        Intent intent = activity.getIntent();
        activity.finish();
        activity.startActivity(intent);
    }

    public static void refreshActivity(Activity activity) {
        Intent intent = activity.getIntent();
        activity.finish();
        activity.startActivity(intent);
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        activity.setTheme(cTheme);
    }

    public static int getcTheme(Activity activity) {
        if (cTheme == 0) {
            prefs = activity.getSharedPreferences("prefs", Context.MODE_PRIVATE);
            cTheme = prefs.getInt("Theme",R.style.AppTheme);
        }
        return cTheme;
    }
}
