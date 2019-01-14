package ir.map.sdkv3demo;

import android.app.Application;

import ir.map.sdk_map.Mapir;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //TODO Please add your ACCESS_TOKEN
        Mapir.getInstance(this, "mapir_ujhggl55415jhjf");
    }
}
