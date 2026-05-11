import java.util.Arrays;

/**
 * ou are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *
 * Questions
 * 1/ what to do if input array is not m+n. throw exception ?
 * 2/ Do i have to check that array is sorted or safe to assume ?
 * 3/ both empty arrays -> empty array back ?
 * 4/ update inplace in first array right ?
 * 5/ what if there are non-zero's in between zeros
 */
public class MergeSort {

    public static void main(String[] args) {
        // Test case 1 : second is exhausted first
        int[] first = {1, 2, 3, 0,0,0};
        mergeSortedArraysInplace(first, new int[] {4, 5, 6}, 3, 3);
        System.out.println("Merged value : " + Arrays.toString(first));


        // Test case 2 : first is exhausted first
        int[] firstTc2 = {4, 5, 6, 0,0,0};
        mergeSortedArraysInplace(firstTc2, new int[] {1, 2, 3}, 3, 3);
        System.out.println("Merged value : " + Arrays.toString(firstTc2));

        // Test case 3 : first is empty
        int[] firstTc3 = {0,0,0};
        mergeSortedArraysInplace(firstTc3, new int[] {1, 2, 3}, 0, 3);
        System.out.println("Merged value : " + Arrays.toString(firstTc3));

        // Test case 4 : second is empty
        int[] firstTc4 = {1, 2, 3};
        mergeSortedArraysInplace(firstTc4, new int[] {}, 3, 0);
        System.out.println("Merged value : " + Arrays.toString(firstTc4));

        // Test case 5 : both are empty
        int[] firstTc5 = {};
        mergeSortedArraysInplace(firstTc5, new int[] {}, 0, 0);
        System.out.println("Merged value : " + Arrays.toString(firstTc5));

        // Test case 6 : Input array is not m + n
//        int[] firstTc6 = {1, 2, 3, 0, 0};
//        mergeSortedArraysInplace(firstTc6, new int[] {4, 5, 6}, 3, 3);
//        System.out.println("Merged value : " + Arrays.toString(firstTc6));

        // Test case 7 : second array is not of length n
        int[] firstTc7 = {1, 2, 3, 0, 0};
        mergeSortedArraysInplace(firstTc7, new int[] {4, 5, 6}, 3, 2);
        System.out.println("Merged value : " + Arrays.toString(firstTc7));
    }

    static void mergeSortedArraysInplace(int[] first, int[] second, int m, int n) throws IllegalArgumentException {

        // validate
        if (first.length != m + n) {
            throw new IllegalArgumentException("input array does not have enough space to fill in");
        }

        if (second.length != n) {
            throw new IllegalArgumentException("The second array is not of length of " + n + " but " + second.length);
        }


        // interesting problem. it needs to be attacked from reverse direction :) and greater
        // and compare which is big. bit opposite of regular merge sort. beautiful problem
        int secondIdx = n - 1;
        int firstIdx = m - 1;
        int i = m + n - 1;
        while ( firstIdx >= 0 && secondIdx >= 0) {
            // System.out.println("comparing " + first[firstIdx] + ", " + second[secondIdx]);
            if (first[firstIdx] > second[secondIdx]) {
                first[i--] = first[firstIdx];
                firstIdx--;
            } else {
                first[i--] = second[secondIdx];
                secondIdx--;
            }
        }

        while (secondIdx >= 0) {
            first[i--] = second[secondIdx--];
        }
    }
}
