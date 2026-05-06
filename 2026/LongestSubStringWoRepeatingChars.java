import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * Solved
 * Medium
 * Topics
 * conpanies icon
 * Companies
 * Hint
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubStringWoRepeatingChars {
    public static void main(String[] args) {

        // Testcases
        System.out.println("emptyInput expected='' actual='" + getLSR("") + "'");
        System.out.println("singleChar expected='a' actual='" + getLSR("a") + "'");
        System.out.println("allSameChars expected='a' actual='" + getLSR("aaaaa") + "'");
        System.out.println("noRepeats expected='abcdef' actual='" + getLSR("abcdef") + "'");
        System.out.println("repeatAfterFullWindow expected='abc' actual='" + getLSR("abcabcbb") + "'");
        System.out.println("duplicateInsideWindow expected='ab' actual='" + getLSR("abba") + "'");
        System.out.println("leftPointerShouldNotGoBack expected='vdf' actual='" + getLSR("dvdf") + "'");
        System.out.println("immediateRepeatThenRecover expected='wke' actual='" + getLSR("pwwkew") + "'");
        System.out.println("longestEndsAtFinalChar expected='mzuxt' actual='" + getLSR("tmmzuxt") + "'");
        System.out.println("currentEndBugDetector expected='efadkrstuvwx' actual='" + getLSR("abcdefadkrstuvwx") + "'");
    }

    static String getLSR(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        Set<Character> seen = new HashSet<>();
        int currentStart = 0;
        int currentEnd = 0;
        int maxStart = 0;
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // if dupe found, move start ptr to 1 beyond the dupe
            while (seen.contains(c)) {
                seen.remove(str.charAt(currentStart));
                currentStart++;
            }

            currentEnd++;
            seen.add(c);

            if (currentEnd - currentStart > maxLength) {
                // new max found
                maxStart = currentStart;
                maxLength = currentEnd - maxStart;
            }
        }

        return str.substring(maxStart, maxStart + maxLength);
    }
}
