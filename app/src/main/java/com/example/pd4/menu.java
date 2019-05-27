package com.example.pd4;

import android.content.Intent;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class menu extends AppCompatActivity {

    ListView lv;
    ArrayList<menuObjects> al;
    ArrayAdapter aa;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lv = findViewById(R.id.lvMenu);

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

                if (position == 1) {
                    Intent i = new Intent(menu.this, menu2.class);
                    startActivityForResult(i, 0);
                }

                if (position == 2) {
                    Intent i = new Intent(menu.this, menu3.class);
                    startActivityForResult(i, 0);
                }else{
                    Intent i = new Intent(menu.this, maintainance.class);
                    startActivityForResult(i, 0);
                }

            }
        });
    }
}
