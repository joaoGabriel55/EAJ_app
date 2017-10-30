package com.example.quaresma.conhecendoeaj.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quaresma.conhecendoeaj.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment3 extends Fragment implements OnMapReadyCallback{

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.activity_fragment3, container, false);

        return mView;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstance){
        super.onViewCreated(v, savedInstance);

        mMapView = (MapView) mView.findViewById(R.id.map);

        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(40.689247, -74.044502)).title("Liberdade").snippet("hmm"));

        CameraPosition liberty = CameraPosition.builder().target(new LatLng(40.689247, -74.044502)).zoom(16).bearing(0).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));


    }
}
