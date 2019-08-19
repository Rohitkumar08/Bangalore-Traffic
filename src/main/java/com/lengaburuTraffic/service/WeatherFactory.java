package com.lengaburuTraffic.service;

import com.lengaburuTraffic.modals.Vehicle;
import com.lengaburuTraffic.modals.Weather;

import java.util.List;

/**
 * Created 8/7/2019 3:36 PM
 *
 * @author Rohit Rawani
 */
public class WeatherFactory {

  /**
   * Factory method to create a weather type class
   * @param type
   * @param reduceCaretBy
   * @param usableVehicles
   * @return
   */

  public static Weather createWeather(String type, int reduceCaretBy,
      List<Vehicle> usableVehicles) {
      return new Weather(Weather.WeatherType.getEnum(type), reduceCaretBy, usableVehicles);
  }
}
