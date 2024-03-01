import java.util.Arrays;
import java.util.*;
/**
Level order traversal of tree
 */
public class Solution {

  public static void main(String[] args) throws Exception {
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n1 = new Node(1, n2, n3);
    Node n4 = new Node(4, n1, null);
  
    printLevels(n4);
  }

  static void printLevels(Node root) {
    Queue<Node> q = new LinkedList<>();

    if (root == null) {
      return;
    }

    Node nl = new Node(-1, null, null);
    q.offer(root);
    q.offer(nl);

    while(!q.isEmpty()) {
      //System.out.println("Dealing with " + q.peek().data);
      Node n = q.poll();

      if (n.data == -1) {
        System.out.println("");
        continue;
      }

      System.out.print(n.data + ",");
      if (n.left != null) {
        q.offer(n.left);
      } 
      if (n.right != null) {
        q.offer(n.right);
      }

      if (n.left != null || n.right != null) {
        q.offer(nl);
      }
    }
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
