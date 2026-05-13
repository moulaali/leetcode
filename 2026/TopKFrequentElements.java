import java.util.*;

/**
 *
 Code
 Testcase
 Test Result
 Test Result
 347. Top K Frequent Elements
 Solved
 Medium
 Topics
 conpanies icon
 Companies
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2

 Output: [1,2]

 Example 2:

 Input: nums = [1], k = 1

 Output: [1]

 Example 3:

 Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

 Output: [1,2]



 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 k is in the range [1, the number of unique elements in the array].
 It is guaranteed that the answer is unique.

 Questions

 > what if array is smaller than k ? return the n elements
 > what if they are multiple values with same freq  ? any is fine ?
 > return in the order ?

 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] topK = getTopKFrequent(new int[] { 3, 3, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 6, 7, 7, 3}, 2);
        System.out.println(Arrays.toString(topK));
    }

    static int[] getTopKFrequent(int[] input, int k) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        List<Integer> topK = new ArrayList<>();

        // Compute the freq map
        for (int i = 0; i < input.length; i++) {
            int current = freqCount.getOrDefault(input[i], 0);
            freqCount.put(input[i], current + 1);
        }
        System.out.println("Frequency map : ");
        freqCount.forEach((key,val) -> System.out.println(key + " -> " + val));

        // Get top k by mainting the k sized min heap
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            if (minHeap.size() == k) {
                if (minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();  // replace
                    minHeap.add(entry);
                }  // if not, drop on floor
            } else {
                minHeap.add(entry);
            }
        }

        int[] result = new int[minHeap.size()];

        // Fill the array from the end to the beginning
        // This puts the largest values (polled last) at the front
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
