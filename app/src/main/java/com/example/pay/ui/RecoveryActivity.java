package com.example.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pay.R;
import com.example.pay.roomdatabase.UserDao;
import com.example.pay.roomdatabase.UserDatabase;
import com.example.pay.roomdatabase.UserEntity;

public class RecoveryActivity extends AppCompatActivity {

    EditText email;
    Button recovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        email = findViewById(R.id.email);
        recovery = findViewById(R.id.recovery);

        recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                if (emailText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Harap isi semua", Toast.LENGTH_SHORT).show();
                } else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.recovery(emailText);
                            if (userEntity == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Tidak valid", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                startActivity(new Intent(RecoveryActivity.this, SignInActivity.class));
                            }
                        }
                    }).start();
                }
            }
        });
    }
}