package com.example.estateempires;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.txtusername);
        password = (EditText) findViewById(R.id.txtpassword);
        btnLogin = (Button) findViewById(R.id.btnLogIn);

        myDB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = username.getText().toString();
                String pss = password.getText().toString();

                if (usr.equals("") || pss.equals("")) {
                    Toast.makeText(LoginActivity.this, "Insert all credentials.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result = myDB.checkusername_Password(usr,pss);
                    if(result==true) {
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid credentials.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}