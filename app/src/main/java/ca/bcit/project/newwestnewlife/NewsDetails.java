/*
 * Created by Taran Rai Chris Kwon on 23/11/17 7:29 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 23/11/17 7:29 PM
 */

package ca.bcit.project.newwestnewlife;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsDetails extends AppCompatActivity {
    String News_Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        News_Url = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=9c8d355347cb45e4a24abefb7379a7ed";

        new NewsDetails.AsyncHttpTask().execute(News_Url);
    }

    public class AsyncHttpTask extends AsyncTask<String, Void, String> {

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

                String title = article.optString("title");
                String _description = article.optString("description");
                String _url = article.optString("url");
                String _urlToImage = article.optString("urlToImage");
                Log.i("Titles", title);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
