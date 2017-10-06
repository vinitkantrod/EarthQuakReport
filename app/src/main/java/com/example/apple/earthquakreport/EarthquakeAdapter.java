package com.example.apple.earthquakreport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.apple.earthquakreport.R.id.default_activity_button;
import static com.example.apple.earthquakreport.R.id.magnitude;

/**
 * Created by apple on 06/10/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquake) {
        super(context, 0, earthquake);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(magnitude);
        String formattedMagnitude = formatMagnitude(earthquake.getMagnitude());
        magnitudeTextView.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = earthquake.getLocation();
        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] part = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = part[0] + LOCATION_SEPARATOR;
            primaryLocation = part[1];
        } else {
            locationOffset = getContext().getString(R.string.near_of);
            primaryLocation = originalLocation;
        }

        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        offsetTextView.setText(locationOffset);

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(primaryLocation);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        Date dateObj = new Date(earthquake.getDate());
        String formattedDate = formatDate(dateObj);
        dateTextView.setText(formattedDate);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.timeinMilli);
        Date timeObj = new Date(earthquake.getDate());
        String formattedTime = formatTime(timeObj);
        timeTextView.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date DateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM DD yyyy");
        return dateFormat.format(DateObject);
    }

    private String formatTime(Date timeObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:m a");
        return timeFormat.format(timeObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(Double magnitudeScale) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitudeScale);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
