/*
 * Created by Taran Rai Chris Kwon on 17/11/17 2:06 PM
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 16/11/17 8:46 PM
 */

package ca.bcit.project.newwestnewlife;

/**
 * Created by Taran on 2017-11-16.
 */

public class DrinkingFountainsData {
    private int _id;
    private String _name;
    private String _structureId;
    private String _parkName;
    private String _objectId;
    private String  _x_coordinate;
    private String _y_coordinate;

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

    public String getStructureId() {
        return _structureId;
    }

    public void setStructureId(String structureId) {
        _structureId = structureId;
    }

    public String getParkName() {
        return _parkName;
    }

    public void setParkName(String parkName) {
        _parkName = parkName;
    }

    public String getObjectId() {
        return _objectId;
    }

    public void setObjectId(String objectId) {
        _objectId = objectId;
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
}
