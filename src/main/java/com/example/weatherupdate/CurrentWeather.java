package com.example.weatherupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherupdate.WeatherData.Coord;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrentWeather extends AppCompatActivity {

    private EditText edit;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather);

        setContentView(R.layout.activity_main2);
        edit = findViewById(R.id.getter);
        result = findViewById(R.id.Result);


        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APICALL.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APICALL apicall = retrofit.create(APICALL.class);


                if(edit.getText() == null || edit.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter city", Toast.LENGTH_LONG).show();
                    return;
                }
                 String ab = edit.getText().toString();

                Call<Coord> call = apicall.pai(ab, APICALL.api);
                call.enqueue(new Callback<Coord>() {
                    @Override
                    public void onResponse(Call<Coord> call, Response<Coord> response) {
                        if(!response.isSuccessful()){
                            result.setText("Error code: "+ response.code());
                            return;
                        }

                        Coord list = response.body();
                        if(list==null) {
                            result.setText("No data gotten!!!!");
                            return;
                        }

                        String result1 = "";
                        result1 += "Country: " + list.getCountry();
                        result1 += "\nCity name: " + list.getCityname();
                        result1 += "\nWeather Description: " + list.getDescription();
                        result1 += "\nTemp: " + list.getTemp();
                        result1 += "\nWind speed: " + list.getSpeed();
                        result.append(result1);
                    }
                    @Override
                    public void onFailure(Call<Coord> call, Throwable t) {
                        result.setText(t.getMessage());
                    }
                });
            }
        });
    }
}
