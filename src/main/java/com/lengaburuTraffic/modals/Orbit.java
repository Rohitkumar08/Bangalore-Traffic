package com.lengaburuTraffic.modals;

/**
 * Created 8/7/2019 3:20 PM
 *
 * @author Rohit Rawani
 */
public class Orbit {
  private int length;
  private int noOfCaret;

  public Orbit(int length, int noOfCaret) {
    this.length = length;
    this.noOfCaret = noOfCaret;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getNoOfCaret() {
    return noOfCaret;
  }

  public void setNoOfCaret(int noOfCaret) {
    this.noOfCaret = noOfCaret;
  }

  @Override public String toString() {
    return "orbit 2";
  }

}
