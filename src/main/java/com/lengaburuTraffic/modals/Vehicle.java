package com.lengaburuTraffic.modals;

/**
 * Created 8/7/2019 3:02 PM
 *
 * @author Rohit Rawani
 */

public class Vehicle{

  public enum VehicleType{
    CAR("Car"), TUKTUK("TukTuk"), BIKE("Bike");

    private final String displayText;

    private VehicleType(final String displayText) {
      this.displayText = displayText;
    }
    //to display the correct name of the vehicle, used by toString() method
    public String getDisplayText() {
      return this.displayText;
    }
  }

  private VehicleType type;
  private int topSpeed;
  private int timeToCross1crater;

  public Vehicle(VehicleType type, int topSpeed, int timeToCross1crater) {
    this.type = type;
    this.topSpeed = topSpeed;
    this.timeToCross1crater = timeToCross1crater;
  }

  public int getTopSpeed() {
    return topSpeed;
  }

  public int getTimeToCross1crater() {
    return timeToCross1crater;
  }


  public VehicleType getType() {
    return type;
  }

  public void setType(VehicleType type) {
    this.type = type;
  }

  @Override public String toString() {
    return "Vehicle "+getType().getDisplayText();
  }
}
