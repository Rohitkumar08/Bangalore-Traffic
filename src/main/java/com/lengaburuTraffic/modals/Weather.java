package com.lengaburuTraffic.modals;

import com.lengaburuTraffic.modals.Vehicle;

import java.util.List;

/**
 * Created 8/7/2019 3:29 PM
 *
 * @author Rohit Rawani
 */
public class Weather{
  private int reduceCaretBy;
  private List<Vehicle> usableVehicle;
  private WeatherType type;

  public enum WeatherType{
   SUNNY, RAINY, WINDY;

    public static WeatherType getEnum(String value) {
      return valueOf(value.toUpperCase());
    }
  }
  public Weather(WeatherType type, int reduceCaretBy, List<Vehicle> usableVehicle) {
    this.type=type;
    this.reduceCaretBy = reduceCaretBy;
    this.usableVehicle = usableVehicle;
  }

  public WeatherType getType() {
    return type;
  }

  public void setType(WeatherType type) {
    this.type = type;
  }

  public List<Vehicle> getUsableVehicle() {
    return usableVehicle;
  }

  public int getReduceCaretBy() {
    return 0;
  }
}
