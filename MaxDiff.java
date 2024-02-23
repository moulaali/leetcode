/*
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 *
 * Java program to find Maximum difference  
 * between two elements such that larger  
 * element appears after the smaller number

  Input : arr = {2, 3, 10, 6, 4, 8, 1}
  Output : 8
  Explanation : The maximum difference is between 10 and 2.

  Input : arr = {7, 9, 5, 6, 3, 2}
  Output : 2
  Explanation : The maximum difference is between 9 and 7.
*/ 

class MaxDiff {
  public static void main(String[] args) {
    printMaxDiff(new int[]{2, 3, 10, 6, 4, 8, 1});
  }

  static void printMaxDiff(int a[]) {
    int maxDiff = 0;

    int minElement = Integer.MAX_VALUE;
    for (int i = 0; i < a.length - 1; i++) {
      System.out.println("--------------------------");
      System.out.println("Evaluating element " + a[i] + " and min : " + minElement);
      if (a[i] - minElement > maxDiff) {
        maxDiff = a[i] - minElement;
        System.out.println("Found new maxDiff at element " + a[i] + ": " + maxDiff);
      }

      minElement = (a[i] < minElement ? a[i] : minElement);
    }
    
    System.out.println("MaxDiff " + maxDiff);
  }
}
