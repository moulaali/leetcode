import java.util.*;

import com.google.common.collect.Lists;

/*

https://leetcode.com/problems/group-anagrams/description/

Given an array of strings strs, group the anagrams together. You can return the
answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different
word or phrase, typically using all the original letters exactly once.
 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 */

class Solution {
  public static void main(String[] args) {
    printGroups(new String[]{"eat","tea","tan","ate","nat","bat"});
  }

  static void printGroups(String[] input) {
    Map<String, List<String>> groups = new HashMap<>();

    for (String s : input) {
      // Do not chain. wont work :)
      char[] sArray = s.toCharArray();
      Arrays.sort(sArray);
      String sorted = String.valueOf(sArray);

      List<String> cur = groups.get(sorted);
      if (cur != null) {
        cur.add(s);
      } else {
        ArrayList<String> newList = Lists.newArrayList(s);
        groups.put(sorted, newList);
      }
    }

    for (Map.Entry<String, List<String>> e : groups.entrySet()) {
      System.out.println(e.getKey() + ": " + e.getValue());
    }
  }
}

