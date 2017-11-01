package com.example.mapapp01;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        
        // DBオープン処理
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();
        //SQL文
        String sql    = "SELECT _id,name,longitude,latitude,memo FROM Map";
        //SQL文の実行
        Cursor cursor = db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            int index_id = cursor.getColumnIndex("_id");
            int index_name = cursor.getColumnIndex("name");
            int index_longitude = cursor.getColumnIndex("longitude");
            int index_latitude = cursor.getColumnIndex("latitude");
            int index_memo = cursor.getColumnIndex("memo");
            int id = cursor.getInt(index_id);
            String name = cursor.getString(index_name);
            String memo = cursor.getString(index_memo);
            Double longitude = cursor.getDouble(index_longitude);
            Double latitude = cursor.getDouble(index_latitude);

            LatLng point = new LatLng(longitude, latitude);
            mMap.addMarker(new MarkerOptions().position(point).title(name));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point));
        }
    }


}
