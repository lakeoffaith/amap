package com.example.ijoy.amap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.SupportMapFragment;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;

public class MapOptionActivity extends FragmentActivity {
    static final CameraPosition cameraPosition=new CameraPosition.Builder().target(new LatLng(30.62275,104.068573))
            .zoom(18).bearing(0).tilt(30).build();
    private AMap aMap;
    private SupportMapFragment aMapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        AMapOptions aOptions=new AMapOptions();
        aOptions.zoomGesturesEnabled(false);
        //aOptions.scrollGesturesEnabled(false);
        aOptions.camera(cameraPosition);
        if(aMapFragment==null){
            aMapFragment=SupportMapFragment.newInstance(aOptions);
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(android.R.id.content,aMapFragment,"map");
            fragmentTransaction.commit();
        }
    }
    @Override
    protected  void onResume(){
        super.onResume();
        initMap();
    }
    private void initMap(){
        if(aMap==null){
            aMap=aMapFragment.getMap();
        }
    }

}
