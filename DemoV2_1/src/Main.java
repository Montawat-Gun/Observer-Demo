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

        //ทำการ register device ที่ต้องการรับข้อมูลจาก weather station
        weatherStation.registerObserver(device1);
        weatherStation.registerObserver(device2);
        weatherStation.registerObserver(device3);

        try {
            Scanner keyboard = new Scanner(System.in);

            var data = getWeatherFromInput(keyboard);
            /* เมื่อ weather station ต้องการ broadcast ข้อมูล device ทุกตัวที่ทำการ register จะได้รับข้อมูลเหมือนกัน */
            weatherStation.setCurrentWeather(data);
            weatherStation.broadcast();

            /* เกิด change หากต้องการให้รับค่า Weather มาอีกรอบ */
            data = getWeatherFromInput(keyboard);
            weatherStation.setCurrentWeather(data);

            /* ลบ Device Television ที่ไม่ต้องการ broadcast */
            weatherStation.removeObserver(device2);

            /* เพิ่ม Device Website ที่ต้องการ broadcast */
            Device device4 = new Device("Website");
            weatherStation.registerObserver(device4);
            weatherStation.broadcast();
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