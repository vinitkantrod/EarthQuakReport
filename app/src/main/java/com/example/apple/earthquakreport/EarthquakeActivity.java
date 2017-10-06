package com.example.apple.earthquakreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();

        earthquakes.add( new Earthquake("7.2", "San Francisco", "6th April 2006"));
        earthquakes.add( new Earthquake("6.1", "London", "7th April 2006"));
        earthquakes.add( new Earthquake("3.9", "Tokyo", "8th April 2006"));
        earthquakes.add( new Earthquake("5.4", "Mexico City", "9th April 2006"));
        earthquakes.add( new Earthquake("2.8", "Moscow", "10th April 2006"));
        earthquakes.add( new Earthquake("4.9", "Rio de Janeiro", "12th April 2006"));
        earthquakes.add( new Earthquake("1.6", "Paris", "14th April 2006"));

        ListView listView =  (ListView) findViewById(R.id.list);

        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        listView.setAdapter(adapter);

    }
}
