package com.example.truepower;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class StartActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    StartFragment startFragment = new StartFragment();
    SignUpFragment signUpFragment = new SignUpFragment();
    LoginFragment loginFragment = new LoginFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        bottomNavigationView = findViewById(R.id.bottom_navigation_start);

        getSupportFragmentManager().beginTransaction().replace(R.id.container_start,startFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.start:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_start,startFragment).commit();
                        setTitle("Start Here");
                        return true;

                    case R.id.login:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_start,loginFragment).commit();
                        setTitle("Login");
                        return true;

                    case R.id.signup:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_start,signUpFragment).commit();
                        setTitle("Sign Up");
                        return true;
                }
                return false;

            }
        });


    }
}