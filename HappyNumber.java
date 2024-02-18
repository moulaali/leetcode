import java.util.HashSet;
import java.util.Set;

/*
 * Click `Run` to execute the snippet below!
 */
/**
*
* https://leetcode.com/problems/happy-number/

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the 
sum of the squares of its digits, and repeat the process 
until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: n = 19
Output: True
19 is Happy Number,
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
As we reached to 1, 19 is a Happy Number.

Input: n = 20
Output: False
12 + 02 + 02 = 1
*

Approach : 
Trivially solvable by simple hashset (seen) and looping. 
Slightly interesting way is to use two counters. 
one that does once and the other that does it twice. 
Similar to faster pointer and slow pointer in loop detection. 
In this approach, we dont need the extra memory for list. 
We pay for computation though.

*
*/
class Solution {

  public static void main(String[] args) {
    System.out.println(getSquareSum(123));

    System.out.println(19 + " IsHappy ? " + isHappy(19));
    System.out.println("==========");
    System.out.println(20 + " IsHappy ? " + isHappy(20));
  }

  static boolean isHappy(int n) {

    int fasterNum = n;

    while (true) {

        int sum = getSquareSum(n);
        int secondSum = getSquareSum(getSquareSum(fasterNum));
        System.out.println("Squared sum of " + n + " : " + sum + " Second sum " + secondSum);

        if (sum == 1) {
          return true;
        }

        // second sum comparison
        if (sum == secondSum) {
          System.out.println("hare caught turtle. FirstSum " + sum + " secondSum: " + secondSum);
          return false;
        }

        n = sum;
        fasterNum = secondSum;
    }
  }
  
  // Trivial version with seen list
  static boolean isHappyWithSeenList(int n) {
    Set<Integer> seen = new HashSet<>();

    while (true) {
      int sum = getSquareSum(n);
      System.out.println("Squared sum of " + n + " : " + sum);
      
      if (sum == 1) {
        return true;
      } else if (seen.contains(sum)) {
        System.out.println("This number is already seen " + sum);
        return false;
      }

      seen.add(sum);
      n = sum;
    }
  }

  static int getSquareSum(int n) {
    int sum = 0;

    while (n != 0) {
      sum += (int) Math.pow((n % 10), 2);
      n = (n / 10);
    }

    return sum;
  }
}
