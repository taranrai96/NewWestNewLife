/*
 * Created by Taran Rai Chris Kwon on 24/11/17 2:27 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 24/11/17 2:27 PM
 */

package ca.bcit.project.newwestnewlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetails extends AppCompatActivity {
    private int id;
    private String author;
    private String published;
    private String title;
    private String description;
    private String url;
    private String urlToImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        id = getIntent().getExtras().getInt("id");
        author = getIntent().getExtras().getString("author");
        title = getIntent().getExtras().getString("title");
        description = getIntent().getExtras().getString("description");
        url = getIntent().getExtras().getString("url");
        urlToImage = getIntent().getExtras().getString("urlToImage");
        published = getIntent().getExtras().getString("published");

        TextView newsTitle_tv = (TextView) findViewById(R.id.news_title);
        newsTitle_tv.setText(title);
        ImageView newsImage_iv = (ImageView) findViewById(R.id.news_image);
        Picasso.with(getApplicationContext()).load(urlToImage).fit().into(newsImage_iv);
        TextView newsAuthor_tv = (TextView) findViewById(R.id.author);
        if(author.equalsIgnoreCase("null")) {
            newsAuthor_tv.setText(getResources().getString(R.string.author_info_not));
        } else {
            newsAuthor_tv.setText(getResources().getString(R.string.author_info) + " " + author);
        }
        TextView newsPublished_tv = (TextView) findViewById(R.id.published);
        newsPublished_tv.setText(getResources().getString(R.string.published_at) + " " + published);
        TextView newsDesc_tv = (TextView) findViewById(R.id.description);
        newsDesc_tv.setText(description);
        TextView newsUrl_tv = (TextView) findViewById(R.id.url);
        newsUrl_tv.setText(getResources().getString(R.string.news_url) + " " + url);
    }
}
