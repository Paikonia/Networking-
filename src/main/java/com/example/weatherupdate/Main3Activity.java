package com.example.weatherupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weatherupdate.WeatherData.Coord;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main3Activity extends AppCompatActivity {
    public final String api = "ea4fe7082e28ec795f0202dd24c16189";
    public EditText edit;
    public TextView result;
    Button btn;
    public final String BASE_URL = "api.openweathermap.org/data/2.5/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edit = findViewById(R.id.getter);
        result = findViewById(R.id.Result);
        btn = findViewById(R.id.get);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build();

                APICALL apicall = retrofit.create(APICALL.class);
                if(edit.getText().toString().equalsIgnoreCase(null) || edit.getText().toString().equalsIgnoreCase(""))
                  return;

                Call<List<Coord>> call = apicall.five(edit.getText().toString(), api);
                call.enqueue(new Callback<List<Coord>>() {
                    @Override
                    public void onResponse(Call<List<Coord>> call, Response<List<Coord>> response) {
                        if(!response.isSuccessful()){
                            result.setText("Error code: "+ response.code());
                            return;
                        }

                        List<Coord> list = response.body();


                    }

                    @Override
                    public void onFailure(Call<List<Coord>> call, Throwable t) {
                        result.setText(t.getMessage());
                    }
                });
            }
        });

    }

}

