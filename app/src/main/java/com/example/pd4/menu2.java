package com.example.pd4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class menu2 extends AppCompatActivity {

    ListView lv;
    ArrayList<gameObjects> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        lv = findViewById(R.id.lvGamesList1);

        al = new ArrayList<gameObjects>();
        al.add(new gameObjects("StarCraft II", "39.99"));

        aa = new gameAdapter(menu2.this, R.layout.game_row, al);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(menu2.this, webview.class);
                    intent.putExtra("link", "file:///android_asset/starcraft.html");
                    startActivity(intent);

                }
            }
        });
    }
}
