package com.januzza.archweather.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.januzza.archweather.util.CONSTANTS;
import com.januzza.archweather.api.APIService;
import com.januzza.archweather.model.City;
import com.januzza.archweather.model.WeatherData;
import com.januzza.archweather.util.AbsentLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CityListViewModel extends AndroidViewModel {

    private Call<WeatherData> call;
    private MutableLiveData<List<City>> listMutableLiveData;
    APIService apiService;

    public CityListViewModel(Application application) {
        super(application);

        listMutableLiveData = AbsentLiveData.create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(CONSTANTS.BASE_PATH)
                .build();

        apiService = retrofit.create(APIService.class);
    }

    public void setLatLng(double lat, double lng) {
        apiService.getWeatherLiveData(lat, lng, 10, CONSTANTS.API_KEY)
                .enqueue(new Callback<WeatherData>() {
                    @Override
                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                        List<City> list = response.body().getList();
                        listMutableLiveData.setValue(list);
                    }

                    @Override
                    public void onFailure(Call<WeatherData> call, Throwable t) {
                        int i = 0;
                    }
                });
    }


    public MutableLiveData<List<City>> getCities() {
        return listMutableLiveData;
    }

    @Override
    public <T extends Application> T getApplication() {
        return super.getApplication();
    }
}
