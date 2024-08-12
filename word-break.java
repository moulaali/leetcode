import java.util.*;

/**

https://leetcode.com/problems/word-break/description

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Approach :

Interesting application of BFS. Think of indices as nodes and all valid jumps to following indices as edges.
A jump is valid if the substring from that index is a valid word in dict. We just need to do BFS from start to 
end of string. The queue contains the indices and we will enequeue valid jumps.

*/

class Solution {
  public static void main(String[] args) {
    Set<String> dict = Set.of(
      "cats",
      "dog",
      "sand",
      "and",
      "cat",
      "foo"
    );

    checkWordBreak(dict, "catsandfoocatsand");
  }

  static boolean checkWordBreak(Set<String> dict, String s) {

    Queue<Integer> q = new LinkedList<>();
    q.offer(0);

    while (!q.isEmpty()) {
      int from = q.poll();
      
      // end ?
      if (from == s.length()) {
        System.out.println("Reached end of string: word break is possible");
        return true;
      }

      // all valid jump locations from here
      for (int i = from; i < s.length(); i++) {
        String prefix = s.substring(from, i + 1);
        if (dict.contains(prefix)) {
          q.offer(i + 1); // valid jump
          // System.out.println("Found valid jump " + prefix + " from index : " + from + " to=" + i);
        }
      }

    }

    System.out.println("Word break is not possible");
    return false;
  }
}
