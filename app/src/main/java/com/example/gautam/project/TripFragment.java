package com.example.gautam.project;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TripFragment extends Fragment {
    @Override

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trip, container, false);
        initView(v);
        return v;
    }


    private void initView(View rootView) {
        ViewPager mPager = initPager(rootView);
        initTabs(rootView, mPager);
    }

    private void initTabs(View rootView, ViewPager mPager) {
        SlidingTabStripView mSlidingTabStripView = (SlidingTabStripView) rootView.findViewById(R.id.tabs);
        mSlidingTabStripView.setViewPager(mPager);
        mSlidingTabStripView.setCustomTabColorizer(new SlidingTabStripView.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.second_color);
            }

            @Override
            public int getDividerColor(int position) {
                return getResources().getColor(R.color.second_color);
            }
        });
    }

    @NonNull
    private ViewPager initPager(View rootView) {
        List<Day> days = new ArrayList<>();
        days.add(new Day("Day 1"));
        days.add(new Day("Day 2"));
        days.add(new Day("Day 3"));
        days.add(new Day("Day 4"));
        PagerAdapter mPagerAdapter =

                new DaysPagerAdapter(getActivity().getFragmentManager(),days);
        ViewPager mPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPager.setAdapter(mPagerAdapter);
        mPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getActivity().invalidateOptionsMenu();
            }
        });
        return mPager;
    }


}