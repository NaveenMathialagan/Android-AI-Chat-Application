package com.example.naveenkumar.ai_chat;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by Naveen kumar on 03-03-2016.
 */
public class ChatAdapter extends RecyclerView.Adapter<CustomHolder>{

    //private Context mContext;
    List<ChatMessage> chatMsg;

    public ChatAdapter(List<ChatMessage> chatMsg) {

        this.chatMsg=chatMsg;
        Log.d("Noti","Adapdter constructor");
    }
    @Override
    public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ofr, parent, false);
        CustomHolder mh = new CustomHolder(v);

        Log.d("Noti","Adapdter oncreateView holder");

        return mh;
    }

    @Override
    public void onBindViewHolder(CustomHolder holder, int position) {
        final ChatMessage chat = chatMsg.get(position);
           holder.msg.setText(chat.getText());
        if (chat.getleft()){
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.cardView.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            params.setMargins(0,0,80,0);
            holder.cardView.setLayoutParams(params);
        }else{
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.cardView.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.setMargins(80,0,0,0);
            holder.cardView.setLayoutParams(params);

        }

    }

    @Override
    public int getItemCount() {
        return chatMsg.size();
    }
}
