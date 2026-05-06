public class Main {
    public static void main(String[] args) {
        NumberList result = add(NumberList.fromNumber(9999999), NumberList.fromNumber(9999));
        result.print();
    }

    private static NumberList add(NumberList first, NumberList second) {
        NumberList sum = new NumberList();
        int carry = 0;

        Node a = first.head;
        Node b = second.head;

        while (true) {
            System.out.println("----- new iteration --- carry :  " + carry);

            int digitSum = 0;

            if (a != null && b != null) {
                digitSum = a.val + b.val;
                a = a.next;
                b = b.next;
            } else if (a == null && b != null) {
                digitSum = b.val;
                b = b.next;
            } else if (a != null && b == null) {
                digitSum = a.val;
                a = a.next;
            } else {
                // ✅ both null — only continue if carry remains
                if (carry > 0) {
                    sum.addDigit(carry);
                }
                break;
            }

            digitSum += carry;

            System.out.println("digitSum : " + digitSum);

            carry = digitSum / 10;           // ✅ replaces your if/else carry logic
            sum.addDigit(digitSum % 10);     // ✅ reusing addDigit to build result
        }

        return sum;
    }

    static class NumberList {
        Node head;
        Node tail;

        NumberList() {}

        // ✅ constructor that accepts an int, reuses addDigit
        NumberList(int num) {
            while (num != 0) {
                addDigit(num % 10);
                num /= 10;
            }
        }

        // ✅ fromNumber now just delegates to constructor
        static NumberList fromNumber(int num) {
            return new NumberList(num);
        }

        void addDigit(int digit) {
            Node n = new Node(digit);
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }

        void print() {
            Node n = head;  // ✅ start from head
            while (n != null) {
                System.out.print(n.val + (n.next != null ? "->" : ""));
                n = n.next;
            }
            System.out.println();
        }
    }

    static class Node {
        int val;
        Node next;

        Node() {}
        Node(int val) { this.val = val; }
    }
}
