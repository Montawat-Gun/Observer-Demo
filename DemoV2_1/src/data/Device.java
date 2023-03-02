package data;
import interfaces.Observer;

public class Device implements Observer<WeatherData> {
    private final String name;

    public Device(String name) {
        this.name = name;
    }

    public void update(WeatherData weatherData) {
        System.out.println(name + " received : " + weatherData.getData());
    }
}
