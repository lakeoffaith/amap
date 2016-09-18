package com.example.ijoy.amap;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;

public class MarkerActivity extends Activity implements AMap.OnMarkerClickListener,AMap.OnInfoWindowClickListener {
    private MapView mapView;
    private AMap aMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker);
        mapView=(MapView)findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        if(aMap==null){
            aMap=mapView.getMap();
            setUpMap();
        }
    }

    private void setUpMap(){
        aMap.setOnMarkerClickListener(this);
        aMap.setOnInfoWindowClickListener(this);
        addMarkersToMap();   //

    }

    private void addMarkersToMap(){
        drawMarkers();
    }
    public void drawMarkers(){
       MarkerOptions markerOptions=new MarkerOptions();
        Marker marker=aMap.addMarker(markerOptions.position(new LatLng(36.061,103.834)).title("书圈").
                icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.car)))
                .draggable(true));
        marker.showInfoWindow();

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        System.out.println("点击了输入框");
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        System.out.println("点击了图标");
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
