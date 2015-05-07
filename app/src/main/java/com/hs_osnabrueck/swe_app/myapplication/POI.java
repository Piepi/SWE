package com.hs_osnabrueck.swe_app.myapplication;

import java.util.Vector;

public class POI {

    private int id;
    private String name;
    private String description;
    private double gps_latitude;
    private double gps_longitude;
    private Vector<String> imageLinks;
    private Vector<String> webLinks;
    private Vector<String> image;
    private Vector<Beacon> beacon;
    private Vector<Course> course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getGps_latitude() {
        return gps_latitude;
    }

    public void setGps_latitude(double gps_latitude) {
        this.gps_latitude = gps_latitude;
    }

    public double getGps_longitude() {
        return gps_longitude;
    }

    public void setGps_longitude(double gps_longitude) {
        this.gps_longitude = gps_longitude;
    }

    public Vector<String> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(Vector<String> imageLinks) {
        this.imageLinks = imageLinks;
    }

    public Vector<String> getWebLinks() {
        return webLinks;
    }

    public void setWebLinks(Vector<String> webLinks) {
        this.webLinks = webLinks;
    }

    public Vector<Beacon> getBeacon() {
        return beacon;
    }

    public void setBeacon(Vector<Beacon> beacon) {
        this.beacon = beacon;
    }

    public Vector<String> getImage() {
        return image;
    }

    public void setImage(Vector<String> image) {
        this.image = image;
    }

    public Vector<Course> getCourse() {
        return course;
    }

    public void setCourse(Vector<Course> course) {
        this.course = course;
    }
}
