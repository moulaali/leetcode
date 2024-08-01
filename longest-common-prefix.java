
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Approach : Straightforward, loop over every ith char of first string, check ith char of 1..n strings.
if you see a shorter string or different char, break.

 */

class Solution {
  public static void main(String[] args) {
    String[] input = new String[] {
      "flower",
      "flow",
      "flowerpot"
    };

    printLCP(input);
  }

  static String printLCP(String[] input) {
    if (input.length == 0) {
      return "";
    }

    boolean found = false;
    int i = 0;
    for (; i < input[0].length() && !found; i++) {
    
      System.out.println("Trying to add char " + input[0].charAt(i) + "...");

      for (int j = 1; j < input.length; j++) {
        if (input[j].length() <= i ) {
          System.out.println("\nFound the smallest string " + input[j]);
          found = true;
          break;
        }

        if (input[0].charAt(i) != input[j].charAt(i)) {
          System.out.println("\nChar differ at : " + input[0].charAt(i) + " i=" + i);
          found = true;
          break;
        }
      }
    }
    i--; // move back to LCP
    
    System.out.println("LCP :" + input[0].substring(0, i));
    return input[0].substring(0, i);
  }
}
