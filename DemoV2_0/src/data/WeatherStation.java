package data;

import interfaces.Observer;
import interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private WeatherData currentWeather;

    public void setCurrentWeather(WeatherData currentWeather) {
        this.currentWeather = currentWeather;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        if (currentWeather == null) throw new NullPointerException();
        for (Observer observer : observers) {
            observer.update(currentWeather);
        }
    }

    public void broadcast() {
        notifyObservers();
    }
}
