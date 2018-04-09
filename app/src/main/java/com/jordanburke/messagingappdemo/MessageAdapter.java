package com.jordanburke.messagingappdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by jordanburke on 3/19/18.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {


    private final String rankStringInput;
    private List<Messages> messagesList;

    public MessageAdapter(List<Messages> messagesList, String rankStringInput) {
        this.messagesList = messagesList;
        this.rankStringInput = rankStringInput;
    }

    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_messages, parent, false);
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.MessageViewHolder holder, int position) {
        holder.bindMessages(messagesList.get(position));

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        public TextView message;
        public TextView userName;
        public ImageView rankStatus;

        public MessageViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.user_message);
            userName = itemView.findViewById(R.id.username_view);
            rankStatus = itemView.findViewById(R.id.rainbow_image_view);

        }

        public void bindMessages(Messages messages) {
            userName.setText(messages.getUserName());
            message.setText(messages.getUserMessage());
            rankCheck();

        }

        private void rankCheck() {
            if (rankStringInput.equals("SILVER4")) {
//                rankStatus.setBackground(itemView.getResources().getDrawable(R.drawable.silver_four_rank));
                Glide.with(itemView.getContext()).load(R.drawable.silver_four_rank).into(rankStatus);
            } else if (rankStringInput.equals("SILVER3")) {
                rankStatus.setBackground(itemView.getResources().getDrawable(R.drawable.silver_three_rank));
            } else if (rankStringInput.equals("SILVER2")) {
                rankStatus.setBackground(itemView.getResources().getDrawable(R.drawable.silver_two_rank));
            } else if (rankStringInput.equals("SILVER1")) {
                rankStatus.setBackground(itemView.getResources().getDrawable(R.drawable.silver_one_rank));
            } else {

            }

        }

    }
}
