package com.jordanburke.messagingappdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jordanburke.messagingappdemo.SettingsActivity.PREF_TAG;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.begin_messaging)
    protected Button beginMessageButton;
    @BindView(R.id.settings_button)
    protected Button settingsButton;
    @BindView(R.id.login_button_main)
    protected Button mainLoginButton;


    private ConstraintLayout backgroundMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        backgroundMain = findViewById(R.id.constraint_main);
        backgroundChanger();



    }

    @OnClick(R.id.login_button_main)
    protected void loginButtonPress() {
        Intent loginAccount = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginAccount);

    }

    @OnClick(R.id.begin_messaging)
    protected void beginMessagePressed() {
        Intent createAccount = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(createAccount);
//        Intent submitName = new Intent(MainActivity.this, NameSubmitActivity.class);
//        startActivity(submitName);




    }
    @OnClick(R.id.settings_button)
    protected void settingButtonPressed() {
        Intent settings;
        settings = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(settings);
    }

    private void backgroundChanger() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isChecked = prefs.getBoolean(PREF_TAG, false);
        if (isChecked == true) {
//            backgroundMain.setBackground(getResources().getDrawable(R.drawable.ocean_main_wallpaper));
        } else {
            backgroundMain.setBackground(getResources().getDrawable(R.drawable.awesome_planet_in_space));
        }
    }

}
