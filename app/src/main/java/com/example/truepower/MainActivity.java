package com.example.truepower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

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

    public void OpenAddRoutine(View view){
        Intent intent = new Intent(this, AddRoutine.class);
        startActivity(intent);
    }

    public void OpenAddMeal(View view){
        Intent intent = new Intent(this, AddMeal.class);
        startActivity(intent);
    }


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
                        setTitle("Home");
                        return true;
                    case R.id.health:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,healthFragment).commit();
                        setTitle("My Health");
                        return true;
                    case R.id.meal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,mealFragment).commit();
                        setTitle("My Meal");
                        return true;
                    case R.id.todo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,todoFragment).commit();
                        setTitle("My Routine");
                        return true;
                    case R.id.workout:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,workoutFragment).commit();
                        setTitle("My Workout");
                        return true;
                }
                return false;
            }
        });
    }
}