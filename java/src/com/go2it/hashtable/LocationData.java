package com.go2it.hashtable;

public class LocationData {
    public String name;
    public int latitude;
    public int longtitude;
    public int waterLevel;

    @Override
    public String toString() {
        return "LocationData{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", waterLevel=" + waterLevel +
                '}';
    }
}
