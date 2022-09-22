package com.basudev.news.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.basudev.news.Fragments.EntertainmentFragment;
import com.basudev.news.Fragments.HealthFragment;
import com.basudev.news.Fragments.HomeFragment;
import com.basudev.news.Fragments.ScienceFragment;
import com.basudev.news.Fragments.SportsFragment;
import com.basudev.news.Fragments.TechnologyFragment;

public class ViewpagerAdapter extends FragmentPagerAdapter {

    int tabcount;
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();

            case 1:
                return new SportsFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechnologyFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
