package com.sujit.api;

import com.sujit.model.Weather;
import com.sujit.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
@AllArgsConstructor
@Component
public class PinCodeDetail {

    private static JSONObject weatherObject;

    public static Location getLocationDetails(Integer pincode, LocalDate dateStamp) {
        JSONObject pincodeDetails = null;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.opencagedata.com/geocode/v1/json?key=767d0ceffae94717836eadb18dee640a&q=" + pincode + "&pretty=1")
                .build();
        try (Response response = client.newCall(request).execute()) {
            pincodeDetails = new JSONObject(response.body().string()).getJSONArray("results").getJSONObject(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Location weatherLocation = new Location();
        weatherLocation.setPincode(pincode);
        weatherLocation.setDetail((String) pincodeDetails.get("formatted"));
        weatherLocation.setLongitude((BigDecimal) pincodeDetails.getJSONObject("geometry").get("lng"));
        weatherLocation.setLattitude((BigDecimal) pincodeDetails.getJSONObject("geometry").get("lat"));
        weatherLocation.setDateStamp(dateStamp);

        return weatherLocation;
    }

    public static Weather getWeather(BigDecimal lat, BigDecimal lon, LocalDate dateStamp) {
        LocalDateTime localDateTime = dateStamp.atStartOfDay();
        long unixTime = localDateTime.toEpochSecond(ZoneOffset.UTC);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&dt=" + unixTime + "&appid=956df4d89fd7e25fc00ccab4ae566c5d&units=metric")
                .build();

        try (Response response = client.newCall(request).execute()) {
            weatherObject = new JSONObject(response.body().string());
            System.out.println(weatherObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject main = returnMainObjectFromWeather();
        JSONObject sys = returnSysObjectFromWeather();
        JSONObject wind = returnWindObjectFromWeather();

        Weather weather = new Weather();
        weather.setTemperature((BigDecimal) main.get("temp"));
        weather.setTemperature_max((BigDecimal) main.get("temp_max"));
        weather.setTemperature_min((BigDecimal) main.get("temp_min"));
        weather.setHumidity((Integer) main.get("humidity"));
        weather.setPressure((Integer) main.get("pressure"));
        weather.setCountry((String) sys.get("country"));
        weather.setWindDirection((Integer) wind.get("deg"));
        weather.setWindSpeed((BigDecimal) wind.get("speed"));
        weather.setCloud((String) weatherObject.getJSONArray("weather").getJSONObject(0).get("description"));

        return weather;
    }

    public static JSONObject returnMainObjectFromWeather() throws JSONException {
        return weatherObject.getJSONObject("main");
    }

    public static JSONObject returnSysObjectFromWeather() throws JSONException {
        return weatherObject.getJSONObject("sys");
    }

    public static JSONObject returnWindObjectFromWeather() throws JSONException {
        return weatherObject.getJSONObject("wind");
    }
}
