package com.jordanburke.messagingappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatGroupActivity extends AppCompatActivity {

    @BindView(R.id.rainbow_six_button)
    protected Button rainbowSixButton;
    @BindView(R.id.csgo_button_group)
    protected Button csgoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rainbow_six_button)
    protected void rainbowOnPress() {
        Intent messageIntent = new Intent(this, InsertRankActivity.class);
        startActivity(messageIntent);
    }

    @OnClick(R.id.csgo_button_group)
    protected void csgoButtonPress() {
        Intent messageIntent = new Intent(this, InsertRankActivity.class);
        startActivity(messageIntent);
    }
}
