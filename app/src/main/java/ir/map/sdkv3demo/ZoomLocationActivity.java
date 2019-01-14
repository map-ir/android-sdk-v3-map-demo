package ir.map.sdkv3demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.map.sdk_map.camera.CameraUpdateFactory;
import ir.map.sdk_map.geometry.LatLng;
import ir.map.sdk_map.maps.MapirMap;
import ir.map.sdk_map.maps.SupportMapFragment;

public class ZoomLocationActivity extends AppCompatActivity {

    //Change the following constants for getting your desired location
    public static final double FOCUSED_LATITUDE = 35.699773;
    public static final double FOCUSED_LONGITUDE = 51.337888;
    public static final int FOCUSED_ZOOM_LEVEL = 15;

    private MapirMap mapirMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_location);

        //TODO Zoom in Specific Location
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView))
                .getMapAsync(map -> {
                    mapirMap = map;
                    if (mapirMap != null) // Checks if we were successful in obtaining the map
                        mapirMap.animateCamera(CameraUpdateFactory
                                .newLatLngZoom(new LatLng(FOCUSED_LATITUDE, FOCUSED_LONGITUDE), FOCUSED_ZOOM_LEVEL));
                });
    }
}
