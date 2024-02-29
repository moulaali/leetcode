/*

Given a sorted and rotated array arr[] of size N and a key, the task is to find the key in the array.

Note: Find the element in O(logN) time and assume that all the elements are distinct.

Example:  

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3
Output : Found at index 8

Questions

What to return if key is not found ?
Do i need to validate the rotation or assume it is valid ?


Approach

https://www.youtube.com/watch?v=U8XENwh8Oy8

This can be done similar to binary search but just with some changes.

1/ start with whole array (l = 0, r = length -1)
2/ find mid element. Now the first goal is to know if mid element is on left sorted portion or right sorted portion. compare the mid with left most element of the whole range. if we are greater, then we are left side (like 9), else
  we are on right (like 2, 3 < 5) 
3/ If we are left side
    - if target is greater than middle element, t should be on right (all numbers are smaller than mid on left half)
    - If target is less than middle element, it can be on left half or right half. use the left most a[l] to see if it is smaller than that. if so, it has to be right. if it is more than left most, it has to be on right
  4/ Right side is mirror logic.
    - if target is less than middle element, go left
    - if target is more, compare with right most to go left or right
 */

class Solution {
  public static void main(String[] args) {
    search(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}, 3);
  }

  static void search(int []a, int t) {
    int l = 0;
    int r = a.length - 1;

    while (l <= r) {
      int mid = l + ((r - l) / 2);
      System.out.println("l=" + l + "; a[l]=" + a[l]
          + "; r=" + r + "; a[r]" + a[r] + "; mid " 
          + mid + "; a[mid] " + a[mid]);
      
      if (a[mid] == t) {
        System.out.println("t found at index " + mid);
        break;
      }

      // left partition
      if (a[l] < a[mid]) {
          if (t > a[mid]) {
            // t can be only in right side
            l = mid + 1;
          } else {
            if (t < a[l]) {
              // t cannot be left side; go right
              l = mid + 1;
            } else {
              // t can only be in left side
              r = mid - 1;
            }
          }
      } else {
          // right partition
          if (t < a[mid]) {
            r = mid - 1;
          } else {
            if (t > a[r]) {
              // can be only left side
              r = mid - 1;
            } else {
              // can be only on right side
              l = mid + 1;
            }
          }
      }

      System.out.println("New l=" + l + "; a[l] = " + a[l] 
          + "; r=" + r + "; a[r]=" + a[r]  + "\n\n");
    }
  }
}

