package com.example.gautam.project;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.View;

import java.util.List;
/**
 * Created by gts on 13/10/15.
 */
public class DaysPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Day> days;

    public DaysPagerAdapter(FragmentManager fragmentManager,List<Day> rootCategories){
        super(fragmentManager);
        this.days=rootCategories;
    }

    @Override
    public int getCount() {
        return days!= null ? days.size():0;
    }

    @NonNull
    private DayFragment getDayFragment(int position){
        DayFragment fragment =new DayFragment();
        return fragment;
    }

    public CharSequence getPageTitle(int position){
        return days!= null ? days.get(position).getTitle():"";
    }

    @Override
    public Fragment getItem(int position) {
        return getDayFragment(position);
    }

    public boolean isViewFromObject(View view,Object object){
        return false;
    }


}