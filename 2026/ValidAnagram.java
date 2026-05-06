import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {
    public static void main(String args[]) {

        // Test cases
        System.out.println("abc, cba  :" + areAnagramsSort("abc", "cba"));
        System.out.println("abc, cbx  :" + areAnagramsSort("abc", "cbx"));
        System.out.println("null, empty  :" + areAnagramsSort(null, ""));

        // Can be faster with a map approach : o(n) vs o(nlogn)
    }

    static boolean areAnagramsSort(String first, String second) {
        if (first == null || second == null) {
            return false;  // question : what if both are null ?
        }

        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        Arrays.sort(firstChars);
        Arrays.sort(secondChars);

        return (Arrays.equals(firstChars, secondChars));
    }
}
