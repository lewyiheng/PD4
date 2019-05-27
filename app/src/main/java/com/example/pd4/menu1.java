package com.example.pd4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.lang.String;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class menu1 extends AppCompatActivity {
    ListView lv;
    ArrayList<gameObjects> al;
    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference userDB = db.getReference("hotDeals/game1");

       /* userDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //gameObjects gameInfo = dataSnapshot.getValue(gameObjects.class);
                gameObjects gameInfo = dataSnapshot.child("game1").getValue(gameObjects.class);

                String title = gameInfo.getName();
                String image = gameInfo.getImage();
                String discount = gameInfo.getDiscount();
                String price = gameInfo.getPrice();

                al = new ArrayList<gameObjects>();
                al.add(new gameObjects(title,image,discount,price));
                aa = new gameAdapter(menu1.this,R.layout.game_row,al);
                lv.setAdapter(aa);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

       lv = findViewById(R.id.lvGamesList1);

        al = new ArrayList<gameObjects>();
        al.add(new gameObjects("Overwatch","59.90"));
        al.add(new gameObjects("PAYDAY 2","29.99"));

        aa = new gameAdapter(menu1.this,R.layout.game_row,al);
        lv.setAdapter(aa);


lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {
            Intent intent = new Intent(menu1.this,webview.class);
            intent.putExtra("link","file:///android_asset/overwatch.html");
            startActivity(intent);
        }


    }

});



}}
