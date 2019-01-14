package ir.map.sdkv3demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.mapbox.android.core.location.LocationEngineListener;

import ir.map.sdk_map.camera.CameraUpdateFactory;
import ir.map.sdk_map.geometry.LatLng;
import ir.map.sdk_map.location.LocationComponent;
import ir.map.sdk_map.maps.MapirMap;
import ir.map.sdk_map.maps.SupportMapFragment;

public class CurrentLocationActivity extends AppCompatActivity implements LocationEngineListener {

    private MapirMap mapirMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMapView))
                .getMapAsync(mapirMap -> {

                    CurrentLocationActivity.this.mapirMap = mapirMap;
                    if (CurrentLocationActivity.this.mapirMap != null) {
                        //region get permissions
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                            ActivityCompat.requestPermissions(
                                    CurrentLocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                            ActivityCompat.requestPermissions(
                                    CurrentLocationActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                        //endregion get permissions

                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                                && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                            LocationComponent component = CurrentLocationActivity.this.mapirMap.getLocationComponent();
                            component.activateLocationComponent(CurrentLocationActivity.this);
                            component.setLocationComponentEnabled(true);
                            if (component.getLocationEngine() != null) {
                                component.getLocationEngine().addLocationEngineListener(CurrentLocationActivity.this);
                            }
                            mapirMap.animateCamera(CameraUpdateFactory
                                    .newLatLngZoom(new LatLng(component.getLastKnownLocation().getLatitude(),
                                            component.getLastKnownLocation().getLongitude()), 14));
                        }
                    }
                });
    }

    @Override
    public void onConnected() {
    }

    @Override
    public void onLocationChanged(Location location) {
        //TODO add your code
        if (location != null)
            mapirMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 14));
    }
}


