import java.util.Map.Entry;
import java.util.*;

/* 

Given two sparse vectors, compute their dot product.

Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?

Example 1:

Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
Example 2:

Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
Output: 0
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
Example 3:

Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
Output: 6


Approach :

Can be solved cleanly with a hashmap as internal compressed store. the map store the index and value of those elements whose
value is non-zero. when multiplying for dot product, look for the index (key) in other vector. if it is not present, it means
it is 0.

*/
class Solution {
    public static void main(String[] args) {
    
      SparseVec v1 = new SparseVec(new int[]{0,1,0,0,2,0,2});
      SparseVec v2 = new SparseVec(new int[]{1,0,0,0,3,0,4});

      dotProduct(v1, v2);
    }

    static int dotProduct(SparseVec v1, SparseVec v2) {
      SparseVec minVec;
      SparseVec otherVec;
      if (v1.idxToValMap.size() < v2.idxToValMap.size()) {
        minVec = v1;
        otherVec = v2;
      } else {
        minVec = v2;
        otherVec = v1;
      }

      int dot = 0;
      for (Entry<Integer, Integer> e : minVec.idxToValMap.entrySet()) {
        dot += (e.getValue() * otherVec.idxToValMap.getOrDefault(e.getKey(), 0));
      }

      System.out.println("Dot product : " + dot);
      return dot;
    }
}

class SparseVec {
  Map<Integer, Integer> idxToValMap;

  SparseVec(int[] a) {
    idxToValMap = new HashMap<>();

    // Build a map for non-zero indexes (with corresponding val)
    for (int i = 0; i < a.length; i++) {
      if (a[i] != 0) {
        idxToValMap.put(i, a[i]);
      }
    }
  }
}
