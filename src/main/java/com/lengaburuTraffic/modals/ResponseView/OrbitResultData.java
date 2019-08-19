package com.lengaburuTraffic.modals.ResponseView;

import com.lengaburuTraffic.modals.Orbit;
import com.lengaburuTraffic.modals.Vehicle;

/**
 * Created 8/7/2019 4:22 PM
 *
 * @author Rohit Rawani
 */
public class OrbitResultData {
  private float timeTaken;
  private Vehicle vehicle;
  private Orbit orbit;

  public OrbitResultData(float timeTaken, Vehicle vehicle, Orbit orbit) {
    this.timeTaken = timeTaken;
    this.vehicle = vehicle;
    this.orbit = orbit;
  }
  public OrbitResultData(){ }

  public float getTimeTaken() {
    return timeTaken;
  }

  public void setTimeTaken(float timeTaken) {
    this.timeTaken = timeTaken;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
  public Orbit getOrbit() {
    return orbit;
  }

  public void setOrbit(Orbit orbit) {
    this.orbit = orbit;
  }

}
