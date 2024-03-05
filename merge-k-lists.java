import java.io.*;
import java.util.*;

/*
 
Merge k sorteed lists to a single list.

 */

class Solution {
  public static void main(String[] args) {
    Set<LinkedList<Integer>> input = new HashSet<>();

    LinkedList<Integer> l1 = new LinkedList<>();
    LinkedList<Integer> l2 = new LinkedList<>();
    LinkedList<Integer> l3 = new LinkedList<>();
    LinkedList<Integer> ml = new LinkedList<>();

    l1.addLast(1);
    l1.addLast(2);
    l1.addLast(3);

    l2.addLast(0);
    l2.addLast(5);

    l3.addLast(-1);
    l2.addLast(13);

    print(l1);
    print(l2);
    print(l3);

    input.add(l1);
    input.add(l2);
    input.add(l3);
    
    PriorityQueue<SorterElement> pq = new PriorityQueue<>();

    // Add all lists to PriorityQueue
    for (LinkedList<Integer> l : input) {
        pq.offer(new SorterElement(l));
    }

    // keep popping the heap top, add to merged list. offer it back if is not isEmpty
    // if it is empty, skip as we consumed it fully.
    while (!pq.isEmpty()) {
      SorterElement e = pq.poll();
      ml.add(e.l.getFirst());
      e.l.removeFirst();
      if (!e.l.isEmpty()) {
        pq.offer(e);
      }
    }

    print(ml);
  }

  static void print(LinkedList<Integer> l) {
    for (Integer e : l) {
      System.out.print(e + "->");
    }

    System.out.println("");
  }
}

class SorterElement implements Comparable<SorterElement> {
  LinkedList<Integer> l;

  SorterElement(LinkedList<Integer> l) {
    this.l = l;
  }

  @Override
  public int compareTo(SorterElement e2) {
      return this.l.getFirst().compareTo(e2.l.getFirst());
 
  }
}
