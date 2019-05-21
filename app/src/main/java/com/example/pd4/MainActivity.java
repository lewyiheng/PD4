package com.example.pd4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText user1, pw1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user1 = findViewById(R.id.username);
        pw1 = findViewById(R.id.password);
        Button in = findViewById(R.id.signIn);
        Button up = findViewById(R.id.signUp);

        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference userDB = db.getReference("Users");

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDB.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //chcek existance
                        if (dataSnapshot.child(user1.getText().toString()).exists()) {

                            User user = dataSnapshot.child(user1.getText().toString()).getValue(User.class);

                            if (user.getPassword().equals(pw1.getText().toString())) {
                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainActivity.this, menu.class);
                                startActivity(i);

                            } else {
                                Toast.makeText(MainActivity.this, "Wrong user/password!", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this,"You haven't signed up", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, signUp.class);
                startActivity(i);

            }
        });
    }
}
