package com.example.ijoy.amap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goBasicMap(View view){
        Intent intent=new Intent(this,BasicMapActivity.class);
        startActivity(intent);
    }

    public void goOptionMap(View view){
        Intent intent=new Intent(this,MapOptionActivity.class);
        startActivity(intent);
    }
    public void goMarkerMap(View view){
        Intent intent =new Intent(this,MarkerActivity.class);
        startActivity(intent);
    }

    public void goNormalMap(View view){
        Intent intent=new Intent(this,NormalActivity.class);
        startActivity(intent);
    }

}
