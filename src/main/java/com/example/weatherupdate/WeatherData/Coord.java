package com.example.weatherupdate.WeatherData;

import com.google.gson.annotations.SerializedName;

public class Coord {


    //[{"id":801,"main":"Clouds","description":"few clouds","icon":"02d"}]
    @SerializedName("description")
   String description;
    @SerializedName("id")
     Integer id;
     public String getDescription() { return description; }
    public Integer getId(){ return id; }
    @SerializedName("country")
    String country;
    @SerializedName("name")
    String cityname;
    public String getCountry() { return country; }
    public String getCityname() { return cityname; }

    //{"temp":293.15,"feels_like":295.8,"temp_min":293.15,"temp_max":293.15,"pressure":1018,"humidity":100}
    //Note I am using integer because they are nullable while the primitive "int" isn't.
    Integer temp;

    public Integer getTemp() { return temp; }
    //{"speed":1.5,"deg":190}
     Integer speed;
    public Integer getSpeed() {
      return speed;

@SerializedName("main")
JSONObject json;
public JSONObject getJson(){
return json;
}
//After this method is called, call .getInt() to
//get the various value eg

/*
  String JJ = "";
  JSONObject jace = response.getJson;
  JJ = "Temperature: " + jace.getInt("temp")+ 
  "\nPressure: "+jace.getInt("pressure");
   
*/
    }

}
