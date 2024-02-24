

/*

https://leetcode.com/problems/add-two-numbers/description/

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

*/

class Node {
  int d;
  Node next;

  Node(int d) {
    this.d = d;
  }

  static void print(Node n) {
    Node cur = n;
    while (cur != null) {
      System.out.print(cur.d + "->");
      cur = cur.next;
    } 
    System.out.println("");
  }

  static Node toList(int a[]) {
    Node head = null;
    Node prev = null;

    for (int i = 0; i < a.length; i++) {
      Node n = new Node(a[i]);
      //System.out.println("Adding a new node for " + a[i]);
      
    if (i == 0) {
        head = n;
        prev = head;
      } else {
        prev.next = n;
        prev = n;
      }
    }
  
    return head;
  }

  static Node add(Node num1, Node num2) {
    Node sumHead = null;
    Node prev = null;
    Node cur1 = num1;
    Node cur2 = num2;
    int carry = 0;
    
    while (cur1 != null || cur2 != null) {
      int newDigit = 0;

      if (cur1 != null && cur2 !=null) {
        // Both have a digit. add and carry over
        newDigit = cur1.d + cur2.d + carry;
      }

      if (cur1 != null && cur2 == null) {
        // first number is long
        System.out.println("First num is long " + cur1.d);
        newDigit = cur1.d + carry;
      }

      if (cur1 == null && cur2 != null) {
        // second number is long
        newDigit = cur2.d + carry;
      }

      if (newDigit >= 10) {
          newDigit = newDigit % 10;
          carry = 1;
      } else {
        carry = 0;
      }

      Node newNode = new Node(newDigit);
      System.out.println("Added new digit " + newDigit + " carryover " + carry);
      if (sumHead == null) {
        sumHead = newNode;
        prev = sumHead;

      } else {
        prev.next = newNode;
        prev = newNode;
      }

      if (cur1 != null) {
        cur1 = cur1.next;
      }

      if (cur2 != null) {
        cur2 = cur2.next;
      } 
    }

    if (carry > 0) {
      System.out.println("Carryover at the end " + carry);
      Node newNode = new Node(carry);
      prev.next = newNode;
    }

    return sumHead;
  }
}

class Solution {
  
  public static void main(String[] args) {
    Node num1 = Node.toList(new int[]{9,9,9,9,9,9,9});
    Node num2 = Node.toList(new int[]{9,9,9,9});
    Node.print(num1);
    Node.print(num2);

    Node sum = Node.add(num1, num2);
    Node.print(sum);  // [8,9,9,9,0,0,0,1]
  }
}
