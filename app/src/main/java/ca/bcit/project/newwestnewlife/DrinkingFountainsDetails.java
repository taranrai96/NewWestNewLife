/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 16/11/17 9:08 PM
 */

package ca.bcit.project.newwestnewlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DrinkingFountainsDetails extends AppCompatActivity {
    private String name;
    private String structureId;
    private String parkName;
    private String objectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinking_fountains_details);
        name = getIntent().getExtras().getString(getResources().getString(R.string.intent_name));
        structureId = getIntent().getExtras().getString(getResources().getString(R.string.intent_structureId));
        parkName = getIntent().getExtras().getString(getResources().getString(R.string.intent_parkName));
        objectId = getIntent().getExtras().getString(getResources().getString(R.string.intent_objectId));

        TextView name_tv = (TextView) findViewById(R.id.name);
        name_tv.setText(getString(R.string.name) + " " + name);
        TextView structureId_tv = (TextView) findViewById(R.id.structureId);
        structureId_tv.setText(getString(R.string.structureId) + " " + structureId);
        TextView parkName_tv = (TextView) findViewById(R.id.parkName);
        parkName_tv.setText(getString(R.string.parkName) + " " + parkName);
        TextView objectId_tv = (TextView) findViewById(R.id.objectId);
        objectId_tv.setText(getString(R.string.objectId) + " " + objectId);
    }
}
