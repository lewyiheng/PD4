package com.example.pd4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class menu extends AppCompatActivity {

    ListView lv;
    ArrayList<menuObjects> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lv = findViewById(R.id.lvMenu);

        al = new ArrayList<menuObjects>();
        al.add(new menuObjects("Hot Deals",""));
        al.add(new menuObjects("Action Games", ""));
        al.add(new menuObjects("RTS Games", ""));

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
                }

            }
        });
    }
}
