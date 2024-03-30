/**
https://leetcode.com/problems/swap-nodes-in-pairs/description/

Given a linked list, swap every two adjacent nodes and return its head
You must solve the problem without modifying the values in the list' nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
*/
class Solution {
  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);

    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(n5);

    Node.print(n1);
    Node newHead = Node.swap(n1);
    Node.print(newHead);
  }
}

class Node {

  int i;
  Node next;

  Node(int data) {
    this.i = data;
  }

  void setNext(Node n) {
    this.next = n;
  }

  static void print(Node n) {
    while (n != null) {
      System.out.print(n.i + "->");
      n = n.next;
    }

    System.out.println("");
  }

  static Node swap(Node n) {
    
    // The new head is the second node 
    Node newHead = n;
    if (n != null) {
      newHead = n.next;
    }

    Node prev = null;
    while (n != null && n.next != null) {
      System.out.println("Swapping " + n.i + " " + n.next.i);

      // Point the second node from last swap to the next node 
      if (prev != null) {
        prev.next = n.next;
      }

      // point the neighbor's next to current node. save a pointer to skip neighbor (2->3 becomes 2->1)
      Node skipNeighbor = n.next.next;
      n.next.next = n;

      // point current node's next to skip neighbor (1->2 becomes 1->3)
      n.next = skipNeighbor;
      prev = n;

      // continue swapping from skip neighbor 
      n = skipNeighbor;
    }

    return newHead;
  }
}
