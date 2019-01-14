package ir.map.sdkv3demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.map.sdk_map.annotations.Marker;
import ir.map.sdk_map.annotations.MarkerOptions;
import ir.map.sdk_map.geometry.LatLng;
import ir.map.sdk_map.maps.MapirMap;
import ir.map.sdk_map.maps.SupportMapFragment;

public class AddMarkerActivity extends AppCompatActivity {

    private static final LatLng TEHRAN = new LatLng(35.699773, 51.337888);
    private MapirMap mapirMap;
    private Marker mTehran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marker);

        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView))
                .getMapAsync(map -> {
                    mapirMap = map;

                    if (mapirMap != null) { // Checks if we were successful in obtaining the map
                        //TODO : Don't forget add a drawable named : ic_marker
                        //mTehran object hold marker instance for future use
                        mTehran = mapirMap.addMarker(new MarkerOptions()
                                .position(TEHRAN).title("Tehran").snippet("Population: 8,627,300"));
                    }
                });
    }
}