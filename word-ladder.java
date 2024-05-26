import java.util.*;

/*

https://leetcode.com/problems/word-ladder/description/

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation
sequence.

Approach :
1/ BFS results in shortest path.
2/ Dequeue the word and add all its unseen neighbors. 
3/ if we want the path, we need to store the pointers to parent in hashmap as we add elements. 
we can follow the pointers to get the path.
4/ The above map can also be used for seen/visited list
*/

class Solution {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog", "bog");
    String begin = "hit";
    String end = "cog";

    bfs(words, begin, end);
  }

  private static void bfs(List<String> words, String begin, String end) {
    // BFS queue
    Queue<String> q = new LinkedList<>();
    q.add(begin);

    // Seen nodes with their parent pointer
    Map<String, String> path = new HashMap<>();
    path.put(begin, "");

    while (!q.isEmpty()) {
      String w = q.poll();
      
      if (w.equals(end)) {
        System.out.println("path found");

        // print the path using hashmap for parent words
        Stack<String> s = new Stack<>();
        while(!w.equals("")) {
          s.push(w);
          w = path.get(w);
        }

        while(!s.isEmpty()) {
          System.out.print(s.pop() + "->");
        }

        break;
      }

      // Enequeue unseen neighbors
      for (String word : words) {
        if (path.containsKey(word)) {
          continue;
        }

        if (differByChar(w, word)) {
          path.put(word, w);
          q.add(word);
        }
      }
    }
  }

  private static boolean differByChar(String s1, String s2) {
    
    if (s1.length() != s2.length()) {
      return false;
    }

    int diffCount = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        diffCount++;
        if (diffCount > 1) {
          break;
        }
      }
    }

    return (diffCount == 1);
  }
}
