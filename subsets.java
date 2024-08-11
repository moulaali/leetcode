
import java.util.*;

/*
 * https://leetcode.com/problems/subsets/description/
 *
 * Powerset : Set of all subsets
 *
 * Union of :
     - subsets of all n-1 elements
     - single element set
     - element + each sub-set 
 */

class Solution {
  public static void main(String[] args) {
    Set<Integer> s = new HashSet<>(Set.of(1, 2));

    Set<Set<Integer>> subsets = getSubsets(s);
    for (Set<Integer> subset : subsets) {
      System.out.println(subset);
    }
  }

  static Set<Set<Integer>> getSubsets(Set<Integer> s) {
    Set<Set<Integer>> sets = new HashSet<>();

    Set<Integer> copy;
    for (Integer i : s) {
      copy = new HashSet<>(s);
      copy.remove(i);

      // All subsets from removing this element
      Set<Set<Integer>> subsets = getSubsets(copy);
      sets.addAll(subsets);

      // Single element subset
      sets.add(new HashSet<>(Set.of(i)));

      // subset + this element
      for (Set<Integer> sub : subsets) {
        Set<Integer> subCopy = new HashSet<>(sub);
        subCopy.add(i);
        sets.add(subCopy);
      }
    }

    return sets; 
  }
}
