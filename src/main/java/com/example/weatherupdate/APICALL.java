package com.example.weatherupdate;

import com.example.weatherupdate.WeatherData.Coord;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APICALL {
     String BASE_URL = "http://api.openweathermap.org/data/2.5/";
     String api = "ea4fe7082e28ec795f0202dd24c16189";
    @GET("weather")
    Call<Coord> pai(@Query("q") String city_name,
                    @Query("appid") String apikey
                    );

    @GET("forecast")
    Call<List<Coord>> five(@Query("q") String city_name,
                           @Query("appid") String apikey
    );


}
