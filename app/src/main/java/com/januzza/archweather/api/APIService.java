package com.januzza.archweather.api;

import com.januzza.archweather.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("find?units=metric&lang=pt")
    Call<WeatherData> getWeatherLiveData(@Query("lat") double lat, @Query("lon") double lng, @Query("cnt") int cnt, @Query("appid") String appid);

}
