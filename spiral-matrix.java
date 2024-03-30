
/**

https://leetcode.com/problems/spiral-matrix/description/

Spiral matrix

Approach : 
Do outlayer first (top row, right col, bottom row and first col)
Proceed to inner layer 

Use recursion to go into inner layers. A inner matric can be uniquely defined by
top right corner element indices and number of rows and cols.

 */
class Solution {
  public static void main(String[] args) {
    int[][] a = {
      {1,2,3},
      {4,5,6},
      {7,8,9}
    };

    int[][] b = {
      {1,2,3,4},
      {5,6,7,8},
      {9,10,11,12}
    };

    printSpiral(a, 0, 0, a.length, a[0].length);
    printSpiral(b, 0, 0, b.length, b[0].length);
    
  }
  static void printSpiral(int a[][], int startI, int startJ, int rows, int cols) {
    // System.out.println("\n\n----startI=" + startI + " startJ=" + startJ + " rows=" + rows + " cols=" + cols);
    if (rows <= 0 || cols <=0) {
      return;
    }

    // print outer layer

    // top row
    // System.out.println("\nTop row");
    for (int j = startJ; j < startJ + cols; j++) {
      System.out.print(a[startI][j] + ",");
    }

    // right most col
    // System.out.println("\nRight col");
    for (int i = startI + 1; i < startI + rows; i++) {
      System.out.print(a[i][startJ + cols - 1] + ",");
    }

    // Bottom row; right to left; if there is only one row, this is not needed
    // System.out.println("\nBottom row");
    for (int j = (startJ + cols - 2); j >= startJ && rows > 1; j--) {
      System.out.print(a[startI + rows - 1][j] + ",");
    }

    // First col ; bottom to top; if there is only one col, this is not needed
    // System.out.println("\nFirst col");
    for (int i = startI + rows - 2; i >= startI + 1 && cols > 1; i--) {
      System.out.print(a[i][startJ] + ",");
    }

    // proceed to inner layer
    printSpiral(a, startI + 1, startJ + 1, rows - 2, cols - 2);
  }
}
