/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        // Testcase 1 : happy path
        String[] strs1 = {
                "flower",
                "flow",
                "flowering",
                "flowery"
        };

        System.out.println("LCP : " + lcp(strs1));


        // Testcase 2 : empty lcp
        String[] strs2 = {
                "dog",
                "cat",
                "dad",
                "denver"
        };

        System.out.println("LCP : " + lcp(strs2));

        // Testcase 3 : one string is empty
        String[] strs3 = {
                "dog",
                "cat",
                "",
                "denver"
        };

        System.out.println("LCP : " + lcp(strs3));


        // Testcase 4 : empty input
        String[] strs4 = {};
        System.out.println("LCP : " + lcp(strs4));

        // Testcase 4 : null input
        String[] strs5 = {};
        System.out.println("LCP : " + lcp(null));
    }

    static String lcp(String[] strs) {
        // vertical scan
        int pos = 0;
        StringBuilder sb = new StringBuilder();


        if ((strs == null) || strs.length == 0) {
            return "";
        }

        while (true) {
            if (pos >= strs[0].length()) return sb.toString();
            char c = strs[0].charAt(pos);

            for (int i = 1; i < strs.length ; i++) {
                String s = strs[i];

                if (s.length() <= pos) {
                    return sb.toString();  // we hit the shortest member
                }

                if (s.charAt(pos) != c) {
                    return sb.toString();
                }
            }

            // c is matched for all strs
            System.out.println("Extending lcp " + c);
            sb.append(c);
            pos++;
        }
    }

}
