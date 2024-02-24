/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

import org.hamcrest.collection.IsEmptyCollection;

/*

* https://leetcode.com/problems/find-median-from-data-stream/description/

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0

 */

class MedianFinder {
  // Creating a max-priority queue with a custom Comparator
  PriorityQueue<Integer> leftHalfMaxHeap;
  PriorityQueue<Integer> rightHalfMinHeap;

  void addNum(int i) {

    if (leftHalfMaxHeap.isEmpty()) {
      leftHalfMaxHeap.add(i);
      return;
    } 

    int l = leftHalfMaxHeap.peek();
    int r = (rightHalfMinHeap.isEmpty() ? Integer.MAX_VALUE : rightHalfMinHeap.peek());

    // Left or right ?
    if (i <= l) {
      System.out.println("Heading left : " + " num " + i + " max element of left " + l);
      leftHalfMaxHeap.add(i);
    } else {
      System.out.println("Heading right : " + " num " + i + " min element of right " + r);
      rightHalfMinHeap.add(i);
    }

    // Rebalance if sizes differ by more than 1
    int leftSize = leftHalfMaxHeap.size();
    int rightSize = rightHalfMinHeap.size();
    System.out.println("rebalance checking : " + leftSize + " " + rightSize);
    if ((leftSize - rightSize) > 1) {
      System.out.println("Rebalancing. left heap is bigger than 1. left " + 
          + leftHalfMaxHeap.size() + " right " + rightHalfMinHeap.size());
      rightHalfMinHeap.add(leftHalfMaxHeap.poll());
    } else if ((rightSize - leftSize) > 1) {
      System.out.println("Rebalancing. right heap is bigger than 1. left " + 
          + leftHalfMaxHeap.size() + " right " + rightHalfMinHeap.size());
      leftHalfMaxHeap.add(rightHalfMinHeap.poll());
    } else {
      System.out.println("Rebalance not needed");
    }
  }

  float findMedian() {

    if (leftHalfMaxHeap.size() == rightHalfMinHeap.size()) {
      System.out.println("Equal size heaps. tops : " + leftHalfMaxHeap.peek() + " " + rightHalfMinHeap.peek());
      return  (leftHalfMaxHeap.peek() + rightHalfMinHeap.peek()) / 2.0f;
    } 

    System.out.println("UnequalSize heaps. left size" + leftHalfMaxHeap.size() + " right size " 
      + rightHalfMinHeap.size());
    return ((leftHalfMaxHeap.size() > rightHalfMinHeap.size()) ? leftHalfMaxHeap.peek() : rightHalfMinHeap.peek());
  }

  MedianFinder() {
    leftHalfMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    rightHalfMinHeap = new PriorityQueue<>();
  }
}

class Solution {
  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    medianFinder.addNum(6);
    medianFinder.addNum(4);
    medianFinder.addNum(0);
    System.out.println(medianFinder.findMedian()); //
  }
}
