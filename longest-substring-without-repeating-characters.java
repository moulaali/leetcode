/*
 * Click `Run` to execute the snippet below!
 */
import java.util.*;

/*
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

public class Solution {
  public static void main(String[] args) {
    printLongestSubstring("GEEKSFORGEEKS");
  }

  static void printLongestSubstring(String s) {
    Set<Character> seen = new HashSet<>();
    int start = 0;
    int end = 0;

    int max = -1;
    while (end < s.length()) {
      if (!seen.contains(s.charAt(end))) {
        System.out.println("Moving end ahead " + s.substring(start, end + 1));

        if (end - start > max) {
          System.out.println("**Found max sequence \"" + s.substring(start, end + 1) 
              + "\" start " + start + " end " + end + " of length " + (end - start + 1));
          max = (end - start);
        }
        seen.add(s.charAt(end));
      } else {
        System.out.println("Repeated char found \'" + s.charAt(end) + "\'' moving start past the duplicate");
        while (s.charAt(start) != s.charAt(end) && (start < end)) {
            seen.remove(s.charAt(start));
            start++;
        }

        start++; // No need to remove the duplicate char
        System.out.println("New window started : " + s.substring(start, end + 1));
      }

      end++;
    }
  }
}
