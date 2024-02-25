/*

https://leetcode.com/problems/longest-palindromic-substring/editorial/

Input: str = “forgeekskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.

Input: str = “Geeks” 
Output: “ee”

Approach : 

For each char, get max odd palindrome by expanding left and right (centered at i)
For each (char, next_char), get max even palindrome by expanding left and right (centered at i, i+1)
Track the max.

O(n*n) approach. There is O(n) Manacher's algorithm which is over-kill/hard for given time. Check with interviewer

 */

class Solution {
  public static void main(String[] args) {
    // String s = "forgeeksskeegfor";
    String s = "xxfarrafay";
    printLongestPalindrome(s);
  }

  static void printLongestPalindrome(String s) {
    String max = "";

    for (int i = 0; i < s.length(); i++) {
      // expand both ways at i 
      String maxOdd = expand(s, i, i);
      System.out.println("longest odd pal at " + s.charAt(i) + ":" + maxOdd);
      max = (maxOdd.length() > max.length() ? maxOdd : max);
      
      // expand both ways from i, i + 1
      String maxEven = expand(s, i, i + 1);
      System.out.println("longest even pal at " + s.charAt(i) + ":" + maxEven);
      max = (maxEven.length() > max.length() ? maxEven : max);
    }

    System.out.println("--Max : " + max);
  }

  static String expand(String s, int i, int j) {
     int l = i, r = j;
      while (l >= 0 && (r < s.length())) {
        if (s.charAt(l) == s.charAt(r)) {
          //System.out.println("(char match) long pal at char\'" + s.charAt(i) + "\'': l = " + s.charAt(l) + " r = " + s.charAt(r));
          l--;
          r++;
        } else {
          //System.out.println("(char mismatch) long pal at \'" + s.charAt(i) + "\'': l = " + s.charAt(l) + " r = " + s.charAt(r));
          break;
        }
      }

      // shrink back by 1 char to capture the palindrome
      l++;
      r--;
      
      return s.substring(l, r + 1);
  }
}
