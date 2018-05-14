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
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
            message = itemView.findViewById(R.id.user_message);
            userName = itemView.findViewById(R.id.username_view);
            rankStatus = itemView.findViewById(R.id.rainbow_image_view);

        }

        public void bindMessages(Messages messages) {
            userName.setText(messages.getUserName());
            message.setText(messages.getUserMessage());
//            Glide.with(itemView.getContext()).load("https://www.google.com/search?q=space+background+images&source=lnms&tbm=isch&sa=X&ved=0ahUKEwit-6_3va7aAhVCoVMKHUtlCxsQ_AUICigB&biw=722&bih=694#imgrc=Gs_tzt6CEZ45HM:").into(rankStatus);
            Glide.with(itemView.getContext()).load(messages.getUrl()).into(rankStatus);
//            add String url to Messages model based on ranking that the user enters in
            rankCheckSilverAndGold();
            rankCheckCopperAndBronze();
            rankCheckPlatinumAndDiamond();

        }

        private void rankCheckSilverAndGold() {
            if (rankStringInput.equals("SILVER4")) {
                Glide.with(itemView.getContext()).load(R.drawable.silver_four_rank).into(rankStatus);
            } else if (rankStringInput.equals("SILVER3")) {
                Glide.with(itemView.getContext()).load(R.drawable.silver_three_rank).into(rankStatus);
            } else if (rankStringInput.equals("SILVER2")) {
                Glide.with(itemView.getContext()).load(R.drawable.silver_two_rank).into(rankStatus);
            } else if (rankStringInput.equals("SILVER1")) {
                Glide.with(itemView.getContext()).load(R.drawable.silver_one_rank).into(rankStatus);
            } else if (rankStringInput.equals("GOLD4")) {
                Glide.with(itemView.getContext()).load(R.drawable.gold_four_rank).into(rankStatus);
            } else if (rankStringInput.equals("GOLD3")) {
                Glide.with(itemView.getContext()).load(R.drawable.gold_three_rank).into(rankStatus);
            } else if (rankStringInput.equals("GOLD2")) {
                Glide.with(itemView.getContext()).load(R.drawable.gold_two_rank).into(rankStatus);
            } else if (rankStringInput.equals("GOLD1")) {
                Glide.with(itemView.getContext()).load(R.drawable.gold_one_rank).into(rankStatus);
            }

        }

        private void rankCheckCopperAndBronze() {
            if (rankStringInput.equals("COPPER1")) {
                Glide.with(itemView.getContext()).load(R.drawable.copper_one_rank).into(rankStatus);
            } else if (rankStringInput.equals("COPPER2")) {
                Glide.with(itemView.getContext()).load(R.drawable.copper_two_rank).into(rankStatus);
            } else if (rankStringInput.equals("COPPER3")) {
                Glide.with(itemView.getContext()).load(R.drawable.copper_three_rank).into(rankStatus);
            } else if (rankStringInput.equals("COPPER4")) {
                Glide.with(itemView.getContext()).load(R.drawable.copper_four_rank).into(rankStatus);
            } else if (rankStringInput.equals("BRONZE1")) {
                Glide.with(itemView.getContext()).load(R.drawable.bronze_one_rank).into(rankStatus);
            } else if (rankStringInput.equals("BRONZE2")) {
                Glide.with(itemView.getContext()).load(R.drawable.bronze_two_rank).into(rankStatus);
            } else if (rankStringInput.equals("BRONZE3")) {
                Glide.with(itemView.getContext()).load(R.drawable.bronze_three_rank).into(rankStatus);
            } else if (rankStringInput.equals("BRONZE4")) {
                Glide.with(itemView.getContext()).load(R.drawable.bronze_four_rank).into(rankStatus);
            }

        }

        private void rankCheckPlatinumAndDiamond() {
            if (rankStringInput.equals("PLATINUM1")) {
                Glide.with(itemView.getContext()).load(R.drawable.platinum_one_rank).into(rankStatus);
            } else if (rankStringInput.equals("PLATINUM2")) {
                Glide.with(itemView.getContext()).load(R.drawable.platinum_two_rank).into(rankStatus);
            } else if (rankStringInput.equals("PLATINUM3")) {
                Glide.with(itemView.getContext()).load(R.drawable.platinum_three_rank).into(rankStatus);
            } else if (rankStringInput.equals("DIAMOND1")) {
                Glide.with(itemView.getContext()).load(R.drawable.diamond_rank).into(rankStatus);
            } else {

            }
        }

    }
}
