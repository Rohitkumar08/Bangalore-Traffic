package com.lengaburuTraffic.client;

import com.lengaburuTraffic.modals.Orbit;
import com.lengaburuTraffic.modals.ResponseView.OrbitResultData;
import com.lengaburuTraffic.modals.Weather;
import com.lengaburuTraffic.service.EvaluateDataService;
import com.lengaburuTraffic.util.Util;

import java.util.Scanner;

/**
 * Created 8/7/2019 3:17 PM
 *
 * @author Rohit Rawani
 */
public class ApplicationClient {
  static Orbit orbit1;
  static Orbit orbit2;


  static {
    //creates orbit objects
    orbit1 = new Orbit(18, 20);
    orbit2 = new Orbit(20, 10);
  }

  public static void main(String[] args) {
    // user inputs
    Scanner sc = new Scanner(System.in);
    String weatherType;
    System.out.println("Enter weather condition");
    weatherType = sc.next();
    int orbit1TrafficSpeed;
    System.out.println("Enter orbit 1 traffic speed");
    orbit1TrafficSpeed = sc.nextInt();
    int orbit2TrafficSpeed;
    System.out.println("Enter orbit 2 traffic speed");
    orbit2TrafficSpeed = sc.nextInt();

    Weather weather = Util.initializeData(weatherType);
    EvaluateDataService service = new EvaluateDataService();
    //get data for orbit 1
    OrbitResultData orbitData1 =
        service.getVehicleAndOrbitResult(weather, orbit1TrafficSpeed, orbit1);
    //get data for orbit 2
    OrbitResultData orbitData2 =
        service.getVehicleAndOrbitResult(weather, orbit2TrafficSpeed, orbit2);
    if (orbitData1 == null || orbitData2 == null) {
      System.out.println("Something bad happened ** NO VEHICLES FOUND**");
    }
    /**
     * compare the time taken for both orbit and return the least one
     */
    if (orbitData1.getTimeTaken() > orbitData2.getTimeTaken()) {
      System.out.println(
          orbitData2.getVehicle().toString() + " on Orbit2, time taken is : " + orbitData2
              .getTimeTaken());
    } else {
      System.out.println(
          orbitData1.getVehicle().toString() + " on Orbit1, time taken is : " + orbitData1
              .getTimeTaken());
    }
  }

}
