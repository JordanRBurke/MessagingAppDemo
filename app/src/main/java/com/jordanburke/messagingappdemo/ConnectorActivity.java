package com.jordanburke.messagingappdemo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConnectorActivity extends AppCompatActivity {

    private String userNameString;
    @BindView(R.id.email_connector_holder)
    protected TextView placeholderForEmail;
    @BindView(R.id.private_chat)
    protected Button privateChat;
    @BindView(R.id.public_chat_connector)
    protected Button publicChat;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connector);
        ButterKnife.bind(this);

        userNameString = getIntent().getStringExtra("EMAIL_INFO");
        placeholderForEmail.setText(userNameString);

    }

    private void bottomNavigation() {
        bottomNavigationView.findViewById(R.id.main_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//                Intent toPublic = new Intent(this, ChatGroupActivity.class);
//                startActivity(toPublic);
                
                return false;
            }
        });

    }
    @OnClick(R.id.private_chat)
    protected void onPrivatePress() {
        Intent toPrivate = new Intent(this, PrivateChatActivity.class);
        startActivity(toPrivate);
    }
    @OnClick(R.id.public_chat_connector)
    protected void onPublicPress() {

    }
}
