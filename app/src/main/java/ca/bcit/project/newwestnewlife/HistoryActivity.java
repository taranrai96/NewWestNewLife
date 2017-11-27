/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 19/10/17 1:26 PM
 */

package ca.bcit.project.newwestnewlife;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import com.xenione.library.BeforeAfterCoordinatorLayout;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        try {

            BeforeAfterCoordinatorLayout beforeAfterCoordinatorLayout_1 = (BeforeAfterCoordinatorLayout) findViewById(R.id.image1);

            beforeAfterCoordinatorLayout_1.setForegroundImage(resizeImage(R.drawable.history_1_1));
            beforeAfterCoordinatorLayout_1.setBackgroundImage(resizeImage(R.drawable.history_1_2));

            BeforeAfterCoordinatorLayout beforeAfterCoordinatorLayout_2 = (BeforeAfterCoordinatorLayout) findViewById(R.id.image2);

            beforeAfterCoordinatorLayout_2.setForegroundImage(resizeImage(R.drawable.history_7_1));
            beforeAfterCoordinatorLayout_2.setBackgroundImage(resizeImage(R.drawable.history_7_2));

            BeforeAfterCoordinatorLayout beforeAfterCoordinatorLayout_3 = (BeforeAfterCoordinatorLayout) findViewById(R.id.image3);

            beforeAfterCoordinatorLayout_3.setForegroundImage(resizeImage(R.drawable.history_4_1));
            beforeAfterCoordinatorLayout_3.setBackgroundImage(resizeImage(R.drawable.history_4_2));

            BeforeAfterCoordinatorLayout beforeAfterCoordinatorLayout_4 = (BeforeAfterCoordinatorLayout) findViewById(R.id.image4);

            beforeAfterCoordinatorLayout_4.setForegroundImage(resizeImage(R.drawable.history_10_1));
            beforeAfterCoordinatorLayout_4.setBackgroundImage(resizeImage(R.drawable.history_10_2));

        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }

    }

    public Drawable resizeImage(int imageResource) {// R.drawable.icon
        // Get device dimensions
        Display display = getWindowManager().getDefaultDisplay();
        double deviceWidth = display.getWidth();

        BitmapDrawable bd = (BitmapDrawable) this.getResources().getDrawable(
                imageResource);
        double imageHeight = bd.getBitmap().getHeight();
        double imageWidth = bd.getBitmap().getWidth();

        double ratio = deviceWidth / imageWidth;
        int newImageHeight = (int) (imageHeight * ratio);

        Bitmap bMap = BitmapFactory.decodeResource(getResources(), imageResource);
        Drawable drawable = new BitmapDrawable(this.getResources(),
                getResizedBitmap(bMap, newImageHeight, (int) deviceWidth));

        return drawable;
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {

        int width = bm.getWidth();
        int height = bm.getHeight();

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        // create a matrix for the manipulation
        Matrix matrix = new Matrix();

        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);

        return resizedBitmap;
    }
}
