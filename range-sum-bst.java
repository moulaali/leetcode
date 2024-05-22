/**

https://leetcode.com/problems/range-sum-of-bst/description/

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive
range [low, high].

Approach : if a node data is in range, add to sum. if lst can also contain the range, traverse lst. same with rst with recursion.
Worst case : O(n) which cannot be avoided if all nodes fall in range. else, we will avoid subtrees which wont potentially contain value.

*/ 
class Solution {

 public static void main(String[] args) {
    // Setup the tree structure
    Node n_18 = new Node(18);
    Node n_13 = new Node(13);
    Node n_23 = new Node(23);
    Node n_6 = new Node(6);
    Node n_17 = new Node(17);
    Node n_20 = new Node(20);
    Node n_29 = new Node(29);

    n_18.left = n_13;
    n_18.right = n_23;

    n_13.left = n_6;
    n_13.right = n_17;

    n_23.left = n_20;
    n_23.right = n_29;

    System.out.println(getRangeSum(n_18, 20, 29));
  }

  static int getRangeSum(Node n, int l, int r) {
    int sum = 0;

    if (n == null) {
      return sum;
    }

    // in range ?
    if (n.data >= l && n.data <= r) {
      System.out.println("Added data to sum " + n.data);
      sum += n.data;
    }

    // traverse lst ?
    if (n.data > l) {
      sum += getRangeSum(n.left, l, r);
    }

    // traverse rst ?
    if (n.data < r) {
      sum += getRangeSum(n.right, l, r);
    }

    // System.out.println("Returning sum " + sum + "for node " + n.data);
    return sum;
  }
}

class Node {
  int data;
  
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
  }
}
