import java.util.*;

/*
 
https://leetcode.com/problems/min-stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */

class Solution {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();

    minStack.push(0);
    minStack.push(0);
    minStack.push(0);
    System.out.println(" Min: " + minStack.min()); // return -3
    minStack.pop();
    System.out.println(" top: " + minStack.peek()); // return 0
    System.out.println(" Min: " + minStack.min()); // return -2
  }
}

class MinStack {
  Stack<Integer> s;
  Stack<Integer> mins;

  MinStack() {
    s = new Stack<>();
    mins = new Stack<>();
  }

  void push(int n) {
    System.out.println("-----");
    s.push(n);
    System.out.println("Pushing " + n);

    if (!mins.isEmpty()) {
      // System.out.println("Comparing " + mins.peek() + " and " + n);
      if (mins.peek() >= n) {
        System.out.println("pushed to mins as well.");
        mins.push(n);
      } 
    } else {
      System.out.println("pushed to mins as well.");
      mins.push(n);
    } 
  } 

  int pop() {
    int top = s.pop();
    if (mins.peek() == top) {
      L.log("Popped from minstack as well : " + top);
      mins.pop();
    }

    return top;
  }

  int min() {
    return mins.peek();
  }

  int peek() {
    return s.peek();
  }
}
