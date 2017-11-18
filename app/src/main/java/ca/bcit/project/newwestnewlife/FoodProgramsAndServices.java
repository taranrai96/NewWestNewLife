/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 16/11/17 8:00 PM
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

public class FoodProgramsAndServices extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private int id;
    private String name;
    private String x_coordinate;
    private String y_coordinate;
    private String description;
    private String hours;
    private String location;
    private String postal_code;
    private String phone;
    private String email;
    private String website_url;
    private double xCoord;
    private double yCoord;
    private ArrayList<FoodProgramsAndServicesData> fpsArrayList;
    private Marker mapMark;
    private String markerId;
    private int markerId_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_programs_and_services);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fpsArrayList = new ArrayList<>();
        try {
            InputStream is = getResources().openRawResource(R.raw.food_programs_and_services);
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
            JSONArray foodJsonArray = new JSONArray(jsonString);

            for(int i = 0; i < foodJsonArray.length(); i++) {
                JSONObject foodJsonObj = foodJsonArray.getJSONObject(i);
                id = i;
                name = foodJsonObj.getString("Name");
                x_coordinate = foodJsonObj.getString("X");
                y_coordinate = foodJsonObj.getString("Y");
                description = foodJsonObj.getString("Description");
                hours = foodJsonObj.getString("Hours");
                location = foodJsonObj.getString("Location");
                postal_code = foodJsonObj.getString("PC");
                phone = foodJsonObj.getString("Phone");
                email = foodJsonObj.getString("Email");
                website_url = foodJsonObj.getString("Website");
                //System.out.println("jsonStringsfsdafadgadsasdafakk1241235njnfag: " + name + " " + x_coordinate + " " + y_coordinate);

                FoodProgramsAndServicesData fpsData = new FoodProgramsAndServicesData();
                fpsData.setId(id);
                fpsData.setName(name);
                fpsData.setX(x_coordinate);
                fpsData.setY(y_coordinate);
                fpsData.setDesc(description);
                fpsData.setHours(hours);
                fpsData.setLocation(location);
                fpsData.setPC(postal_code);
                fpsData.setPhone(phone);
                fpsData.setEMail(email);
                fpsData.setWebsite(website_url);

                fpsArrayList.add(fpsData);
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
        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMinZoomPreference(12.0f);
        mMap.setMaxZoomPreference(14.0f);

        for(int i = 0; i < fpsArrayList.size(); i++) {
            xCoord = Double.parseDouble(fpsArrayList.get(i).getX());
            yCoord = Double.parseDouble(fpsArrayList.get(i).getY());
            LatLng foodProgramPos = new LatLng(yCoord, xCoord);
            mapMark = mMap.addMarker(new MarkerOptions().position(foodProgramPos).title(fpsArrayList.get(i).getName()));
            mapMark.setTag(i);
            //mMap.addMarker(new MarkerOptions().position(foodProgramPos).title(fpsArrayList.get(i).getName()).snippet(fpsArrayList.get(i).getPhone()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(foodProgramPos));
        }
        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        Intent goToDetails = new Intent(FoodProgramsAndServices.this, FoodProgramsAndServicesDetails.class);
        markerId = marker.getId();
        markerId_int = Integer.parseInt(markerId.substring(1));
        goToDetails.putExtra("name",fpsArrayList.get(markerId_int).getName());
        goToDetails.putExtra("description",fpsArrayList.get(markerId_int).getDesc());
        goToDetails.putExtra("hours",fpsArrayList.get(markerId_int).getHours());
        goToDetails.putExtra("location",fpsArrayList.get(markerId_int).getLocation());
        goToDetails.putExtra("postal_code",fpsArrayList.get(markerId_int).getPC());
        goToDetails.putExtra("phone",fpsArrayList.get(markerId_int).getPhone());
        goToDetails.putExtra("email",fpsArrayList.get(markerId_int).getEMail());
        goToDetails.putExtra("website_url",fpsArrayList.get(markerId_int).getWebsite());
        startActivity(goToDetails);
        return false;
    }
}
