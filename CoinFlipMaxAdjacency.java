/**

Consider N coins aligned in a row. Each coin is showing either heads or tails. The adjacency of these coins is the number of pairs of adjacent coinst showing the same face.Return the maximum possible adjacency that can be obtained by reversing one coin, one of the coinst must be reversed

for example i have

1 1 0 1 0 0 
and after change third we get 1 1 1 1 0 0 so we have 4 pairs.

Approach:

1/ Find initial set of pairs (i,e. a[i] == a[i+1])
2/ Now go through each coin and find the impact/delta of flipping that.
   - if i flip and my left neighbor is not same, the delta is +1 or it is -1 (to original adjacency)
   - if i flip and my right neight is not same, the delta is +1 else it is -1
   
   Track the max value of positive delta
3/ so net adjancency = initial_adjancey + delta (could be negative as well. ex: [0, 0, 0])
   
*/
public class Solution {
  public static void main(String[] args) {
    printMaxAdjacency(new int[] {1, 1, 0, 1, 0, 0});
  }

  static void printMaxAdjacency(int a[]) {

    // Find current adjacency
    int current = 0;
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] == a[i + 1]) {
        current++;
      }
    }
    System.out.println("Current adjacency " + current);

    // Go over each coin and try flipping it. find the impact (delta) of each flip
    int maxImpact = -3;
    for (int i = 0; i < a.length; i++) {
      int impact = 0;
      
      if (i < a.length - 1) {
        if (a[i] == a[i+1]) {
          impact--;
        } else {
          impact++;
        }
      }

      if (i > 0) {
        if (a[i] == a[i-1]) {
          impact--;
        } else {
          impact++;
        }
      }

      System.out.println("Flipping element at " + i + " index. value " + a[i] + " has impact " + impact);
      if (impact > maxImpact) {
       System.out.println("new MaxImpact " + impact + " by flipping coin at index " + i);
       maxImpact = impact; 
      }
    }
  }
}
