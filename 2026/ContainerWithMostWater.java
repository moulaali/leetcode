/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        getMaxWater(new int[] {1,8, 52 ,2,5,50,8,3,7});
        getMaxWater(new int[] {});
    }

    static int getMaxWater(int[] heights) {

        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while (l < r) {
            // compute the area
            int cur = Math.min(heights[l], heights[r]) * (r - l);

            if (cur > max) {
                max = cur;
                System.out.println("Found new max at : (" + heights[l] + "," + heights[r] + " ) + max : " + max);
            }

            // Move the smallest bar to increase the odd of more area
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }

}
