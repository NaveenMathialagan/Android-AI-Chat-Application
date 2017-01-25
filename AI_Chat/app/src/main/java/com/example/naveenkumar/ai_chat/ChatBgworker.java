package com.example.naveenkumar.ai_chat;

import android.os.AsyncTask;
import android.util.Log;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

import java.util.List;
import java.util.Random;

/**
 * Created by Naveen kumar on 02-10-2016.
 */

public class ChatBgworker extends AsyncTask<String, Void, String>{


    ChatAdapter ad;
    List<ChatMessage> chat1;
   static int previos=9;
    String[] mres={"hmm..wat you doing","ok..how old are you?","ok..had a dinner?","ok","hmm...where are you?","hmm","ok then","fine"};

    public ChatBgworker(List<ChatMessage> chat1,ChatAdapter ad){
        this.chat1=chat1;
        this.ad=ad;


    }

    @Override
    protected String doInBackground(String... p) {
        Bot bot = new Bot("super", p[1]);
        Chat chatSession = new Chat(bot);
        //String request =
        //String request = "What is your name?";
        String response = chatSession.multisentenceRespond(p[0]);
        Log.v("nhh", "response = " + response);
        return response;
    }
    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        int i;
        ChatMessage cm = new ChatMessage();
        if (response.equals("I have no answer for that.")){

            i=new Random().nextInt(8);
            if (i==previos){
                while (!(i==previos)){
                    i=new Random().nextInt(8);
                }
            }
            previos=i;
            cm.setText(mres[i]);
            cm.setLeft(true);
            chat1.add(cm);
            new ChatAdapter(chat1);
            ad.notifyDataSetChanged();
        }else{
            cm.setText(response);
            cm.setLeft(true);
            chat1.add(cm);
            new ChatAdapter(chat1);
            ad.notifyDataSetChanged();
        }


    }
    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }
}
