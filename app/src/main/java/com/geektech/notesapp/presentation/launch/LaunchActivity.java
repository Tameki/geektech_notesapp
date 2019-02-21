package com.geektech.notesapp.presentation.launch;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.notesapp.R;
import com.geektech.notesapp.presentation.intro.IntroActivity;
import com.geektech.notesapp.presentation.main.MainActivity;

public class LaunchActivity extends AppCompatActivity {

    private static String PREF_FIRST_LAUNCH = "first_launch";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);

        if (isFirstLaunch()) {
            IntroActivity.start(this);
            firstLaunch();
        } else {
            MainActivity.start(this);
        }
        finish();
    }

    //TODO: Save to shared prefs on first launch
    private boolean isFirstLaunch() {
        if (sharedPreferences.contains(PREF_FIRST_LAUNCH)) {
            return sharedPreferences.getBoolean(PREF_FIRST_LAUNCH, true);
        } else {
            return true;
        }
    }

    private void firstLaunch() {
        sharedPreferences.edit()
                .putBoolean(PREF_FIRST_LAUNCH, false)
                .apply();
    }
}
