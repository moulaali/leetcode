
/**
 * https://leetcode.com/problems/inorder-successor-in-bst/description/
 *
 * Inorder successor in a BST
 *
 * Approach
 * 1/ Inorder walk : LST , node.val, RST
 * 2/ So the successor is
 *    - Left most descendant of RST (if RST is not null)
 *    - the parent node, if node is left child. if not, keep going up the parent path, till you are the left child.
 *    - It could be null as well (if you are the right most child). i.e. the max val
 */
import java.util.*;

public class BstSuccessor {
    public static void main(String[] args) {

        // Construct
        Node n13 = new Node(13);
        Node n6 = new Node(6);
        Node n29 = new Node(29);
        Node n4 = new Node(4);
        Node n11 = new Node(11);
        Node n1 = new Node(1);
        Node n5 = new Node(5);
        Node n10 = new Node(10);

        n13.left = n6;
        n13.right = n29;

        n6.parent = n13;
        n6.left = n4;
        n6.right = n11;

        n29.parent = n13;

        n4.parent = n6;
        n4.left = n1;
        n4.right = n5;

        n11.parent = n6;
        n11.left = n10;

        n10.parent = n11;

        n1.parent = n4;
        n4.parent = n5;


        // print level order
        printBfs(n13);


        getSuccessor(n29);
    }

    static Node getSuccessor(Node n) {
        if (n == null) {
            return null;
        }


        // case 1: RST is not empty
        if (n.right != null) {
            Node r = n.right;

            while (r.left != null) {
                r = r.left;
            }

            System.out.println("successor " + r.val);
            return r;
        }

        // case 2 and 3 : go up till you are the left child of your parent
        while (n != null && n.parent != null && n.parent.left != n) {
            n = n.parent;
        }

        if (n != null && n.parent != null) {
            System.out.print("Successor " + n.parent.val);
            return n.parent;
        }

        System.out.println("No successor for node " + n.val);
        return null;
    }

    static void printBfs(Node n) {
        Queue<Node> q = new LinkedList<>();

        q.offer(n);

        int count  = 0;
        while (!q.isEmpty() && count++ < 4) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node head = q.poll();

                System.out.print(head.val + ",");
                if (head.left != null) {
                    q.offer(head.left);
                }
                if (head.right != null) {
                    q.offer(head.right);
                }

            }

            System.out.println("");
        }

    }
}

class Node {
    int val;
    Node parent;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}
