package com.sujit.services;

import com.sujit.api.PinCodeDetail;
import com.sujit.exceptions.WeatherExceptions;
import com.sujit.exceptions.WeatherLocationExceptions;
import com.sujit.model.Location;
import com.sujit.model.SearchDTO;
import com.sujit.model.Weather;
import com.sujit.repository.LocationRepository;
import com.sujit.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LocationServiceImpl implements LocaltionServices {

    @Autowired
    private LocationRepository lDao;

    @Autowired
    private WeatherRepository wDao;


    @Override
    public Weather getWeather(SearchDTO searchDTO) throws WeatherLocationExceptions, WeatherExceptions {
        // here i am checking that does weather details already exits with this pincode. if exits then just take the data from database and return
        Optional<Weather> optionalWeatherDetails = wDao.findById(searchDTO.getPincode());
        if(optionalWeatherDetails.isPresent()){
            // getting the weather object.
            Weather weather = optionalWeatherDetails.get();
            return weather;
        }else{

            // getting the location object like lattitude , longitude,url,pincode etc
            Location weatherLocation = PinCodeDetail.getLocationDetails(searchDTO.getPincode(),searchDTO.getDateStamp());
            // getting the weather object
            Weather weatherDetails = PinCodeDetail.getWeather(weatherLocation.getLattitude(),weatherLocation.getLongitude(),searchDTO.getDateStamp());

            weatherDetails.setPin(searchDTO.getPincode());
            // here i am doing mapping with location object
            weatherLocation.setWeatherPincode(weatherDetails);

            // now i am storing it on my sql database
           lDao.save(weatherLocation);
           return weatherLocation.getWeatherPincode();

        }
    }
}
