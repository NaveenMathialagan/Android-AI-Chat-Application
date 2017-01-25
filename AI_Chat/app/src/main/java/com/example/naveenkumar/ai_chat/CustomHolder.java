package com.example.naveenkumar.ai_chat;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;



/**
 * Created by Naveen kumar on 03-03-2016.
 */
public class CustomHolder  extends RecyclerView.ViewHolder {
    public TextView msg;
    CardView cardView;

    public CustomHolder(View view) {
        super(view);
        this.msg = (TextView) view.findViewById(R.id.msg);
        this.cardView=(CardView) view.findViewById(R.id.cardMsg);
    }
}

