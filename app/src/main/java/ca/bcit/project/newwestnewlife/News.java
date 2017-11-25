/*
 * Created by Taran Rai Chris Kwon on 23/11/17 7:29 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 23/11/17 7:29 PM
 */

package ca.bcit.project.newwestnewlife;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity {
    private String News_Url;
    private int id;
    private String author;
    private String published;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private ArrayList<NewsData> newsDataAL;
    private String[] newsDataArray;
    private ProgressDialog pDialog;
    private ListView newsDataLV;
    private ArrayList<String> newsTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        News_Url = "https://newsapi.org/v2/top-headlines?sources=google-news-ca&apiKey=9c8d355347cb45e4a24abefb7379a7ed";
        newsDataAL = new ArrayList<>();
        newsDataLV = (ListView) findViewById(R.id.news_list);
        newsTitles = new ArrayList<>();
        new News.AsyncHttpTask().execute(News_Url);
        newsDataLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent goToNewsDetails = new Intent(News.this, NewsDetails.class);
                goToNewsDetails.putExtra("id",newsDataAL.get(i).getId());
                goToNewsDetails.putExtra("author",newsDataAL.get(i).getAuthor());
                goToNewsDetails.putExtra("published",newsDataAL.get(i).getPublished());
                goToNewsDetails.putExtra("title",newsDataAL.get(i).getTitle());
                goToNewsDetails.putExtra("description",newsDataAL.get(i).getDescription());
                goToNewsDetails.putExtra("url",newsDataAL.get(i).getUrl());
                goToNewsDetails.putExtra("urlToImage",newsDataAL.get(i).getUrlToImage());
                startActivity(goToNewsDetails);
            }
        });
    }

    public class AsyncHttpTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(News.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... urls) {
            String result ="";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL (urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                String response = streamToString(urlConnection.getInputStream());
                parseResult(response);
                return result;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            newsDataArray = new String[newsTitles.size()];
            newsTitles.toArray(newsDataArray);
            newsDataLV.setAdapter(new ArrayAdapter<String>(News.this, android.R.layout.simple_list_item_1, newsDataArray));
        }
    }

    String streamToString(InputStream stream) throws IOException {
        BufferedReader bufferesReader = new BufferedReader(new InputStreamReader(stream));
        String data;
        String result = "";

        while((data = bufferesReader.readLine()) != null) {
            result += data;
        }

        if(null != stream) {
            stream.close();
        }

        return result;

    }
    private void parseResult(String result) {
        JSONObject response = null;
        try {
            response = new JSONObject(result);
            JSONArray articles = response.optJSONArray("articles");

            for(int i = 0; i < articles.length(); i++) {
                JSONObject article = articles.optJSONObject(i);

                id = i;
                author = article.optString("author");
                published = article.optString("publishedAt");
                title = article.optString("title");
                description = article.optString("description");
                url = article.optString("url");
                urlToImage = article.optString("urlToImage");
                Log.i("Titles", title);

                NewsData newsData = new NewsData();
                newsData.setId(id);
                newsData.setAuthor(author);
                newsData.setPublished(published);
                newsData.setTitle(title);
                newsData.setDescription(description);
                newsData.setUrl(url);
                newsData.setUrlToImage(urlToImage);

                newsDataAL.add(newsData);
                newsTitles.add(title);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
