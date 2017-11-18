/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 16/11/17 8:51 PM
 */

package ca.bcit.project.newwestnewlife;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

public class DrinkingFountains extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private int id;
    private String name;
    private String structureId;
    private String parkName;
    private String objectId;
    private String  x_coordinate;
    private String y_coordinate;
    private double xCoord;
    private double yCoord;
    private ArrayList<DrinkingFountainsData> dfsArrayList;
    private Marker mapMark;
    private String markerId;
    private int markerId_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinking_fountains);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        dfsArrayList = new ArrayList<>();
        try {
            InputStream is = getResources().openRawResource(R.raw.drinking_fountains);
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            String jsonString = writer.toString();
            //System.out.println("jsonStringsfsdafadgadsg: " + jsonString);
            JSONArray drinkJsonArray = new JSONArray(jsonString);

            for(int i = 0; i < drinkJsonArray.length(); i++) {
                JSONObject drinkJsonObj = drinkJsonArray.getJSONObject(i);
                id = i;
                name = drinkJsonObj.getString("Name");
                structureId = drinkJsonObj.getString("StructureId");
                parkName = drinkJsonObj.getString("ParkName");
                objectId = drinkJsonObj.getString("OBJECTID");
                x_coordinate = drinkJsonObj.getString("X");
                y_coordinate = drinkJsonObj.getString("Y");

                DrinkingFountainsData dfsData = new DrinkingFountainsData();
                dfsData.setId(id);
                dfsData.setName(name);
                dfsData.setStructureId(structureId);
                dfsData.setParkName(parkName);
                dfsData.setObjectId(objectId);
                dfsData.setX(x_coordinate);
                dfsData.setY(y_coordinate);

                dfsArrayList.add(dfsData);
            }
    } catch (Exception e ) {
            Toast.makeText(getApplicationContext(),
                    "Json parsing error: " + e.getMessage(),
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(12.0f);
        mMap.setMaxZoomPreference(14.0f);

        for(int i = 0; i < dfsArrayList.size(); i++) {
            xCoord = Double.parseDouble(dfsArrayList.get(i).getX());
            yCoord = Double.parseDouble(dfsArrayList.get(i).getY());
            LatLng drinkingFounPos = new LatLng(yCoord, xCoord);
            mapMark = mMap.addMarker(new MarkerOptions().position(drinkingFounPos).title(dfsArrayList.get(i).getName() + " #" + dfsArrayList.get(i).getId() ));
            mapMark.setTag(i);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(drinkingFounPos));
        }
        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        Intent goToDetails = new Intent(DrinkingFountains.this, DrinkingFountainsDetails.class);
        markerId = marker.getId();
        markerId_int = Integer.parseInt(markerId.substring(1));
        goToDetails.putExtra("name",dfsArrayList.get(markerId_int).getName());
        goToDetails.putExtra("structureId",dfsArrayList.get(markerId_int).getStructureId());
        goToDetails.putExtra("parkName",dfsArrayList.get(markerId_int).getParkName());
        goToDetails.putExtra("objectId",dfsArrayList.get(markerId_int).getObjectId());
        startActivity(goToDetails);
        return false;
    }
}
