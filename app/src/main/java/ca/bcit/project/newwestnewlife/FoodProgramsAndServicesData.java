/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 16/11/17 1:46 PM
 */

package ca.bcit.project.newwestnewlife;

/**
 * Created by Taran on 2017-11-16.
 */

public class FoodProgramsAndServicesData {
    private int _id;
    private String _name;
    private String  _x_coordinate;
    private String _y_coordinate;
    private String _description;
    private String _hours;
    private String _location;
    private String _postal_code;
    private String _phone;
    private String _email;
    private String _website_url;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getX() {
        return _x_coordinate;
    }

    public void setX (String x_coordinate) {
        _x_coordinate = x_coordinate;
    }

    public String getY() {
        return _y_coordinate;
    }

    public void setY(String y_coordinate) {
        _y_coordinate = y_coordinate;
    }

    public String getDesc() {
        return _description;
    }

    public void setDesc(String description) {
        _description = description;
    }

    public String getHours() {
        return _hours;
    }

    public void setHours(String hours) {
        _hours = hours;
    }

    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }

    public String getPC() {
        return _postal_code;
    }

    public void setPC(String postal_code) {
        _postal_code = postal_code;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }

    public String getEMail() {
        return _email;
    }

    public void setEMail(String email) {
        _email = email;
    }

    public String getWebsite() {
        return _website_url;
    }

    public void setWebsite(String website_url) {
        _website_url = website_url;
    }

    public String toString() {
        return _name;
    }

}
