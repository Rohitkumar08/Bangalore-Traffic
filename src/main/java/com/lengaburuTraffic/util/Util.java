package com.lengaburuTraffic.util;

import com.lengaburuTraffic.modals.Vehicle;
import com.lengaburuTraffic.modals.Weather;
import com.lengaburuTraffic.service.VehicleFactory;
import com.lengaburuTraffic.service.WeatherFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 8/12/2019 10:00 PM
 *
 * @author Rohit Rawani
 */
public class Util {
  private static Vehicle car;
  private static Vehicle tuktuk;
  private static Vehicle bike;
  public static final int SUNNY_CARET_REDUCTION_PERC = 10;
  public static final int RAINY_CARET_REDUCTION_PERC = 20;
  public static final int WINDY_CARET_REDUCTION_PERC = 0;
  public static final int CAR_TOP_SPEED = 20;
  public static final int TUKTUK_TOP_SPEED = 12;
  public static final int BIKE_TOP_SPEED = 10;
  public static final int TIME_TAKEN_TO_CROSS_1_CARET_BY_CAR = 3;
  public static final int TIME_TAKEN_TO_CROSS_1_CARET_BY_TUKTUK = 1;
  public static final int TIME_TAKEN_TO_CROSS_1_CARET_BY_BIKE = 2;


  public static Weather initializeData(String weatherType) {
    car = VehicleFactory.createVehicle(Vehicle.VehicleType.CAR, CAR_TOP_SPEED,
        TIME_TAKEN_TO_CROSS_1_CARET_BY_CAR);
    tuktuk = VehicleFactory.createVehicle(Vehicle.VehicleType.TUKTUK, TUKTUK_TOP_SPEED,
        TIME_TAKEN_TO_CROSS_1_CARET_BY_TUKTUK);
    bike = VehicleFactory.createVehicle(Vehicle.VehicleType.BIKE, BIKE_TOP_SPEED,
        TIME_TAKEN_TO_CROSS_1_CARET_BY_BIKE);
    //creates sunny weather data
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    vehicles.add(car);
    vehicles.add(tuktuk);
    if ((Weather.WeatherType.getEnum(weatherType).equals(Weather.WeatherType.SUNNY))) {
      vehicles.add(bike);
      return WeatherFactory.createWeather(weatherType, SUNNY_CARET_REDUCTION_PERC, vehicles);
    } else if ((Weather.WeatherType.getEnum(weatherType)
        .equals(Weather.WeatherType.RAINY))) {
      //creates rainy weather data
      return WeatherFactory.createWeather(weatherType, RAINY_CARET_REDUCTION_PERC, vehicles);
    } else {
      //creates windy weather data
      vehicles.add(bike);
      return WeatherFactory.createWeather(weatherType, WINDY_CARET_REDUCTION_PERC, vehicles);
    }
  }
}
