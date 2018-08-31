package com.aski.routin;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DashboardFragment extends Fragment {

    LocationManager locationManager;
    Location location;
    static final int REQUEST_LOCATION = 1;
    Button button ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, null);

        button = view.findViewById(R.id.loc);

        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        getLocation();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getLocation();
                Toast.makeText(getContext(),"Latitude : " +location.getLatitude() + "\nLongitude : "+location.getLongitude(),Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }

    void getLocation() {


        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);


        }else {

            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }
}