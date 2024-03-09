/*

https://leetcode.com/problems/maximum-subarray/description/

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Questions

what if array is all negative numbers ?
Empty array
What if there are multiple solutions ? return one or all ?

Approach: 
Kadane algorithm

Set the max_start and end to first element. keep expanding at i as long as adding the sum so far is better than the element i itself.
if not, move the left point of sliding window to i and reset the max_at_i to a[i]. maintain a global max as well.

 */

class Solution {
  public static void main(String[] args) {
    int[] a = {-2,1,-3,4,-1,2,1,-5,4};
    getMaxSum(a);
  }

  static int getMaxSum(int[] a) {
    if (a.length == 0) {
      return 0;
    }

    int max = a[0];
    int maxStart = 0;
    int maxEnd = 0;
    int maxAtI = a[0];

    for (int i = 1; i < a.length; i++) {
      
      if (a[i] + maxAtI > a[i]) {
        // continue expansion
        maxAtI = a[i] + maxAtI;
        maxEnd = i;
        System.out.println("New max: " + maxAtI);
        print(a, maxStart, maxEnd);
      } else {
        // start a new window
        maxAtI = a[i];
        maxStart = i;
        maxEnd = i;
      }

      // Update global max
      if (maxAtI > max) {
        System.out.println("New global max: " + maxAtI);
        print(a, maxStart, maxEnd);
        max = maxAtI;
      }
    }

    return max;
  }

  static void print(int[] a, int start, int end) {
    for (int i = start; i <= end; i++){
      System.out.print(a[i] + ", ");
    }

    System.out.println("");
  }
}
