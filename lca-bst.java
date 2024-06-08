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

    System.out.println(bst.lca(bst.root, 6, 7).data);
  }
}

class BST {
  Node root;

  BST(int root) {
    this.root = new Node(root);
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
