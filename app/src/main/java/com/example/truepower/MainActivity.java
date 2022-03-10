package com.example.truepower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    MealFragment mealFragment = new MealFragment();
    TodoFragment todoFragment = new TodoFragment();
    WorkoutFragment workoutFragment = new WorkoutFragment();
    HealthFragment healthFragment = new HealthFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            public boolean onNavigationItemSelected(MenuItem item){

                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.health:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,healthFragment).commit();
                        return true;
                    case R.id.meal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,mealFragment).commit();
                        return true;
                    case R.id.todo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,todoFragment).commit();
                        return true;
                    case R.id.workout:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,workoutFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}