package com.januzza.archweather.ui;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.januzza.archweather.R;
import com.januzza.archweather.viewmodel.CityListViewModel;

public class WeatherListFragment extends LifecycleFragment {

    public static final String TAG = "WeatherListViewModel";
    private CitiesAdapter mCitiesAdapter;

    RecyclerView rvCities;

    public WeatherListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather_list, container, false);

        rvCities = (RecyclerView) view.findViewById(R.id.rv_cities);
        mCitiesAdapter = new CitiesAdapter();
        rvCities.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCities.setAdapter(mCitiesAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final CityListViewModel viewModel =
                ViewModelProviders.of(this).get(CityListViewModel.class);

        subscribeUi(viewModel);
        viewModel.setLatLng(-23, -42);

    }

    private void subscribeUi(CityListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getCities().observe(this, cities -> {
            if (cities != null)
                mCitiesAdapter.updateList(cities);
        });
    }

}
