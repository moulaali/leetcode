/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 
 */

class Solution {
  public static void main(String[] args) {
    int[] a = {5, 1, 6, 0, -1, 7};
    findTriplet2(a);
  }

  static boolean findTriplet2(int[] a) {

    int[] leftMin = new int[a.length];
    int[] rightMax = new int[a.length];

    int min = Integer.MAX_VALUE;
    int minIdx = -1;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > min) {
        leftMin[i] = minIdx; 
      } else {
        leftMin[i] = -1;
      }

      if (a[i] <= min) {
        min = a[i];
        minIdx = i;
      }
    }

    int max = Integer.MIN_VALUE;
    int maxIdx = -1;
    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i] < max) {
        rightMax[i] = maxIdx; 
      } else {
        rightMax[i] = -1;
      }

      if (a[i] > max) {
        max = a[i];
        maxIdx = i;
      }
    }

    for (int i = 0; i < a.length; i++) {
      if (leftMin[i] != -1 && rightMax[i] != -1) {
        System.out.println("Found triplets " + a[leftMin[i]] + " " + a[i] + " " + a[rightMax[i]]);
        return true;
      }
    }

    

    System.out.println("No Increasing triplets found");
    return false;
  }

  static boolean findTriplet(int[] a) {
    int smallest = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int i = 0; i < a.length; i++) {
      
      if (a[i] <= smallest) {
        System.out.println("New smallest " + a[i]);
        smallest = a[i];
        continue;
      }

      if (a[i] <= second) {
        System.out.println("New second " + a[i]);
        second = a[i];
        continue;
      }

      // a[i] > smallest and second
      System.out.println("Found triplet " + smallest + " " + second + " " + a[i]);
      return true;
    }

    System.out.println("No Increasing triplets found");
    return true;
  }
}
