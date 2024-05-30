import java.util.*;

/*

https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/


Approach

1/ When you see open bracket, push the index (not the char) to stack
2/ when you see closed bracket, check the char at the top (you can use s.charAt(top)) : if it is open, do nothing. if not, add the
the index to a list of index_to_remove 
3/ All the left overs in stack will be open brackets. add them to list as well
4/ Use a string buffer to collect all the chars in the string not in the remove list

 */

class Solution {
  public static void main(String[] args) {
    String s = "ab)(d(cd))(((xyz";
    minRemove(s);
  }

  static void minRemove(String s) {
    Stack<Integer> stk = new Stack<>();
    Set<Integer> idxToRemove = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);

      if (c == '(') {
        stk.push(i);
      } else if (c == ')') {
        if (!stk.isEmpty() && s.charAt(stk.peek()) == '(') {
          // match ( and )
          stk.pop();
        } else {
          // unmatched )
          idxToRemove.add(i);
        }
      }
    }

    // Left over open bracks : add to to remove list
    for (Integer i : stk) {
      idxToRemove.add(i);
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      if (!idxToRemove.contains(i)) {
        sb.append(s.charAt(i));
      }
    }

    System.out.println(sb.toString());
  }

}
