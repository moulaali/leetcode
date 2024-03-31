import java.util.*;

/*
https://leetcode.com/problems/merge-intervals/description/

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/

class Solution {
  public static void main(String[] args) {
    int[][] list = {
      {1,3}, 
      {15,18},
      {2,6}, 
      {5,7},
      {8,10},
      {16, 17}
    };
    int[][] list2 = {
      {1,4},
      {5, 7}
    };


    int[][] merged = merge(list2);
    System.out.println("Merged intervals");
    print(merged);
  }

  static int[][] merge(int[][] intervals) {
    // Sort by start time
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    System.out.println("sorted intervals: ");
    print(intervals);

    int[][] merged = new int[intervals.length][2];
    merged[0][0] = intervals[0][0];
    merged[0][1] = intervals[0][1];
    int top = 0;

    for (int i = 1; i < intervals.length; i++) {
     

      // compare the top of merged list with i'th interval and merge if needed
      if (intervals[i][0] >= merged[top][0] && intervals[i][0] <= merged[top][1]) {
        System.out.println("overlap. Merged. checked (" + merged[top][0] + ", " + merged[top][1] + ")" + " and (" + intervals[i][0] + ", " + intervals[i][1] + ")");
        merged[top][1] = Math.max(intervals[i][1], merged[top][1]);
      } else {
        System.out.println("Adding. checked (" + merged[top][0] + ", " + merged[top][1] + ")" + " and (" + intervals[i][0] + ", " + intervals[i][1] + ")");
        top++;
        merged[top][0] = intervals[i][0];
        merged[top][1] = intervals[i][1];
      }
    }

    return merged;
  }

  static void print(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        System.out.print(a[i][j] + ",");
      }
      System.out.println("");
    }
  }
 }

