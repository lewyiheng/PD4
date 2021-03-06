package com.example.pd4;

import android.content.Intent;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class menu extends AppCompatActivity {

    ListView lv;
    ArrayList<menuObjects> al;
    ArrayAdapter aa;
    LinearLayout ll;

    Button chatbox, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lv = findViewById(R.id.lvMenu);
        chatbox = findViewById(R.id.chatbot);
        email = findViewById(R.id.email);

        al = new ArrayList<menuObjects>();
        al.add(new menuObjects("Action Games", ""));
        al.add(new menuObjects("RTS Games", ""));
        al.add(new menuObjects("FPS Games",""));
        al.add(new menuObjects("Platformers",""));
        al.add(new menuObjects("MMOs",""));
        al.add(new menuObjects("RPGs", ""));

        //for (int i = 0; i <= al.size();i++){
         //   ll.setBackgroundResource([i]);
        //}


        aa = new menuAdapter(this, R.layout.menu_row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(menu.this, menu1.class);
                    startActivityForResult(i, 0);
                }

                else if (position == 1) {
                    Intent i = new Intent(menu.this, menu2.class);
                    startActivityForResult(i, 0);
                }

                else if (position == 2) {
                    Intent i = new Intent(menu.this, menu3.class);
                    startActivityForResult(i, 0);
                }else{
                    Intent i = new Intent(menu.this, maintainance.class);
                    startActivityForResult(i, 0);
                }

            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"lewyiheng@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose an Email client"));

            }
        });

        chatbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(menu.this,chatbot.class);
                startActivity(i);
            }
        });

    }
}
