package com.januzza.archweather.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.januzza.archweather.R;
import com.januzza.archweather.model.City;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add weather list fragment if this is first creation
        if (savedInstanceState == null) {
            WeatherListFragment fragment = new WeatherListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, WeatherListFragment.TAG).commit();
        }

    }

    /** Shows the product detail fragment */
    public void show(City city) {

        WeatherCityFragment productFragment = WeatherCityFragment.forCity(city.getId());

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("city")
                .replace(R.id.fragment_container,
                        productFragment, null).commit();
    }
}
