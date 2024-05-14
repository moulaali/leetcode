/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
Kth Largest element with multiple ways.
 */

class Solution {
  public static void main(String[] args) {
    int[] a = {5, 11, 1, 7, 0, 9, 100, 8};
    findKthLargestWithMinHeap(a, 4);
    Arrays.sort(a);
    System.out.println(Arrays.toString(a));
  }

  static int findKthLargestWithMinHeap(int[] a, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    for (int i : a) {
      if (maxHeap.size() >= k) {
        maxHeap.remove(); // pop top elememt
      }
      maxHeap.add(i);
    }

    System.out.println(k + "th largest : " + maxHeap.peek());
    return maxHeap.peek();
  }
}
