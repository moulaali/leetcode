/*

https://leetcode.com/problems/calculate-amount-paid-in-taxes/description/

Example 1:

Input: brackets = [[3,50],[7,10],[12,25]], income = 10
Output: 2.65000
Explanation:
Based on your income, you have 3 dollars in the 1st tax bracket, 4 dollars in the 2nd tax bracket, and 3 dollars in the 3rd tax bracket.
The tax rate for the three tax brackets is 50%, 10%, and 25%, respectively.
In total, you pay $3 * 50% + $4 * 10% + $3 * 25% = $2.65 in taxes.
Example 2:

Input: brackets = [[1,0],[4,25],[5,50]], income = 2
Output: 0.25000
Explanation:
Based on your income, you have 1 dollar in the 1st tax bracket and 1 dollar in the 2nd tax bracket.
The tax rate for the two tax brackets is 0% and 25%, respectively.
In total, you pay $1 * 0% + $1 * 25% = $0.25 in taxes.
Example 3:

Input: brackets = [[2,50]], income = 0
Output: 0.00000
Explanation:
You have no income to tax, so you have to pay a total of $0 in taxes.
 */

class Solution {
  public static void main(String[] args) {
    int[][] brackets = {
      {3,50},
      {7,10},
      {12,25}
    };

     int[][] brackets2 = {
      {1,0},
      {4, 25},
      {5,50}
    };

    // System.out.println("Tax= $" + getTax(brackets, 10));
    System.out.println("Tax= $" + getTax(brackets2, 2));
  }

  static float getTax(int[][] brackets, int amount) {
    int remaining = amount;
    float tax = 0;
    int bracket = 0;

    while (remaining > 0) {
      
      int amountInBracket;
      if (bracket == 0) {
        amountInBracket = Math.min(remaining, brackets[bracket][0]);
      } else {
        amountInBracket = Math.min(remaining, brackets[bracket][0] - brackets[bracket - 1][0]);
      }

      float taxAtBracket = (float) (brackets[bracket][1] * amountInBracket) / 100;
      tax += taxAtBracket;
      remaining -= amountInBracket;
      System.out.println("Calculated tax for " + amountInBracket + " at percentage " + brackets[bracket][1] + " : $" + taxAtBracket + " with remaining " + remaining);
      bracket++;
    }

    return tax;
  }
}
