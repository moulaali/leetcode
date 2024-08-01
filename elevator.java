/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {


    Elevator[] elevators = new Elevator[3];
    elevators[0] = new Elevator(0, "stat", 0);
    elevators[1] = new Elevator(0, "stat", 7);
    elevators[2] = new Elevator(0, "stat", 4);

    ElevatorSystem es = new ElevatorSystem(elevators);
    System.out.println("Initialization done");
  }
}

class ElevatorSystem {
  Elevator[] elevators;
  int floors = 10;

  ElevatorSystem(Elevator[] elevators) {
    this.elevators = elevators;
  }

  private static int getMax(int[] dest) {

  }


  public void handleRequest(int floor) {
    
    int min = Integer.MAX_VALUE;
    int minIdx = -1;

    for (int i = 0; i < elevators.length; i++) {
      System.out.println("Considering elevator " + i + " " + elevators[i]);

      Elevator e = elevators[i];

      // case : stat elevator
      if (e.dir.equalsIgnoreCase("stat")) {
        int cost = Math.abs(e.next - floor);
        if (cost < min) {
          System.out.println("found better " + e);
          min = cost;
          minIdx = i;
        }
        continue;
      }

      // case : in motion. on way
      int maxDest = getMax(e.dest);
      if (e.dir.equalsIgnoreCase("up") && (floor >= e.next && floor <= maxDest)) {
          // up and my req is on way
          int cost = e.next - floor;
          if (cost <= min) {
            System.out.println("Found better moving elevator " + e);
            min = cost;
            minIdx = i;
            continue;
          }
      }

      // case : in motion. on way
      int minDest = getMin(e.dest);
      if (e.dir.equalsIgnoreCase("down") && (floor <= e.next && floor > minDest)) {
          // up and my req is on way
          int cost = e.next - floor;
          if (cost <= min) {
            System.out.println("Found better moving elevator " + e);
            min = cost;
            minIdx = i;
            continue;
          }
      }
    }

    // change the state
    if (elevators[minIdx].dir.equals("stat")) {
      // set up or down
      // add dest
    }
    
  }
}

class Elevator {
  
  int idx;
  int[] dest;
  String dir;
  int next;

  Elevator(int idx, String dir, int next) {
    this.idx = idx;
    this.dest = new int[10];
    this.dir = dir;
    this.next = next;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("idx " + idx);
    sb.append("dest " + Arrays.toString(dest));
    sb.append("dir " + dir);
    sb.append("next " + next);

    return sb.toString();
  }
}
