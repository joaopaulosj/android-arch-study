package com.januzza.archweather.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.januzza.archweather.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherCityFragment extends Fragment {

    private static final String KEY_CITY_ID = "city_id";

    public WeatherCityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_city, container, false);
    }

    public static WeatherCityFragment forCity(int cityId) {
        WeatherCityFragment fragment = new WeatherCityFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_CITY_ID, cityId);
        fragment.setArguments(args);
        return fragment;
    }

}
