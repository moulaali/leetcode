/*

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the
signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21

Questions to ask
  >> Is the input an integer 
 */

class Solution {
  public static void main(String[] args) {
    reverse(-12);
  }

  static int reverse(int n) {
    int reversed = 0; // signed int is 32 bit
    
    while (n != 0) {
      int left = n % 10;
      reversed *= 10; 
      reversed += left;
      n /= 10;

      System.out.println("reversed updated to " + reversed + " and n is now " + n);
    } 

    return reversed;
  }
}
