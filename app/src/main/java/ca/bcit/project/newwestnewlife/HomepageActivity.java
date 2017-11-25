/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 16/11/17 8:25 PM
 */

package ca.bcit.project.newwestnewlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button historyButton = (Button) findViewById(R.id.historyButton);
        historyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent historyIntent = new Intent(HomepageActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });

        Button aboutUsButton = (Button) findViewById(R.id.aboutButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent aboutIntent = new Intent(HomepageActivity.this, AboutUs.class);
                startActivity(aboutIntent);
            }
        });

        Button foodProgramsButton = (Button) findViewById(R.id.foodButton);
        foodProgramsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent foodIntent = new Intent(HomepageActivity.this, FoodProgramsAndServices.class);
                startActivity(foodIntent);
            }

        });

        Button drinkingFountainsButton = (Button) findViewById(R.id.waterButton);
        drinkingFountainsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent drinkIntent = new Intent(HomepageActivity.this, DrinkingFountains.class);
                startActivity(drinkIntent);
            }
        });

        Button newsButton = (Button) findViewById(R.id.newsButton);
        newsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newsIntent = new Intent(HomepageActivity.this, News.class);
                startActivity(newsIntent);
            }
        });
    }
}
