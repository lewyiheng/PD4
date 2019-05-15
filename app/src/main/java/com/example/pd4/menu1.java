package com.example.pd4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class menu1 extends AppCompatActivity {
    ListView lv;
    ArrayList<menuObjects> al;
    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference userDB = db.getReference("hotDeals");

        userDB.child("");
    }
}
