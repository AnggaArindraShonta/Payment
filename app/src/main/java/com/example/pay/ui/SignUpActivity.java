package com.example.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pay.R;
import com.example.pay.bottomnav.MainActivity;
import com.example.pay.roomdatabase.UserDao;
import com.example.pay.roomdatabase.UserDatabase;
import com.example.pay.roomdatabase.UserEntity;

public class SignUpActivity extends AppCompatActivity {

    EditText email, password, confirm;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setEmail(email.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setConfirm(confirm.getText().toString());
                if (validateInput(userEntity)) {
                    if (password.getText().toString().equals(confirm.getText().toString())) {
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
                                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                    }
                                });
                            }
                        }).start();
                   } else {
                        Toast.makeText(getApplicationContext(), "Password harus sama", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Harap isi semua dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private Boolean validateInput(UserEntity userEntity) {
        if (userEntity.getEmail().isEmpty() ||
                userEntity.getPassword().isEmpty() ||
                userEntity.getConfirm().isEmpty()) {
            return false;
        }
        return true;
    }
}