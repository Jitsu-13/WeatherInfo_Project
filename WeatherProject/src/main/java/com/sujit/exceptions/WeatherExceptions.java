package com.sujit.exceptions;

public class WeatherExceptions extends RuntimeException{
    public WeatherExceptions(){

    }
    public WeatherExceptions(String message){
    super(message);
    }
}
