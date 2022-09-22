package com.basudev.news.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.basudev.news.Adapter.ViewpagerAdapter;

import android.content.DialogInterface;
import android.os.Bundle;

import com.basudev.news.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem home,science,health,tech,entertainment,sports;
    ViewpagerAdapter adapter;
    Toolbar toolbar;
    ViewPager viewPager;
    String api="a0b796bbc7934fdf982268b0df9b0154";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);home=findViewById(R.id.home);
        science=findViewById(R.id.science);
        sports=findViewById(R.id.sports);
        tech=findViewById(R.id.technology);
        entertainment=findViewById(R.id.entertainment);
        health=findViewById(R.id.health);
        viewPager=findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.tabLayout);
        adapter=new ViewpagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                        finish();
                    }
                }).create().show();
    }

}