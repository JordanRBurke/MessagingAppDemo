//package com.jordanburke.messagingappdemo;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
//import android.support.constraint.ConstraintLayout;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import java.util.jar.Attributes;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//import static com.jordanburke.messagingappdemo.SettingsActivity.PREF_TAG;
//
//public class NameSubmitActivity extends AppCompatActivity {
//
//    @BindView(R.id.name_text)
//    protected EditText userName;
//    @BindView(R.id.continue_button)
//    protected Button continueButton;
//
//    @BindView(R.id.name_submit_constraint)
//    protected ConstraintLayout settingsConstraint;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_name_submit);
//        ButterKnife.bind(this);
//        backgroundChanger();
//    }
//
//    @OnClick(R.id.continue_button)
//    protected void continueButtonPressed() {
//        String textName = userName.getText().toString();
//        Intent continueToPage = new Intent(NameSubmitActivity.this, MessagingActivity.class);
//        continueToPage.putExtra("USER_NAME" , textName);
//        startActivity(continueToPage);
//
//    }
//    private void backgroundChanger() {
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        boolean isChecked = prefs.getBoolean(PREF_TAG, false);
//        if (isChecked == true) {
//            settingsConstraint.setBackground(getResources().getDrawable(R.drawable.ocean_main_wallpaper));
//        } else {
//            settingsConstraint.setBackground(getResources().getDrawable(R.drawable.awesome_planet_in_space));
//        }
//    }
//
//
////    private void continueButtonPress()
//
//}
