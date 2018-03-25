package com.jordanburke.messagingappdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jordanburke on 3/19/18.
 */

public class Messages {
    public Messages(String userMessage, String userName) {
        this.userMessage = userMessage;
        this.userName = userName;
    }

    private String userMessage;
    private String userName;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public Messages() {

    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage() {
        this.userMessage = userMessage;
    }

}

//public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
//
//    public class MessageViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView message;
//
//    public MessageViewHolder(View itemView) {
//
//            super(itemView);
////          message = (TextView) itemView.findViewById();
//
//
//        }
//    }














