package com.jordanburke.messagingappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InsertRankActivity extends AppCompatActivity {

    @BindView(R.id.rank_text_box)
    protected EditText rankInput;
    @BindView(R.id.add_rank_button)
    protected Button addRank;


    @Override
    protected void onCreate(Bundle savedInstanceState) throws RuntimeException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_rank);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.add_rank_button)
    protected void rankButtonPress()  {
        String rankStringInput = rankInput.getText().toString();
//        if (rankStringInput.equals("SILVER4")) {
//            siegeRank.setBackground(getResources().getDrawable(R.drawable.silver_four_rank));
//        } else if (rankStringInput.equals("SILVER3")) {
//            siegeRank.setBackground(getResources().getDrawable(R.drawable.silver_three_rank));
//        } else if (rankStringInput.equals("SILVER2")) {
//            siegeRank.setBackground(getResources().getDrawable(R.drawable.silver_two_rank));
//        } else if (rankStringInput.equals("SILVER1")) {
//            siegeRank.setBackground(getResources().getDrawable(R.drawable.silver_one_rank));
//        } else {
//
//        }


        Intent toMessage = new Intent(this, MessagingActivity.class);
        toMessage.putExtra("RANK_VALUE", rankStringInput);
        startActivity(toMessage);
    }

}
