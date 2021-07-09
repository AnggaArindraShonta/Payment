package com.example.pay.bottomnav;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.pay.R;
import com.example.pay.fragment.HistoryFragment;
import com.example.pay.fragment.HomeFragment;
import com.example.pay.fragment.PaymentFragment;
import com.example.pay.fragment.SettingsFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_CAMERA = 1;
    private Fragment fragment = null;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChipNavigationBar chipNavigationBar = findViewById(R.id.chipNavigation);

        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        chipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.ebook:
                    fragment = new PaymentFragment();
                    break;
                case R.id.assignment:
                    fragment = new HistoryFragment();
                    break;
                case R.id.video:
                    fragment = new SettingsFragment();
                    break;
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        initFunctionality();
    }
    private void initFunctionality() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_CAMERA);
        }
    }
}