/*

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).


Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
n is an integer.
Either x is not zero or n > 0.
-104 <= x^n <= 104

Questions

x : is this int (positive or negative) ? 
n : same. real or integer. pos or neg
really large values are possible.
n = 0 ==> maps to 1 (zero to zero ?)

TDD: First write up some test cases.


Approach :

Binary exponentiation, also known as exponentiation by squaring, is a technique for efficiently computing the power of a number. By repeatedly squaring xxx and halving nnn, we can quickly compute xnx^nx 
using a logarithmic number of multiplications.

 */

class Solution {

  public static void main(String[] args) {
    System.out.println(pow(2, 10));
    System.out.println(pow(2, 0));
    System.out.println(pow(2, -2));
  }

  static float pow(int x, int n) {

    System.out.println("pow called with x=" + x + " n=" + n);
    
    if (n < 0) {
      return 1/pow(x, -n);
    }

    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return x;
    }

    float v = 1;
    if (n % 2 == 0) {
      v = v * pow(x * x, n/2);
    } else {
      v = v * x * pow(x * x, (n-1)/ 2);
    }

    return v;
  }

  static float powBruteForce(int x, int n) {
    
    float v = 1;

    if (n == 0) {
      return 1;
    }

    // positive n
    int abs = Math.abs(n);
    for (int i = 0; i < abs ; i++) {
      v *= x;
    }

    if (n < 0) {
      v = (1/v);
    }

    System.out.println("x=" + x + " n=" + n + " pow " + v);
    return v;
  }
}
