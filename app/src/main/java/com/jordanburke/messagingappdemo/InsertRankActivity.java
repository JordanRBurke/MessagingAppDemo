package com.jordanburke.messagingappdemo;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_rank);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.add_rank_button)
    protected void rankButtonPress() {

        String rankStringInput = rankInput.getText().toString();
    }

}
