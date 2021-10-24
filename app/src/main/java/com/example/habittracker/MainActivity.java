package com.example.habittracker;

import android.content.Intent;
import android.os.Bundle;

import com.example.habittracker.ui.main.Fragment1;
import com.example.habittracker.ui.main.MotivationInsight;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.habittracker.ui.main.SectionsPagerAdapter;
import com.example.habittracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.add_habit, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button motivation = (Button) findViewById(R.id.motivation_button);
        motivation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent myintent =new Intent(v.getContext(), MotivationInsight.class);
                startActivity(myintent);
            }
        });
    }
}