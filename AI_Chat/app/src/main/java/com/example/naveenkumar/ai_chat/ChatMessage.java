package com.example.naveenkumar.ai_chat;

import android.util.Log;

/**
 * Created by marco.granatiero on 30/09/2014.
 */
public class ChatMessage {
    public boolean left;
    public String text;


    public ChatMessage(){

    }
    public ChatMessage(boolean left, String text) {

        Log.d("Nav","Constructer working");
        this.left = left;
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public boolean getleft(){
        return this.left;
    }

    public void setText(String text){
       this.text=text;
    }
    public void setLeft(boolean left){
        this.left=left;
    }
}
