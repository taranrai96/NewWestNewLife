/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:20 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 17/11/17 2:20 PM
 */

package ca.bcit.project.newwestnewlife;

/**
 * Created by Taran on 2017-11-17.
 */

public class NewsData {
    private int _id;
    private String _author;
    private String _published;
    private String _title;
    private String _description;
    private String _url;
    private String _urlToImage;


    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public String getPublished() {
        return _published;
    }

    public void setPublished(String published) {
        _published = published;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getUrlToImage() {
        return _urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        _urlToImage = urlToImage;
    }
}

