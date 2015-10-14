package com.example.gautam.project;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by gts on 7/10/15.
 */
public class Trip4mefrag extends Fragment {
 private Activity2 activity;
  ImageView img;
    public Trip4mefrag(Activity2 activity2) {
 this.activity=activity2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup cointainer, Bundle savedInstancestate) {
        View v = inflater.inflate(R.layout.tripformeui, cointainer, false);
        ImageView img = (ImageView) v.findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Log.i("TRIP FRAGMENT", "Trip fragment");
                        Searchfrag fragserach = new Searchfrag(activity);
                        activity.replaceFragment(fragserach);
            }
        });
return v;
    }
}

