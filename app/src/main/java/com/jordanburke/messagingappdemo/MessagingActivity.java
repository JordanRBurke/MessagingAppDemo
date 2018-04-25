package com.jordanburke.messagingappdemo;

import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jordanburke.messagingappdemo.SettingsActivity.PREF_TAG;

public class MessagingActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private MessageAdapter adapter;
    private RecyclerView recyclerView;
    private List<Messages> messageList;
    @BindView(R.id.send_button)
    protected Button sendButton;
    private EditText userMessageText;
    private TextView userName;
    private String userNameString;
    @BindView(R.id.chat_groups_button)
    protected Button chatGroupButton;
    private String rankStringInput;





    @Override
    protected void onCreate(Bundle savedInstanceState) throws IllegalStateException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);
        ButterKnife.bind(this);
        userName = findViewById(R.id.username_view);
        userMessageText = findViewById(R.id.user_message_textbox);
        databaseReference = FirebaseDatabase.getInstance().getReference("SIEGE");
        DatabaseReference csgoChild = databaseReference.child("CSGO");
        DatabaseReference seaOfThiefsChild = databaseReference.child("SEA_OF_THIEVES");
        csgoChild.setValue("");
        databaseReference.child("RainbowSixSiege").push();
        messageList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rankStringInput = getIntent().getStringExtra("RANK_VALUE");
        userNameString = getIntent().getStringExtra("EMAIL_INFO");
        adapter = new MessageAdapter(messageList, rankStringInput);
        recyclerView.setAdapter(adapter);
        backgroundChanger();

//        changeNameColor();




    }
    @OnClick(R.id.send_button)
    protected void sendButtonPressed()  {
        String userNameIntent = getIntent().getStringExtra("EMAIL_INFO");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isChecked = prefs.getBoolean(PREF_TAG, false);
        if (isChecked) {
            notification();
        }

        Messages newMessage = new Messages(userMessageText.getText().toString(), userNameIntent, getUrl());
        databaseReference.push().setValue(newMessage);
        userMessageText.setText("");

    }

    private String getUrl() {
        switch (rankStringInput) {
//            case "SILVER1":
//                return "https://www.google.com/search?q=Silver+1+siege+rank&" +
//                        "source=lnms&tbm=isch&sa=X&ved=0ahUKEwjDrdGsrLDaAhUm" +
//                        "6YMKHedqDfQQ_AUICigB&biw=878&bih=572#imgrc=kyAjK24XlLZLqM:";
//
//            case "GOLD4":
//                return "https://www.google.com/search?tbm=isch&q=rainbow+six+siege" +
//                        "+silver+3+rank&chips=q:rainbow+six+siege+silver+3+rank,on" +
//                        "line_chips:gold&sa=X&ved=0ahUKEwjH0ciir7DaAhUk8IMKHePFDJ0" +
//                        "Q4lYIMCgI&biw=878&bih=572&dpr=2#imgrc=6pUI_CSSitBNKM:";
//            case "GOLD3":
//                return "https://www.google.com/search?tbm=isch&q=rainbow+six+sie" +
//                        "ge+silver+3+rank&chips=q:rainbow+six+siege+silver+3+rank" +
//                        ",online_chips:gold&sa=X&ved=0ahUKEwjH0ciir7DaAhUk8IMKHePFD" +
//                        "J0Q4lYIMCgI&biw=878&bih=572&dpr=2#imgdii=qMFf_mHDhegSFM:&im" +
//                        "grc=6pUI_CSSitBNKM:";
            default:
                return null;

        }
    }

    @OnClick(R.id.chat_groups_button)
    protected void chatGroupsButtonPressed() {
        Intent chatGroups = new Intent(this, ChatGroupActivity.class);
        startActivity(chatGroups);


    }

    @Override
    protected void onResume() {
        super.onResume();
        initMessages();
        csgoChild();
    }

    private void changeNameColor() {
        //save a boolean value to a shared pref, isEnabled or isDisabled
        // then, onCreate call a method that loads that value:
        //if isEnabled, then push notificarions should send
        // if isDisabled, they shouldn't.
        //so, if isEnabled (notification()) else, don't call notification
    }



    private void initMessages() {

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                messageList.add(dataSnapshot.getValue(Messages.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

    private void csgoChild() {
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                messageList.add(dataSnapshot.getValue(Messages.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




        private void backgroundChanger() {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            boolean isChecked = prefs.getBoolean(PREF_TAG, false);
            if (isChecked == true) {
                recyclerView.setBackground(getResources().getDrawable(R.drawable.dark_ocean_background_new));
            } else {
//                recyclerView.setBackground(getResources().getDrawable(R.drawable.space_background));
            }
        }



//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    messageList.add();
//                    adapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });




    public void notification() {
        NotificationCompat.Builder boxBuilder = new NotificationCompat.Builder(this, "BUILDER_BOX")
                .setSmallIcon(R.drawable.cool_space)
                .setContentTitle("Incoming Message")
                .setContentText("You have recieved message :)")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(Notification.DEFAULT_VIBRATE);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(5, boxBuilder.build());

        int importanceLevel = NotificationManagerCompat.IMPORTANCE_DEFAULT;



    }
}
