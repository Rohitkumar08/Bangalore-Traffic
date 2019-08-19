package com.lengaburuTraffic.util;

import com.lengaburuTraffic.modals.ResponseView.OrbitResultData;

import java.util.Comparator;

/**
 * Created 8/7/2019 5:09 PM
 *
 * @author Rohit Rawani
 */
public class OrbitalTimeTakenComparator implements Comparator<OrbitResultData> {

  /**
   * sorts based on least time taken to highest time taken
   * @param o1
   * @param o2
   * @return
   */

  public int compare(OrbitResultData o1, OrbitResultData o2) {

    return o1.getTimeTaken() < o2.getTimeTaken() ? -1
        : o1.getTimeTaken() >o2.getTimeTaken() ? 1
        : 0;
  }
}
