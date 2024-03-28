
// Simple binarysearch
class Solution {
  public static void main(String[] args) {
      int a[] = new int[] {3, 5, 13, 17, 33, 99, 212};
      binarysearch(a, 99);
      binarysearch(a, 3);
      binarysearch(a, -1);
  }

  static int binarysearch(int[] a, int target) {

    System.out.println("-----------");

    if (a.length == 0) {
      return -1;
    } 

    int l = 0, r = (a.length - 1);
    while (l < r) {
      int mid = l + (r - 1) / 2;
      System.out.println("mid; idx=" + mid + " val " + a[mid]);

      if (a[mid] == target) {
        System.out.println("found at idx: " + mid + " " + a[mid]);
        return mid;
      } else if (a[mid] > target) {
        // left half
        r = mid - 1;
      } else {
        // right half
        l = mid + 1;
      }
    }

    System.out.println("Not found");

    return -1;
  }
}
