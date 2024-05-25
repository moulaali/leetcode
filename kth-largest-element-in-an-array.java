import java.util.*;

/*
 * Kth largest element 
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/editorial/
 * 
 *
 * Approach : 
 * Trivial option : max heap with k removals : O(n log n) + O(k log n)
 * Better option : min heap with atmost k elements only. which means (n-k) smallest elements will be removed. the top of heap is kth largest
 */

class Solution {
  public static void main(String[] args) {
   getKthLargest(new int[] {8, 6, 9, 5, 2, 0, 13, 4}, 4);
  }

  static void getKthLargest(int[] a, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < a.length; i++) {
      pq.add(a[i]);
      
      if (pq.size() > k + 1) {
        pq.remove();
      }
    }

    Arrays.sort(a);
    System.out.println("Array sorted : " + Arrays.toString(a) + " kth largest : " + pq.peek());
  }
}
