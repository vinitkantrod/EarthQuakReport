package com.example.apple.earthquakreport;

/**
 * Created by apple on 06/10/17.
 */

public class Earthquake {

    private Double mMagnitude;
    private String mLocation;
    private  long mDate;

    public Earthquake (Double magnitude, String location, long date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public Double getMagnitude() {return mMagnitude; }

    public String getLocation() {return mLocation; }

    public long getDate() {return mDate; }

}
