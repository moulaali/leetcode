import java.util.*;

/*

https://leetcode.com/problems/subarray-sum-equals-k/description/

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 
Example 1:

Input: nums = [7, 2, 1, 9, 11, 3, 4, 5], k = 7

Approach: Kind of brilliant :)
Keep a count of cummulative_sum -> num_of elements
As you scan from left to right, compute cummulative_sum and see if there is an entry for (sum - k) in map.

 */

class Solution {
  public static void main(String[] args) {
    int[] a = new int[] {7, 2, 1, 6, 11, 3, 2, 5, 1, 1};
    subsWithSumK(a, 7);
  }

  static void subsWithSumK(int[] a, int k) {
    Map<Integer, Integer> sumCounts = new HashMap<>();

    int sum = 0;
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      if (sum == k) {
        System.out.println("Found element of k " + sum + " at idx: " + i);
        count++;
        continue;
      }

      int sumMinusKCount = sumCounts.getOrDefault(sum - k, 0);
      if (sumMinusKCount > 0) {
        System.out.println("Found "+ sumMinusKCount + " elements of sum-k " + (sum - k) + " and sum " + sum 
          + " at element : " + a[i]);
        count += sumMinusKCount;
      }

      sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
    }

    System.out.println("-- Total Count : " + count);
  }
}
