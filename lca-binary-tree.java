/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    BST bst = new BST(17);

    // RST
    bst.add(21);
    bst.add(23);
    bst.add(18);

    // LST
    bst.add(13);
    bst.add(14);
    bst.add(15);
    bst.add(6);
    bst.add(7);
    bst.add(3);

    System.out.println(bst.lcaBinaryTree(bst.root, 6, 15).data);
  }
}

class BST {
  Node root;

  BST(int root) {
    this.root = new Node(root);
  }

  // Approach
  // If node value matches val1 or val2, return it to parent as lca. if not, call lca on left and right
  // when parent sees non-null value from lst and right, the node is the lca. if not, the non-null left or right
  // is lca
  Node lcaBinaryTree(Node n, int val1, int val2) {

    if (n == null) {
      return null;
    }

    if (n.data == val1 || n.data == val2) {
      return n;
    }

    Node leftSearch = lcaBinaryTree(n.left, val1, val2);
    Node rightSearch = lcaBinaryTree(n.right, val1, val2);

    if (leftSearch != null && rightSearch != null) {
      // one node on each side. lca
      return n;
    }

    Node lca = (leftSearch == null) ? rightSearch : leftSearch;

    return lca;
  }

  Node lca(Node n, int val1, int val2) {
    
    if (n == null) {
      return null;
    }

    if (val1 > n.data && val2 > n.data) {
      return lca(n.right, val1, val2);
    } else if (val1 < n.data && val2 < n.data) {
      return lca(n.left, val1, val2);
    } else {
      return n;
    }
  }

  void add(int data) {
    Node cur = root;
    Node newNode = new Node(data);

    while (cur != null) {
      if (data > cur.data) {
        if (cur.right == null) {
          cur.right = newNode;
          break;
        }

        cur = cur.right;
      } else {
        
        if (cur.left == null) {
          cur.left = newNode;
          break;
        }
        cur = cur.left;
      }
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
