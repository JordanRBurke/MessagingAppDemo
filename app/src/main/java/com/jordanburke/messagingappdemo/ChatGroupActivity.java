package com.jordanburke.messagingappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class ChatGroupActivity extends AppCompatActivity {

    @BindView(R.id.rainbow_six_button)
    protected Button rainbowSixButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group);
    }

    @OnClick(R.id.rainbow_six_button)
    protected void rainbowOnPress() {

    }
}
