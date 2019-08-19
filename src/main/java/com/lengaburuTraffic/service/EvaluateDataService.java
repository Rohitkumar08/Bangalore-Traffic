package com.lengaburuTraffic.service;

import com.lengaburuTraffic.modals.Orbit;
import com.lengaburuTraffic.modals.Vehicle;
import com.lengaburuTraffic.modals.ResponseView.OrbitResultData;
import com.lengaburuTraffic.modals.Weather;
import com.lengaburuTraffic.util.OrbitalTimeTakenComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created 8/7/2019 4:05 PM
 *
 * @author Rohit Rawani
 */
public class EvaluateDataService {

  public OrbitResultData getVehicleAndOrbitResult(Weather weather,
      int orbitTrafficSpeed, Orbit orbit) {
    return getDataForOrbit(weather, orbitTrafficSpeed, orbit);
  }

  public OrbitResultData getDataForOrbit(Weather weather, int orbit1TrafficSpeed,
      Orbit orbit) {
    List<Vehicle> usableVehicles = weather.getUsableVehicle();;
    int reductionInCaretPercentage =  weather.getReduceCaretBy();
    List<OrbitResultData> listOfvehicleAndTimeTaken = new ArrayList<OrbitResultData>();
    if (usableVehicles != null && !usableVehicles.isEmpty()) {
      usableVehicles.stream().forEach(vehicle -> listOfvehicleAndTimeTaken.add(
          getTimeTakenForEachVehicle(weather, vehicle, orbit1TrafficSpeed, orbit,
              reductionInCaretPercentage)));
      //sort based on time taken for each vehicle for the given orbit
      Collections.sort(listOfvehicleAndTimeTaken, new OrbitalTimeTakenComparator());
      return listOfvehicleAndTimeTaken.get(0);
    } else {
      return null;
    }
  }

  /**
   * for each vehicle get the time taken for given orbit
   * @param vehicle
   * @param orbitTrafficSpeed
   * @param orbit
   * @param reductionInCaretPercentage
   * @return
   */
  public OrbitResultData getTimeTakenForEachVehicle(Weather weather, Vehicle vehicle,
      int orbitTrafficSpeed, Orbit orbit, int reductionInCaretPercentage) {
    OrbitResultData data = new OrbitResultData();
    float timeTaken = 0;
    if (weather.getType().equals(Weather.WeatherType.RAINY)) {
      reductionInCaretPercentage = -reductionInCaretPercentage;
    }
    //vehicle can only move at the max speed of traffic speed
    int speed = vehicle.getTopSpeed() > orbitTrafficSpeed ? orbitTrafficSpeed :
        vehicle.getTopSpeed();
    //alter the no of carets depending on the weather
    int noOfCarets =
        orbit.getNoOfCaret() - (orbit.getNoOfCaret() * reductionInCaretPercentage / 100);
    //calculate the time taken for the vehicle to cross the given orbit
    timeTaken = (((float) orbit.getLength() / speed) + (
        (float) (vehicle.getTimeToCross1crater() * noOfCarets) / 60f));
    data.setTimeTaken(timeTaken);
    data.setVehicle(vehicle);
    return data;
  }
}
