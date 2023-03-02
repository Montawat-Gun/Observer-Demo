package data;

public class WeatherStation {
    private WeatherData currentWeather;

    public void setCurrentWeather(WeatherData currentWeather) {
        this.currentWeather = currentWeather;
    }

    public WeatherData getCurrentWeather() {
        return currentWeather;
    }
}
