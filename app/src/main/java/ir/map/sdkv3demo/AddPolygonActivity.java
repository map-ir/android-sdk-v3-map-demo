package ir.map.sdkv3demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ir.map.sdk_map.annotations.PolygonOptions;
import ir.map.sdk_map.geometry.LatLng;
import ir.map.sdk_map.maps.MapirMap;
import ir.map.sdk_map.maps.SupportMapFragment;

public class AddPolygonActivity extends AppCompatActivity {

    private static final LatLng ARAK = new LatLng(34.0954, 49.7013);
    private static final LatLng SHIRAZ = new LatLng(29.591, 52.5837);
    private static final LatLng MASHHAD = new LatLng(36.2605, 59.6168);
    private static final LatLng RASHT = new LatLng(37.2682, 49.5891);

    private List polygonPointList = new ArrayList<>();
    private MapirMap mapirMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_map);

        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView))
                .getMapAsync(map -> {
                    mapirMap = map;
                    if (mapirMap != null) { // Checks if we were successful in obtaining the map

                        polygonPointList.add(ARAK);
                        polygonPointList.add(SHIRAZ);
                        polygonPointList.add(MASHHAD);
                        polygonPointList.add(RASHT);

                        mapirMap.addPolygon(new PolygonOptions()
                                .addAll(polygonPointList)
                                .fillColor(Color.TRANSPARENT)
                                .strokeColor(Color.BLUE));
                    }
                });
    }
}