package com.jordanburke.messagingappdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.ServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.InflateException;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;


public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.back_button)
    protected Button backButton;
    @BindView(R.id.ocean_switch)
    protected Switch oceanSwitch;
    @BindView(R.id.heart_switch)
    protected Switch heartSwitch;
    private Switch notification;
    private ConstraintLayout background;
    private ConstraintLayout backgroundMain;
    private boolean oceanSwitchLabtop;
    public static final String PREF_TAG = "Locked";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        backButton = findViewById(R.id.back_button);
        oceanSwitch = findViewById(R.id.ocean_switch);
        heartSwitch = findViewById(R.id.heart_switch);
        background = findViewById(R.id.settings_constraint);
        notification = findViewById(R.id.notification_switch);
        backgroundMain = findViewById(R.id.constraint_main);



        oceanSwitchFlipped();
        notificationFlipped();
        checkingPrefValue();
        checkingPrefValueOcean();

    }

    private void checkingPrefValue() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isChecked = prefs.getBoolean(PREF_TAG, false);
        notification.setChecked(isChecked);


    }

    private void checkingPrefValueOcean() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isChecked = prefs.getBoolean(PREF_TAG, false);
        oceanSwitch.setChecked(isChecked);


    }

    private void notificationFlipped() {
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    prefs.edit().putBoolean(PREF_TAG, true).apply();
                } else {
                    prefs.edit().putBoolean(PREF_TAG, false).apply();
                }
            }
        });

    }

    private void oceanSwitchFlipped() {
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        oceanSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    prefs.edit().putBoolean(PREF_TAG, true).apply();
                    background.setBackground(getResources().getDrawable(R.drawable.ocean_background));
//                    backgroundMain.setBackground(getResources().getDrawable(R.drawable.ocean_background));


                } else {
                    prefs.edit().putBoolean(PREF_TAG, false).apply();
                    background.setBackground(getResources().getDrawable(R.drawable.awesome_planet_in_space));
                }
            }
        });

    }


    @OnClick(R.id.back_button)
    protected void backButtonPress() {
        // On back button press the onClickListener used the onClick and Intent below to
        // go back to the main menu
        Intent home = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(home);

    }
//    @OnCheckedChanged(R.id.ocean_switch)
//    protected void oceanSwitchOn() {
//        // Trying to change background for constraint layout
//        background.setBackground(getResources().getDrawable(R.drawable.ocean_background));
//
//    }
    @OnCheckedChanged(R.id.heart_switch)
    protected void heartSwitchOn() {
        background.setBackground(getResources().getDrawable(R.drawable.heart_wallpaper));

    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        oceanSwitchFlipped();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        oceanSwitchFlipped();
//
//    }




//    private void notificationSwitchFlipped() {
//        notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                notificationSwitchToggle = false;
//
//
//            }
//
//
//        });
//    }

}
