
/**

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Approach: 
Modified binary search. Start with regular binary search, but continue going far left once to get the leftmost index. 
Similarly do one more round of binary search to go far right even if you find the element. 2 binary searches

Beautifully explained at: https://www.youtube.com/watch?v=4sQL7R5ySUU

 */
public class Solution {

  public static void main(String[] args) throws Exception {
    int leftMostIdx = binarySearch(new int[]{5,7,8,8,8,10}, 1, true);
    int rightMostIdx = binarySearch(new int[]{5,7,7,8,8,10}, 1, false);
    System.out.println(String.format("[%d, %d]", leftMostIdx, rightMostIdx));
  }

  static int binarySearch(int[] nums, int target, boolean leftBias) {
    int l = 0;
    int r = nums.length - 1;

    int idx = -1;
    while (l <= r) {
      int m = (r + l) / 2;
      System.out.println("mid idx = " + m + " value " + nums[m] + " l=" + l + " r=" + r);

      if (nums[m] == target) {
        System.out.println("target found at idx " + m + " will continue ...leftBias=" + leftBias);
        idx = m;
        if (leftBias) {
          // continue far left
          r = m - 1;
        } else {
          // continue far right
          l = m + 1;
          System.out.println("Continuing far right l=" + l + " r=" + r);
        }
      } else if (target > nums[m]) {
        // go right
        l = m + 1;
      } else {
        // go left
        r = m - 1;
      }
    }

    return idx;
  }
}
