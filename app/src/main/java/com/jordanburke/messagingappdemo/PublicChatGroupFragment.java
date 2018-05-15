package com.jordanburke.messagingappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PublicChatGroupFragment extends Fragment {

    @BindView(R.id.rainbow_six_button)
    protected Button rainbowSixButton;
    @BindView(R.id.csgo_button_group)
    protected Button csgoButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.public_chat_group_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static PublicChatGroupFragment newInstance() {

        Bundle args = new Bundle();

        PublicChatGroupFragment fragment = new PublicChatGroupFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.rainbow_six_button)
    protected void rainbowOnPress() {
        Intent messageIntent = new Intent(getContext(), InsertRankActivity.class);
        startActivity(messageIntent);
    }

    @OnClick(R.id.csgo_button_group)
    protected void csgoButtonPress() {
        Intent messageIntent = new Intent(getContext(), InsertRankActivity.class);
        startActivity(messageIntent);
    }
}
