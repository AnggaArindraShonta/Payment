package com.example.pay.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pay.R;
import com.example.pay.fragment.HomeFragment;

public class CodeActivity extends AppCompatActivity {

    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        pay = findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CodeActivity.this, "Payment Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CodeActivity.this, HomeFragment.class));
            }
        });

    }
}