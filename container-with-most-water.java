

/*

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


Input: height = [1, ]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Approach: two pointer, greedy

We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines
Further, we maintain a variable maxarea\text{maxarea}maxarea to store the maximum area obtained till now. At every
step, we find out the area formed between them, update maxarea\text{maxarea}maxarea, and move the pointer pointing to
the shorter line towards the other end by one step.

 */

class Solution {

  public static void main(String[] args) {
    getMax(new int[]{1,8,6,2,5,4,8,3,7});
  }

  static int getMax(int a[]) {
    
    int max = a[0];
    int l = 0;
    int r = a.length - 1;
    while (l < r) {
      int cur = Math.min(a[r], a[l]) * (r - l);
      System.out.println("Area for " + a[l] + " and " + a[r] + " is : " + cur);

      if (a[l] < a[r]) {
        l++;
      } else {
        r--;
      }

      max = Math.max(cur, max);
    }
  
    System.out.println("Max: " + max);
    return max;
  }
}
