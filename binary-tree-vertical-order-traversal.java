import java.util.Map.Entry;
import java.util.Map;
import java.util.*;

/* 

Print nodes of a binary tree in vertical order

https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

Approach :

Assign the relative position of each node to root (which has 0th position).
The node to its left is parents_position - 1 and to right parents_position + 1;
Keep a map of postion to all nodes. Use a treemap to keep the map sorted by lowest postion.
All the values in the map are vertically ordered :)

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

      Map<Integer, List<Integer>> m = new TreeMap<Integer, List<Integer>>();
      createVerticalMap(n_18, 0, m);
      
      for (Entry<Integer, List<Integer>> e : m.entrySet()) {
        System.out.println(e.getValue());
      }
    }

    static void createVerticalMap(Node n, int pos, Map<Integer, List<Integer>> map) {
      map.putIfAbsent(pos, new ArrayList<>());
      map.get(pos).add(n.data);

      if (n.left != null) {
        createVerticalMap(n.left, pos - 1, map);
      }

      if (n.right != null) {
        createVerticalMap(n.right, pos + 1, map);
      }
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
