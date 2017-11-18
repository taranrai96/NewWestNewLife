/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 16/11/17 9:05 PM
 */

package ca.bcit.project.newwestnewlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FoodProgramsAndServicesDetails extends AppCompatActivity {
    private String name;
    private String description;
    private String hours;
    private String location;
    private String postal_code;
    private String phone;
    private String email;
    private String website_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_programs_and_services_details);
        name = getIntent().getExtras().getString(getResources().getString(R.string.intent_name));
        description = getIntent().getExtras().getString(getResources().getString(R.string.intent_description));
        hours = getIntent().getExtras().getString(getResources().getString(R.string.intent_hours));
        location = getIntent().getExtras().getString(getResources().getString(R.string.intent_location));
        postal_code = getIntent().getExtras().getString(getResources().getString(R.string.intent_postal_code));
        phone = getIntent().getExtras().getString(getResources().getString(R.string.intent_phone));
        email = getIntent().getExtras().getString(getResources().getString(R.string.intent_email));
        website_url = getIntent().getExtras().getString(getResources().getString(R.string.intent_website_url));

        TextView name_tv = (TextView) findViewById(R.id.name);
        name_tv.setText(getString(R.string.name) + " " + name);
        TextView description_tv = (TextView) findViewById(R.id.description);
        description_tv.setText(getString(R.string.description) + " " + description);
        TextView hours_tv = (TextView) findViewById(R.id.hours);
        if(hours.equalsIgnoreCase("")) {
            hours = getString(R.string.not_available);
        }
        hours_tv.setText(getString(R.string.hours) + " " + hours);
        TextView location_tv = (TextView) findViewById(R.id.location);
        location_tv.setText(getString(R.string.location) + " " + location);
        TextView postal_code_tv = (TextView) findViewById(R.id.postal_code);
        postal_code_tv.setText(getString(R.string.postal_code) + " " + postal_code);
        TextView phone_tv = (TextView) findViewById(R.id.phone);
        phone_tv.setText(getString(R.string.phone) + " " + phone);
        TextView email_tv = (TextView) findViewById(R.id.email);
        email_tv.setText(getString(R.string.email) + " " + email);
        TextView website_url_tv = (TextView) findViewById(R.id.website);
        website_url_tv.setText(getString(R.string.website_url) + " " + website_url);
    }
}
