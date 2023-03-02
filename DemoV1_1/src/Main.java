import data.Device;
import data.WeatherData;
import data.WeatherStation;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Device device1 = new Device("Phone");
        Device device2 = new Device("Television");
        Device device3 = new Device("Smartwatch");

        try {
            Scanner keyboard = new Scanner(System.in);
            var data = getWeatherFromInput(keyboard);
            weatherStation.setCurrentWeather(data);

            /* Device ต้องสั่งให้ update ค่าทีละตัว */
            device1.update(weatherStation.getCurrentWeather());
            device2.update(weatherStation.getCurrentWeather());
            device3.update(weatherStation.getCurrentWeather());

            /* เกิด change หากต้องการ broadcast ค่าอีกรอบโดยที่ตัด television ออกและเพิ่ม website เข้ามา
            ต้องสั่งให้ device update ซำ้ */
            data = getWeatherFromInput(keyboard);
            weatherStation.setCurrentWeather(data);
            device1.update(weatherStation.getCurrentWeather());
            device3.update(weatherStation.getCurrentWeather());

            /* ทำการเพิ่ม device ขึ้นมาอีกตัว */
            Device device4 = new Device("Website");
            device4.update(weatherStation.getCurrentWeather());
        } catch (Exception err) {
            System.out.println("Invalid input");
        }
    }

    private static WeatherData getWeatherFromInput(Scanner keyboard) {
        var weatherType = Arrays.asList("Sunshine", "Cloudy", "Raining", "Windy");
        System.out.println("Select 1-4 \n 1.Sunshine 2.Cloudy 3.Raining 4.Windy");
        var selectedType = keyboard.nextInt();
        System.out.println("Insert temperature: ");
        var inputTemperature = keyboard.nextInt();
        System.out.println("Insert humidity: ");
        var inputHumidity = keyboard.nextInt();
        System.out.println("Insert wind: ");
        var inputWind = keyboard.nextInt();

        return new WeatherData(weatherType.get(selectedType - 1), inputTemperature, inputHumidity, inputWind, new Date());
    }
}