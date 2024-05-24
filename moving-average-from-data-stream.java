import java.util.*;

/* 
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.
 
Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]

Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3


Approach: Maintain the sliding window in a fixed size queue. dequeue if the size is full.
maintain the sum of elements and return the average.
*/
class Solution {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        ma.next(1);
        ma.next(5);
        ma.next(10);
        ma.next(6);
        ma.next(4);
    }
}

class MovingAverage {

    int size;
    Queue<Integer> q;
    double sum = 0;

    MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<>();
    }

    double next(int val) {
      
      if (q.size() == size) {
        Integer head = q.remove();
        sum = sum - head;
      }

      q.add(val);
      sum += val;
      double avg = (sum / q.size());

      System.out.println("Average after adding " + val + ":" + avg + " sum=" + sum);
      return avg;
    }
}
