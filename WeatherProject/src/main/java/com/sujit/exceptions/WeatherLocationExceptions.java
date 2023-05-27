package com.sujit.exceptions;

public class WeatherLocationExceptions extends RuntimeException{
    public WeatherLocationExceptions(){

    }

    public WeatherLocationExceptions(String message){
        super(message);
    }
}
