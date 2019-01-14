package ir.map.sdkv3demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region initialize views
        Button btnBasicMap = findViewById(R.id.btn_basic_map);
        Button btnCurrentLocation = findViewById(R.id.btn_current_location);
        Button btnZoomLocation = findViewById(R.id.btn_zoom_location);
        Button btnAddMarker = findViewById(R.id.btn_add_marker);
        Button btnAddPolyline = findViewById(R.id.btn_add_polyline);
        Button btnAddPolygon = findViewById(R.id.btn_add_polygon);
        //endregion initialize views

        // region setup views
        btnBasicMap.setOnClickListener(this);
        btnCurrentLocation.setOnClickListener(this);
        btnZoomLocation.setOnClickListener(this);
        btnAddMarker.setOnClickListener(this);
        btnAddPolyline.setOnClickListener(this);
        btnAddPolygon.setOnClickListener(this);
        //endregion setup views
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_basic_map:
                startActivity(new Intent(MainActivity.this, BasicMapActivity.class));
                break;
            case R.id.btn_current_location:
                startActivity(new Intent(MainActivity.this, CurrentLocationActivity.class));
                break;
            case R.id.btn_zoom_location:
                startActivity(new Intent(MainActivity.this, ZoomLocationActivity.class));
                break;
            case R.id.btn_add_marker:
                startActivity(new Intent(MainActivity.this, AddMarkerActivity.class));
                break;
            case R.id.btn_add_polyline:
                startActivity(new Intent(MainActivity.this, AddPolylineActivity.class));
                break;
            case R.id.btn_add_polygon:
                startActivity(new Intent(MainActivity.this, AddPolygonActivity.class));
                break;
        }
    }
}
