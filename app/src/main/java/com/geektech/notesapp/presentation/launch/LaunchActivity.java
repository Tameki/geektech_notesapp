package com.geektech.notesapp.presentation.launch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.notesapp.R;
import com.geektech.notesapp.presentation.intro.IntroActivity;
import com.geektech.notesapp.presentation.main.MainActivity;

public class LaunchActivity extends AppCompatActivity {

    private static String PREF_FIRST_LAUNCH = "first_launch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        if (isFirstLaunch()) {
            IntroActivity.start(this);
        } else {
            MainActivity.start(this);
        }
    }

    //TODO: Save to shared prefs on first launch
    private boolean isFirstLaunch() {
        return true;
    }
}
