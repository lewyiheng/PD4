package com.example.pd4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class chatbot extends AppCompatActivity {

    WebView chatbotview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        chatbotview = findViewById(R.id.chatBotView);
        WebSettings webSettings = chatbotview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        chatbotview.loadUrl("file:///android_asset/chatbot.html");
    }
}
