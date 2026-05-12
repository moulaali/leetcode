import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Questions
 *
 * empty input -> empty output
 * should i validate end >= start for all intervals ?
 * negative ints
 * are the ranges closed or open
 */
public class MergeIntervals {

    public static void main(String[] args) {

        // Test case 1 : happy path
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(2, 6);
        intervals[1] = new Interval(1, 3);
        intervals[2] = new Interval(5, 10);
        intervals[3] = new Interval(15, 18);

        Interval[] merged = merge(intervals);
        System.out.println("Merged final output " + Arrays.toString(merged));

        // Test case 2 : empty list
        System.out.println("--- Testcase 2 : empty list ---");
        Interval[] intervals2 = new Interval[0];
        merged = merge(intervals2);
        System.out.println("Merged final output " + Arrays.toString(merged));

        // Test case 3 : couple of merges and couple unmergable
        System.out.println("--- Testcase3 : empty list ---");
        Interval[] intervals3 = new Interval[4];
        intervals3[0] = new Interval(2, 6);
        intervals3[1] = new Interval(1, 3);
        intervals3[2] = new Interval(7, 10);
        intervals3[3] = new Interval(15, 18);

        merged = merge(intervals3);
        System.out.println("Merged final output " + Arrays.toString(merged));
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 2. Override the compareTo method
        @Override
        public int compareTo(Interval other) {
            // Sort by start time ascending
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            // If start times are equal, sort by end time
            return Integer.compare(this.end, other.end);
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }

        static boolean doOverlap(Interval first, Interval second) {
            return (second.start <= first.end);
        }
    }

    static Interval[] merge(Interval[] input) {
        if (input.length == 0) {
            return new Interval[]{};
        }

        Arrays.sort(input);
        System.out.println("Sorted output " + Arrays.toString(input));
        List<Interval> merged = new ArrayList<>();
        merged.add(input[0]);

        // Scan from left to right and keep adding to merged list
        int k = 0;
        for (int i = 1; i < input.length; i++) {
            if (Interval.doOverlap(merged.get(k), input[i])) {
                System.out.print(merged.get(k) + " and " + input[i] + " overlap. ");
                int mergedStart = Math.min(merged.get(k).start, input[i].start);
                int mergedEnd = Math.max(merged.get(k).end, input[i].end);
                Interval newMerged = new Interval(mergedStart, mergedEnd);
                merged.remove(k);
                merged.add(newMerged);

                System.out.println("Added new merged " + newMerged);
            } else {
                merged.add(input[i]);
                k++;
            }
        }
        return merged.toArray(new Interval[0]);
    }
}
