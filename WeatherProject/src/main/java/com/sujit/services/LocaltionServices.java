package com.sujit.services;


import com.sujit.exceptions.WeatherLocationExceptions;
import com.sujit.model.SearchDTO;
import com.sujit.model.Weather;

public interface LocaltionServices {

     Weather getWeather(SearchDTO searchDTO) throws WeatherLocationExceptions;


}
