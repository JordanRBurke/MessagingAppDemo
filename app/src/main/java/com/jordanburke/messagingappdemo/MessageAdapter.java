package com.jordanburke.messagingappdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jordanburke on 3/19/18.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {


    private List<Messages> messagesList;

    public MessageAdapter(List<Messages> messagesList) {
        this.messagesList = messagesList;
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

        public MessageViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.user_message);
            userName = itemView.findViewById(R.id.username_view);
        }

        public void bindMessages(Messages messages) {
            userName.setText(messages.getUserName());
            message.setText(messages.getUserMessage());
        }

    }
}
