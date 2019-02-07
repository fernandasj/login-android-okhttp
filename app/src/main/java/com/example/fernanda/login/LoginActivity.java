package com.example.fernanda.login;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button = findViewById(R.id.button);
        final TextView email = findViewById(R.id.editTextEmail);
        final TextView password = findViewById(R.id.editTextPass);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button.setText("Aguarde");
                HttpService httpService = new HttpService();
                String result = httpService.loginStart(email.getText().toString(), password.getText().toString());
                Toast.makeText(getApplicationContext(), result , Toast.LENGTH_LONG);
            }
        });
    }
}
