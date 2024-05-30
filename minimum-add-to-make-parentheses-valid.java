import java.util.*;

/*
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Approach:
Push ( into stack. if we see a ), pop if stack is not empty and has ( on top. At the end, stack length is the answer
 */

class Solution {
  public static void main(String[] args) {
    String s = "((()";
    minAdd(s);
  }

  static void minAdd(String s) {
    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);

      if (c == '(') {
        stk.push(c);
      } else if (c == ')') {
        if (!stk.isEmpty() && stk.peek() == '(') {
          // match ( and )
          stk.pop();
        } else {
          // unmatched )
          stk.push(c);
        }
      }
    }

    System.out.println(stk.size());
    for (Character c : stk) {
      System.out.print(c);
    }
  }

}
