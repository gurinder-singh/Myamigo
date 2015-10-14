package com.example.gautam.project;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by gts on 1/10/15.
 */
public class Activity2 extends AppCompatActivity {
    private static Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment5);
        setTitle("Search Trip");
        int position = getIntent().getIntExtra("POSITION", 0);
        Fragment newFragment = new Searchfrag(this);
        switch (position) {
            case 0:
                newFragment = new Searchfrag(this);


                Log.i("SearchFrag", "New fragment opens");
                break;
            case 1:

                Intent intent = new Intent(Activity2.this,Nearbyfrag.class);
                startActivity(intent);
                Log.i("Nearbyfargemnt"," New Fragment Nearby fragment");
                break;
            case 3:
                newFragment = new Trip4mefrag(this);
                break;
            default:
                newFragment = new Searchfrag(this);
        }

        replaceFragment(newFragment);
    }

    public void replaceFragment(Fragment newFragment) {
        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.activity2, newFragment, "searchframent");
        transaction.commit();
    }

}

