import java.util.Map.Entry;
import java.util.*;
import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


/* 

Print nodes of a binary tree in vertical order

https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

Approach :

Additional constraints
1/ The values in same col should be level ordered
2/ The values from same level and col should be sorted

Do a bfs with a standard queue Approach
Use the trick of using queue length in an inside loop to identify the level and process ALL nodes in a level
Maintain a map of col->list_of_node_values to manage the vertical order
Queue should hold a pair of (Node, col) to know the column and use it to set the left child and right child

*/
class Solution {
    public static void main(String[] args) {
      // Setup the tree structure
      Node n_18 = new Node(18);
      Node n_13 = new Node(13);
      Node n_23 = new Node(23);
      Node n_6 = new Node(6);
      Node n_21 = new Node(21);
      Node n_20 = new Node(20);
      Node n_29 = new Node(29);
      Node n_9 = new Node(9);
      Node n_11 = new Node(11);



      n_18.left = n_13;
      n_18.right = n_23;

      n_13.left = n_6;
      n_13.right = n_21;

      n_23.left = n_20;
      n_23.right = n_29;

      n_6.right = n_9;
      n_9.right = n_11;

      
      printVertical(n_18);
    }

    static void printVertical(Node n) {
      Map<Integer, List<Integer>> m = new TreeMap<Integer, List<Integer>>();
      Queue<Pair<Node, Integer>> q = new LinkedList<>();
      
      q.add(Pair.of(n, 0));
      while (!q.isEmpty()) {
        
        int len = q.size();
        // Mini multimap to collect all values in same col to sort
        Multimap<Integer, Integer> mm = ArrayListMultimap.create();

        for (int i = 0; i < len; i++) {
          Pair<Node, Integer> hPair = q.poll();
          Node head = hPair.getKey();
          Integer col = hPair.getValue();
          
          mm.put(col, head.data);

          if (head.left != null) {
            q.add(Pair.of(head.left, col - 1));
          }
          if (head.right != null) {
            q.add(Pair.of(head.right, col + 1));
          }
        }

        for (Integer col : mm.keySet()) {
            List<Integer> l = new ArrayList<>(mm.get(col));
            Collections.sort(l);
            m.putIfAbsent(col, new ArrayList<>());
            m.get(col).addAll(l);
        }

      }


      for (Entry<Integer, List<Integer>> e : m.entrySet()) {
        System.out.println(e.getValue());
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
