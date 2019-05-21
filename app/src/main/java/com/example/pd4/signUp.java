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

public class signUp extends AppCompatActivity {

    EditText userUp, pwUp;
    Button btnUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userUp = findViewById(R.id.UpUser);
        pwUp = findViewById(R.id.UpPw);
        btnUp = findViewById(R.id.btnSignUp);

        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference userDB = db.getReference("Users");

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userDB.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //check existance
                        if(dataSnapshot.child(userUp.getText().toString()).exists()){
                            Toast.makeText(signUp.this, "Username already exists", Toast.LENGTH_SHORT).show();
                        }else{
                            User user = new User(userUp.getText().toString(), pwUp.getText().toString());
                            userDB.child(userUp.getText().toString()).setValue(user);
                            Toast.makeText(signUp.this,"Successfully Registerd", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(signUp.this,MainActivity.class);
                            i.putExtra("User", userUp.getText().toString());
                            i.putExtra("Pass", pwUp.getText().toString());
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
