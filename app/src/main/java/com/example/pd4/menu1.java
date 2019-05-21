package com.example.pd4;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.lang.String;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        userDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //gameObjects gameInfo = dataSnapshot.getValue(gameObjects.class);
                gameObjects gameInfo = dataSnapshot.child("game1").getValue(gameObjects.class);

                al = new ArrayList<gameObjects>();
                al.add(new gameObjects(gameInfo.name,gameInfo.image,gameInfo.discount,gameInfo.price));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






    }

}




