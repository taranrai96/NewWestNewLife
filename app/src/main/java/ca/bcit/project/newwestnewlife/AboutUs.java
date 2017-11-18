/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 13/11/17 10:06 PM
 */

package ca.bcit.project.newwestnewlife;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView app_name = (TextView) findViewById(R.id.app_name);
        app_name.setText(getResources().getString(R.string.application_name_tag) + " " + getResources().getString(R.string.app_name));
        TextView created_by = (TextView) findViewById(R.id.created_by);
        created_by.setText(getResources().getString(R.string.created_by));
        TextView copyright_info = (TextView) findViewById(R.id.copyright_info);
        copyright_info.setText(getResources().getString(R.string.copyright_info));

        FloatingActionButton floatingBackButton = (FloatingActionButton) findViewById(R.id.floating_back_button);
        floatingBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHomepage = new Intent(AboutUs.this, HomepageActivity.class);
                startActivity(goToHomepage);
            }

        });
    }
}
