/*
 * Created by Taran Rai Chris Kwon on 19/10/17 11:39 AM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 19/10/17 11:39 AM
 */

package ca.bcit.project.newwestnewlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xenione.library.BeforeAfterCoordinatorLayout;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        BeforeAfterCoordinatorLayout beforeAfterCoordinatorLayout_1 = (BeforeAfterCoordinatorLayout) findViewById(R.id.image1);

        beforeAfterCoordinatorLayout_1.setForegroundImage(R.drawable.history_1_1);
        beforeAfterCoordinatorLayout_1.setBackgroundImage(R.drawable.history_1_2);

        BeforeAfterCoordinatorLayout beforeAfterCoordinatorLayout_2 = (BeforeAfterCoordinatorLayout) findViewById(R.id.image2);

        beforeAfterCoordinatorLayout_2.setForegroundImage(R.drawable.history_7_1);
        beforeAfterCoordinatorLayout_2.setBackgroundImage(R.drawable.history_7_2);

        BeforeAfterCoordinatorLayout beforeAfterCoordinatorLayout_3 = (BeforeAfterCoordinatorLayout) findViewById(R.id.image3);

        beforeAfterCoordinatorLayout_3.setForegroundImage(R.drawable.history_4_1);
        beforeAfterCoordinatorLayout_3.setBackgroundImage(R.drawable.history_4_2);

        BeforeAfterCoordinatorLayout beforeAfterCoordinatorLayout_4 = (BeforeAfterCoordinatorLayout) findViewById(R.id.image4);

        beforeAfterCoordinatorLayout_4.setForegroundImage(R.drawable.history_10_1);
        beforeAfterCoordinatorLayout_4.setBackgroundImage(R.drawable.history_10_2);

    }
}
