package com.example.loginapp.model;

public class Wheather {
    private String DateTime;
    private int WeatherIcon;
    private String IconPharase;
    private Temperature Temperature;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPharase() {
        return IconPharase;
    }

    public void setIconPharase(String iconPharase) {
        IconPharase = iconPharase;
    }

    public com.example.loginapp.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.example.loginapp.model.Temperature temperature) {
        Temperature = temperature;
    }
}
