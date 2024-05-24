
import java.util.*;

/*
 * https://leetcode.com/problems/
import java.util.*;

/*
 * https://leetcode.com/problems/random-pick-with-weight/description/
 * 
 *
 * Approach : Create a prefix sum array of same length. This should be thought of as
 * expanded range on the line. gneerate a rand number and search for it in the prefix sum. 
 */

class Solution {
  public static void main(String[] args) {
    WPicker p = new WPicker(new int[] {1, 10, 5});
    
    Map<Integer, Integer> m = new HashMap<>();

    for (int i = 0; i < 1000; i++) {
      int n = p.next();
      Integer freq = m.get(n);
      if ( freq == null) {
        m.put(n, 1);
      } else {
        m.put(n, freq + 1);
      }
    }

    System.out.println("---");
    m.forEach((key, value) -> System.out.println(key + " " + value));
  }
}

class WPicker {
  Random rand;
  int[] a;
  int[] prefixSums;

  WPicker(int[] a) {
    this.rand = new Random();
    this.a = a;

    prefixSums = new int[a.length];

    prefixSums[0] = a[0];
    for (int i = 1; i < a.length; i++) {
      prefixSums[i] = prefixSums[i-1] + a[i];  
    }
    System.out.println("Prefix sums : " + Arrays.toString(prefixSums));
  }

  int next() {
    int r = rand.nextInt(1, prefixSums[a.length - 1]);
    System.out.println("-----");
    System.out.println("random no: " + r);

    for (int i = 0; i < prefixSums.length; i++) {
      if (prefixSums[i] >= r) {
        System.out.println("Picked " + a[i]);
        return a[i];
      }
    }
  
    return -1;
  }
}
random-pick-with-weight/description/
 * 
 *
 * Approach : Create a prefix sum array of same length. This should be thought of as
 * expanded range on the line. gneerate a rand number and search for it in the prefix sum. 
 */

class Solution {
  public static void main(String[] args) {
    WPicker p = new WPicker(new int[] {1, 10, 5});
    
    Map<Integer, Integer> m = new HashMap<>();

    for (int i = 0; i < 1000; i++) {
      int n = p.next();
      Integer freq = m.get(n);
      if ( freq == null) {
        m.put(n, 1);
      } else {
        m.put(n, freq + 1);
      }
    }

    System.out.println("---");
    m.forEach((key, value) -> System.out.println(key + " " + value));
  }
}

class WPicker {
  Random rand;
  int[] a;
  int[] prefixSums;

  WPicker(int[] a) {
    this.rand = new Random();
    this.a = a;

    prefixSums = new int[a.length];

    prefixSums[0] = a[0];
    for (int i = 1; i < a.length; i++) {
      prefixSums[i] = prefixSums[i-1] + a[i];  
    }
    System.out.println("Prefix sums : " + Arrays.toString(prefixSums));
  }

  int next() {
    int r = rand.nextInt(1, prefixSums[a.length - 1]);
    System.out.println("-----");
    System.out.println("random no: " + r);

    for (int i = 0; i < prefixSums.length; i++) {
      if (prefixSums[i] >= r) {
        System.out.println("Picked " + a[i]);
        return a[i];
      }
    }
  
    return -1;
  }
}
