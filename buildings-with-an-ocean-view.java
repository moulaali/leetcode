import java.util.*;

/*
https://leetcode.com/problems/buildings-with-an-ocean-view/description/

There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

 

Example 1:

Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
Example 2:

Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.
Example 3:

Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.

Approach : go from right to left and maintain the curMax. if a[i] is greater than curMax, add to the list. put in stack if you want
reverse order

 */

class Solution {
  public static void main(String[] args) {
    getWithView(new int[]{1, 2, 4, 2, 3, 1});
    
  }

  private static void getWithView(int[] a) {
    int curMax = Integer.MIN_VALUE;
    Stack<Integer> stk = new Stack<>();

    for (int i = a.length - 1; i >= 0; i--) {
      
      if (a[i] > curMax) {
        stk.push(i);
      }

      curMax = (a[i] > curMax ? a[i] : curMax);
    }

    while(!stk.isEmpty()) {
      System.out.print(stk.pop() + ", ");
    }
  }
}
