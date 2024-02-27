/*
 * Click `Run` to execute the snippet below!
 */



/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    getMaxCircular(new int[] {5, 3, 4, 11, 2});
  }

  static int getMaxCircular(int[] h) {
    int skipLastHome = getMaxLinear(h, 0, h.length - 2);   // 0 to n-1 homes
    int skipFirstHome = getMaxLinear(h, 1, h.length - 1);  // 1 to n homes

    System.out.println("skipFirstHome " + skipFirstHome + " skipLastHome " + skipLastHome);
    System.out.println("Max : " + Math.max(skipFirstHome, skipLastHome));

    return Math.max(skipFirstHome, skipLastHome);
  }

  static int getMaxLinear(int[] h, int start, int end) {
      int[] max = new int[end - start + 1];

      // Base cases
      if (start == end) {
       return h[start];
      } else if (start + 1 == end) {
        return Math.max(h[start], h[end]);
      }

      // more than 2 homes. Initialize n=0 and n=1 cases
      max[start] = h[start];
      if (h[start] > h[start + 1]) {
        max[1] = h[start];
      } else {
        max[1] = h[start + 1];
      }

      // Solve for n
      for (int i = start + 2; i < end; i++) {
        // include h[i] and h[i-2]
        int include = h[i] + max[i - 2];
        int exclude = max[i-1];

        if (include > exclude) {
          System.out.println("i=" + i + ", h[i]=" + h[i] + " inclusion is better. include value: " + include 
              + " exclude value : " + exclude);
          max[i] = include;
        } else {
          System.out.println("i=" + i + ", h[i]=" + h[i] + " exclusion is better. include value: " + include 
              + " exclude value : " + exclude);
          max[i] = exclude;
        }
      }

      return max[end-start];
  }
}
