import java.util.*;

/**

https://leetcode.com/problems/valid-sudoku/

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Examples:

[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]

Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Approach: Simple checking 

1/ for row check : reuse single hashset of seen digits
2/ for col check : use a list of 9 hashsets
3/ for box check : use a list of 9 hashset. A box-index for (i, j) can be retreived as :
((i / 3) * 3)  + (j / 3);

Questions to ask
 > What to do if i see a character other 1-9 or "."
 > Do you want me to validate it is 9x9 ?
 > Is the board 9x9 ?
 > Validity (vs) Solvability

 */


class Solution {
  public static void main(String[] args) {
    String[][] board = new String[][] {
        {"8","3",".",".","7",".",".",".","."},
        {"6",".",".","1","9","5",".",".","."},
        {".","9",".",".",".",".",".","6","."},
        {".",".",".",".","6",".",".",".","3"},
        {"4",".",".","8",".","3",".",".","1"},
        {"7",".",".",".","2",".",".",".","6"},
        {".","6",".",".",".",".","2","8","."},
        {".",".",".","4","1","9",".",".","5"},
        {".",".",".",".","8",".",".","7","9"}
    };

    isValid(board);
  }

  static boolean isValid(String[][] b) {

    int n = 9;
    boolean valid = true;
    // Init the hashsets
    ArrayList<Set<String>> colSets = new ArrayList<>();
    ArrayList<Set<String>> boxSets = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      colSets.add(new HashSet<>());
      boxSets.add(new HashSet<>());
    }

    for (int i = 0; i < n; i++) {
      Set<String> rowSeen = new HashSet<>();
      


      for (int j = 0; j < n; j++) {


        if (b[i][j].equals(".")) {
          continue;
        }

        // Box check
        int idx = ((i / 3) * 3)  + (j / 3);
        if (boxSets.get(idx).contains(b[i][j])) {
            System.out.println("Invalid. Box " + idx + " contains duplicate " + b[i][j]);
            valid = false;
            break;
        } else {
            boxSets.get(idx).add(b[i][j]);
        }

        // Check the right colSet
        if (colSets.get(j).contains(b[i][j])) {
            System.out.println("Invalid. Col " + j + " contains duplicate " + b[i][j]);
            valid = false;
            break;
        } else {
            colSets.get(j).add(b[i][j]);
        }

        // row check
        if (rowSeen.contains(b[i][j])){
          System.out.println("Invalid. Row " +  i+ " contains duplicate " + b[i][j]);
          valid = false;
          break;
        } else {
          rowSeen.add(b[i][j]);
        }
      }
    }

    System.out.println("Valid " + valid);
    return valid;
  }
}
