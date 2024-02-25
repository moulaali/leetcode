public class Solution {
  public static void main(String[] args) {
    int[] a = {2,3,5};
    int target = 8;
    
    Set<List<Integer>> combinations = new HashSet<>();
    List<Integer> current = new ArrayList<>();
    
    findCombos(a, target, current, combinations, 0);
    
    System.out.println("Combinations : " + combinations);
  }
  
  static void findCombos(int[] a, int target, List<Integer> current, Set<List<Integer>> combos, int currentIndex) {
    
    System.out.println("function called. target " + target + " current " + current + " currentIndex " + currentIndex);

    if (target == 0) {
      // Add everything in current to solution
      System.out.println("Found a new combo " + current);
      combos.add(new ArrayList<>(current));
      return;
    }
    
    for (int i = currentIndex; i < a.length; i++) {
      
      if (a[i] > target) {
        System.out.println("Skipping large number " + a[i] + " target " + target);
        continue;
      }
      
      current.add(a[i]);
      findCombos(a, target - a[i], current, combos, i);
      current.remove((Integer) a[i]);
    }
  }
}
