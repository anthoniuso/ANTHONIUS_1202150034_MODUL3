package com.levegra.anthonius_1202150034_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername =  (EditText) findViewById(R.id.username_field);
        mPassword =  (EditText) findViewById(R.id.password_field);
        Button login = (Button) findViewById(R.id.button_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LOGIN", "Masuk ke button");
                Log.d("Text", mUsername.getText().toString() + " Usernamenya");
                Log.d("Text", mPassword.getText().toString() + " Passwordnya");
                if(mUsername.getText().toString().equals("EAD") && mPassword.getText().toString().equals("MOBILE")) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                } else {
                    Toast fail = Toast.makeText(getApplicationContext(), "Gagal Login !", Toast.LENGTH_SHORT);
                    fail.show();
                }
            }
        });
    }
}
