package interfaces;

import data.WeatherData;

public interface Observer<T> {
    void update(T data);
}
