/*
 * Median of two sorted arrays
 * 
 * Approach : 
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * Approach: 
 * The goal is to find a partition of x elements in array A and (num_of_elements/2 - x) num_of_elements
 * in B. So that we can find the median around the partition boundary. However the partition should
 * be in such a way that all elements of partition from both A and B are smaller than right partitions.
 * Then we can say that we successfully found a index in A and B where the merged array is split in half
 * We start with middle element of smaller array and check the parition. if not, we move left or right.
 * The good parition will have
 *
 *  A[a_partition_index] < B[b_partition_index + 1] and B[b_partition_index] < A[a_partition_index + 1]
 */

class Solution {

  public static void main(String[] args) {
    int[] a = {-5, 3, 6, 12, 15};
    int[] b = {-12, -10, -6, -3, 4, 10};
    // {-12, -10, -6, -5 , -3, 3, 4, 6, 10, 12, 15}.  // 3

    getMedian(a, b); 
  }

  static void getMedian(int a[], int b[]) {
    int l = 0;
    int r = a.length - 1;
    boolean found = false;

    while (!found) {
      int m = (l + r) / 2;
      System.out.println("------");
      System.out.println("middle index " + m + " element in a " + a[m]);
      int right = ((a.length + b.length) / 2) - m - 1;
      System.out.println("middle index " + m + " element in b " + b[m]);
      System.out.println("Left partition ends at " + a[m] + " and right partition at " + b[right]);
      partitions(a, b, m, right);

      if (a[m] < b[right + 1] && b[right] < a[m + 1]) {
        System.out.println("Partition is good.");
        
        if ((a.length + b.length) % 2 == 0) {
          // Median is average of max of left pair and min of right pair
          float median = (Math.max(a[m], b[right]) + Math.min(a[m + 1], b[right + 1])) / 2;
          System.out.println("Median " + median);
        } else {
          System.out.println("Median " + Math.max(a[m], b[right]));
        }

        found = true;
      } else if (a[m] > b[right + 1]){
        System.out.println("Partition is not good. moving left side in first array");
        r = (m - 1);
      } else {
        System.out.println("Partition is not good. moving right side in first array");
        l = (m + 1);
      }
    }
  }

  static void partitions(int a[], int b[], int aIdx, int bIdx) {
    System.out.print("Left partition: ");
    for (int i = 0; i <= aIdx; i++) {
      System.out.print(a[i] + ",");
    }
    System.out.println("");

    System.out.print("Right partition: ");
    for (int i = 0; i <= bIdx; i++) {
      System.out.print(b[i] + ",");
    }
    System.out.println("");
  }
}
