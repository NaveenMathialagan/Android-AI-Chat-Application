package com.example.naveenkumar.ai_chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView mrecyclerView;
    ChatAdapter adapter;
    EditText edTxt;

    List<ChatMessage> chat=new ArrayList<ChatMessage>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File fileExt = new File(getExternalFilesDir(null).getAbsolutePath() + "/bots");
        if (!fileExt.exists()) {
            ZipFileExtraction extract = new ZipFileExtraction();
            try {
                extract.unZipIt(getAssets().open("bots.zip"), getExternalFilesDir(null).getAbsolutePath() + "/");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        edTxt=(EditText)findViewById(R.id.chat_editText);
        mrecyclerView=(RecyclerView)findViewById(R.id.rv);
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ChatAdapter(chat);

        mrecyclerView.setAdapter(adapter);

    }
    public void send(View v)
    {
        String s=edTxt.getText().toString();
        if(s.equals("")){
            Toast.makeText(this,"Type the Message",Toast.LENGTH_SHORT).show();
        }else {
            edTxt.setText("");
            ChatMessage cm = new ChatMessage();
            cm.setText(s);
            cm.setLeft(false);
            chat.add(cm);
            new ChatAdapter(chat);
            adapter.notifyDataSetChanged();

            final String path1 = getExternalFilesDir(null).getAbsolutePath();
            ChatBgworker bw = new ChatBgworker(chat,adapter);
            bw.execute(s,path1);
        }
    }


}
