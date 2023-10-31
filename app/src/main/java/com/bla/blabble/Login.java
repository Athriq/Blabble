package com.bla.blabble;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
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
                Toast.makeText(Login.this, "You need to specify an alias", Toast.LENGTH_SHORT).show();
            }else {
                // TODO: tambah user session ke database
                Intent intent = new Intent(Login.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}