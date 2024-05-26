import java.util.ArrayList;
import java.util.List;

/** 

https://leetcode.com/problems/nested-list-weight-sum/description/

You are given a nested list of integers nestedList. Each element is either an 
integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, 
the nested list [1,[2,2],[[3],2],1] has each integer's value
set to its depth.

Return the sum of each integer in nestedList multiplied by its depth.

*/
class Solution {
  public static void main(String[] args) {
    // [[1,1],2,[1,1]]
    NList nlist = new NList();
    nlist
      .add(new NList().add(1).add(1))
      .add(2)
      .add(new NList().add(1).add(1));

    System.out.println(getWeightedSum(nlist, 1));
  }

  static int getWeightedSum(NList nlist, int depth) {

    
    int total = 0;
    for (int i : nlist.elements) {
      total += (i * depth);
    }

    for (NList nl : nlist.nlists) {
      total += getWeightedSum(nl, depth + 1);
    }

    System.out.println("Total : " + total + " depth " + depth);
    return total;
  }
}

class NList {
  
  List<Integer> elements;
  List<NList> nlists;

  NList() {
    this.elements = new ArrayList<>();
    this.nlists = new ArrayList<>();
  }

  NList add(int element) {
    elements.add(element);
    return this;
  }

  NList add(NList nlist) {
    nlists.add(nlist);
    return this;
  }
}
