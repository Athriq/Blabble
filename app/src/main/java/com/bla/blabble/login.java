package com.bla.blabble;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class login extends AppCompatActivity {
    Button chooseTopicButton;
    EditText usernameEditText;
    FirebaseDatabase db;
    android.app.ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        getSupportActionBar().hide();
        db = FirebaseDatabase.getInstance();
        chooseTopicButton = findViewById(R.id.chooseTopicButton);
        usernameEditText = findViewById(R.id.usernameText);

        chooseTopicButton.setOnClickListener(v -> {
            String usernameInput = usernameEditText.getText().toString();

            if ((TextUtils.isEmpty(usernameInput))){
                progressDialog.dismiss();
                Toast.makeText(login.this, "You need to specify an alias", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(login.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}