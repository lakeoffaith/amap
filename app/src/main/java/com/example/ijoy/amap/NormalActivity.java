package com.example.ijoy.amap;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.SupportMapFragment;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;

public class NormalActivity extends FragmentActivity implements AMap.OnMarkerClickListener,AMap.OnInfoWindowClickListener,AMap.InfoWindowAdapter{
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
            setUpMap();
        }
    }
    private void setUpMap(){
        aMap.setOnMarkerClickListener(this);
        aMap.setOnInfoWindowClickListener(this);
        aMap.setInfoWindowAdapter(this);
        addMarkersToMap();   //
    }
    private void addMarkersToMap(){
        drawMarkers();
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view  = getLayoutInflater().inflate(R.layout.activity_marker,null);
        ImageView image = (ImageView)view.findViewById(R.id.image);
        TextView info = (TextView)view.findViewById(R.id.info);
        TextView orderNumber=(TextView)view.findViewById(R.id.orderNumber);
        orderNumber.setText("2本");
        orderNumber.setTextColor(Color.parseColor("#FF0000"));
        info.setText(marker.getTitle());


        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    public void drawMarkers(){
        MarkerOptions markerOptions=new MarkerOptions();
        Marker marker=aMap.addMarker(markerOptions.position(new LatLng(30.624722,104.067533)).title("王泽陶")
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

}
