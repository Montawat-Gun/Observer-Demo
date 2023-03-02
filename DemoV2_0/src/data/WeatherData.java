package data;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherData {
    private final String name;
    private final long temperature;
    private final long humidity;
    private final long wind;
    private final Date date;

    public String getData() {
        var dt = DateFormat.getDateInstance();
        return MessageFormat.format("Today: {0} is {1} Temperature: {2}°C Humidity: {3}% Wind: {4}km/h", dt.format(date), name, temperature, humidity, wind);
    }

    public WeatherData(String name, long temperature, long humidity, long wind, Date date) {
        this.name = name;
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind = wind;
        this.date = date;
    }
}
