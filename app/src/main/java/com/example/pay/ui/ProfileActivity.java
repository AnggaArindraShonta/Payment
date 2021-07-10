package com.example.pay.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pay.R;
import com.example.pay.bottomnav.MainActivity;
import com.example.pay.roomdatabase.UserDao;
import com.example.pay.roomdatabase.UserDatabase;
import com.example.pay.roomdatabase.UserEntity;

public class ProfileActivity extends AppCompatActivity {

    EditText email, name, address;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setEmail(name.getText().toString());
                userEntity.setPassword(address.getText().toString());
                String emailText = email.getText().toString();
                String nameText = name.getText().toString();
                String addressText = address.getText().toString();
                if (validateInput(userEntity)) {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                                }
                            });
                        }
                    }).start();
                } else {
                    if (emailText.isEmpty() || nameText.isEmpty() || addressText.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Harap isi semua", Toast.LENGTH_SHORT).show();
                    } else {
                        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                        UserDao userDao = userDatabase.userDao();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                UserEntity userEntity = userDao.profile(emailText);
                                if (userEntity == null) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(), "Tidak valid", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                                }
                            }
                        }).start();
                    }
                }
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity) {
        if (userEntity.getEmail() == null ||
                userEntity.getName() == null ||
                userEntity.getAddress() == null) {
            return false;
        }
        return true;
    }
}