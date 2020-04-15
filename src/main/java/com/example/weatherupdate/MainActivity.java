package com.example.weatherupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "api.openweathermap.org/data/2.5/forecast?q={city name}&appid={your api key}";
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.Nextspinner);
    }

    public void NextActivity(View v){
       String spin = spinner.getSelectedItem().toString();

       switch(spin){
           case "Weather data type":
               Toast.makeText(this, "Choose a type of data", Toast.LENGTH_LONG).show();
               break;
           case "Current weather":
               Toast.makeText(this, "current weather coming up.", Toast.LENGTH_LONG).show();
               Intent intent = new Intent(this, CurrentWeather.class);
               startActivity(intent);
               break;
           case "5 day forecast":
               Toast.makeText(this, "Hourly forecast coming up.", Toast.LENGTH_LONG).show();
               Intent intent2 = new Intent(this, Main3Activity.class);
               startActivity(intent2);
               break;
           case "Future projections":
               Toast.makeText(this, "This is not available yet but will be worked on.", Toast.LENGTH_LONG).show();

               break;
       }



    }
}
