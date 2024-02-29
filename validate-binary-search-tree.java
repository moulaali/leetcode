import java.util.Arrays;
/**
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class Solution {

  public static void main(String[] args) throws Exception {
    Node n1 = new Node(1);
    Node n6 = new Node(6);
    Node n3 = new Node(3);
    Node n4 = new Node(4, n3, n6);
    Node root = new Node(5, n1, n4);


    System.out.println("isValid = " 
        + isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }

  static boolean isValid(Node n, int min, int max) {

    if (n == null) {
      return true;  // null is a valid empty tree
    }

    if (n.data < min || n.data >= max) {
      System.out.println("Invalid : at " + n.data + " min=" + min + " max=" + max);
      return false;
    }

    boolean lstCheck = true;
    if (n.left != null) {
      lstCheck = isValid(n.left, min, n.data);
    } 

    boolean rstCheck = true;
    if (n.right != null) {
      rstCheck = isValid(n.right, n.data, max);
    }

    return (lstCheck && rstCheck);
  }
 
}

class Node {
  int data;
  Node left;
  Node right;

  Node(int data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  Node(int data) {
    this(data, null, null);
  }
}
