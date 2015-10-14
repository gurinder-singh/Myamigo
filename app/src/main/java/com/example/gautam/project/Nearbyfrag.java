package com.example.gautam.project;

import android.app.Activity;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Created by gts on 6/10/15.
 */
public class Nearbyfrag extends Activity{



    static final LatLng jk = new LatLng(15.38, 73.83);//airport

    static final LatLng zc = new LatLng(15.477103, 73.81);///caulo mall

    static final LatLng gu = new LatLng(15.4584136, 73.8345548);//Goa university
    static final LatLng TutorialsPoint = new LatLng(15.4608099, 73.8095574);

    private GoogleMap googleMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nearbyfrag2ui);
        Log.i("Google map ", "New Google map fragment");

        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }
            googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);




            Marker TP = googleMap.addMarker(new MarkerOptions().
                    position(TutorialsPoint).title("Dona paula").alpha(0.7f).icon(BitmapDescriptorFactory.fromResource(R.mipmap.aus)));


            Marker hamburg = googleMap.addMarker(new MarkerOptions().position(jk)
                    .title("Goa Airport").alpha(0.7f).icon(BitmapDescriptorFactory.fromResource(R.mipmap.aus)));
////



//            Marker ausi = googleMap.addMarker(new MarkerOptions().position(zc)
//                    .title("Caculo mall").anchor(0.5f,0.5f).rotation(0).flat(true).icon(BitmapDescriptorFactory.fromResource(R.mipmap.aus)));


            Marker jusi = googleMap.addMarker(new MarkerOptions().position(gu)
                    .title("Goa university").icon(BitmapDescriptorFactory.fromResource(R.mipmap.aus)));

            googleMap.setMyLocationEnabled(true);
            googleMap.addMarker(new MarkerOptions().position(gu)
                    .title("My location").icon(BitmapDescriptorFactory.fromResource(R.mipmap.aus)));



            googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

                @Override
                public void onMyLocationChange(Location location) {
                    //Get current location
                    LatLng position = new LatLng(location.getLatitude(), location.getLongitude());

                    //Add a marker with an image to current location
                    googleMap.addMarker(new MarkerOptions().position(position)
                            .title("My location")
                                    // .snippet("Home sweet home")
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.aus)));

                    //Zoom parameter is set to 14
                    CameraUpdate update = CameraUpdateFactory.newLatLngZoom(position, 11);

                    //Use map.animateCamera(update) if you want moving effect
                    googleMap.moveCamera(update);

                }
            });

            addLines();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addLines() {

        googleMap
                .addPolyline((new PolylineOptions())
                        .add(TutorialsPoint,jk, gu,TutorialsPoint
                        ).width(5).color(Color.BLUE)
                        .geodesic(true));
        // move camera to zoom on map
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jk,
                11));


    }

}










