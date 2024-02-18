import java.util.*;

class SimpleListIntersection {
  public static void main(String[] args) {
    List<String> l1 = Arrays.asList("a", "b", "c");
    List<String> l2 = Arrays.asList("d", "e", "b", "a");
    System.out.println(intersection(l1, l2));
  }

  static List<String> intersection(List<String> list1, List<String> list2) {

    Map<String, Boolean> m = new HashMap<>();
    List<String> common = new ArrayList<>();

    for(String s : list1) {
      m.put(s, true);
    }

    for (String s: list2) {
      if (m.containsKey(s)) {
        common.add(s);
      }
    }
    
    return(common);
  }
}
