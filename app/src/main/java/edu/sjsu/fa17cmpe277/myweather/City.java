package edu.sjsu.fa17cmpe277.myweather;

public class City {
    private String name;
    private String weather;
    private String temperature;
    private boolean currentCity = false;

    public City(String name) {
        this.name = name;
        this.weather = "No Weather Data";
        this.temperature = "N/A";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public boolean isCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(boolean currentCity) {
        this.currentCity = currentCity;
    }
}
