package com.lengaburuTraffic.service;

import com.lengaburuTraffic.modals.Vehicle;

/**
 * Created 8/7/2019 3:13 PM
 *
 * @author Rohit Rawani
 */
public class VehicleFactory {

  public static Vehicle createVehicle(Vehicle.VehicleType type, int topSpeed,
      int timeTakenToCross1Crater) {
      return new Vehicle(type, topSpeed, timeTakenToCross1Crater);
  }
}
