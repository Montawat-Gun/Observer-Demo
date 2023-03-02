package data;

public class Device {
    private final String name;
    private WeatherData weatherData;

    public Device(String name) {
        this.name = name;
    }

    public void update(WeatherData weatherData) {
        this.weatherData = weatherData;
        System.out.println(name + " received : " + this.weatherData.getData());
    }
}
