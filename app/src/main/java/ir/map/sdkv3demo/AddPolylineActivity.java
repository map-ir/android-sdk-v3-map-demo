package ir.map.sdkv3demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.map.sdk_map.annotations.PolylineOptions;
import ir.map.sdk_map.geometry.LatLng;
import ir.map.sdk_map.maps.MapirMap;
import ir.map.sdk_map.maps.SupportMapFragment;

public class AddPolylineActivity extends AppCompatActivity {

    private static final LatLng ARAK = new LatLng(34.0954, 49.7013);
    private static final LatLng SHIRAZ = new LatLng(29.591, 52.5837);
    private static final LatLng RASHT = new LatLng(37.2682, 49.5891);

    private MapirMap mapirMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polyline);

        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView))
                .getMapAsync(map -> {
                    mapirMap = map;
                    if (mapirMap != null) // Checks if we were successful in obtaining the map
                        mapirMap.addPolyline((new PolylineOptions()).add(ARAK, SHIRAZ, RASHT));
                });
    }
}
