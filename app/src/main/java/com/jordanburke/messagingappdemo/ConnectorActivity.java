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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConnectorActivity extends AppCompatActivity {

    private String userNameString;
    @BindView(R.id.email_connector_holder)
    protected TextView placeholderForEmail;
    @BindView(R.id.main_navigation_view)
    protected BottomNavigationView bottomNavigationView;
    private PublicChatGroupFragment publicChatGroupFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connector);
        ButterKnife.bind(this);

        userNameString = getIntent().getStringExtra("EMAIL_INFO");
        placeholderForEmail.setText(userNameString);
        bottomNavigation();

    }

    private void bottomNavigation() {
//        bottomNavigationView.findViewById(R.id.main_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//                Intent toPublic = new Intent(this, ChatGroupActivity.class);
//                startActivity(toPublic);
                switch (item.getItemId()) {
                    case R.id.group_chat_navigation:
                        toastMessage("Group Chats");
                        publicChatGroupFragment = PublicChatGroupFragment.newInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.connector_frame_layout, publicChatGroupFragment).commit();
                        return true;

                    case R.id.private_chat_navigation:
                        toastMessage("Private Chats");
                        Intent toPrivate = new Intent(getBaseContext(), PrivateChatActivity.class);
                        startActivity(toPrivate);
                        return true;

                    case R.id.search_chat_navigation:
                        toastMessage("Search");

                        return true;

                    default:
                        toastMessage("Error");
//                        return ConnectorActivity.super.onOptionsItemSelected(item);
                }


                return false;
            }
        });

    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


    }
}
