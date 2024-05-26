import java.util.*;

/*
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


To find all the possible neighbors, we dont have to iterate over all words. instead of Preprocess
to create a map of pattern to possible words. for example

h*t -> hot, hit
*og -> cog, log, bog 

To create this, for each word, replace each char by * and put a entry in map of : pattern -> word_list

*/

class Solution {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog", "bog");
    String begin = "hit";
    String end = "cog";

    
    bfs(words, begin, end);
  }

  static List<String> getPatterns(String word) {
    List<String> patterns = new ArrayList<>();

    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      chars[i] = '*';
      patterns.add(new String(chars));
      chars[i] = word.charAt(i);
    }

    return patterns;
  }

  private static void bfs(List<String> words, String begin, String end) {
    
    // Preprocess to create a pattern->[words]
    Map<String, List<String>> patternToWordsMap = new HashMap<>();
    for (String w : words) {
      List<String> patterns = getPatterns(w);
      for (String p : patterns) {
        if (patternToWordsMap.get(p) == null) {
          patternToWordsMap.put(p, new ArrayList<>());
        }  
        patternToWordsMap.get(p).add(w);
      }
    }
    System.out.println("Created patternmap : " + patternToWordsMap);

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
      // Neighbors can be easily found via looking up possible patterns of this word
      List<String> patterns = getPatterns(w);
      for (String p : patterns) {
        List<String> neighbors = patternToWordsMap.get(p);
        if (neighbors == null) {
          continue;
        }

        for (String n : neighbors) {
          if (path.containsKey(n)) {
          continue;
          }

          path.put(n, w);
          q.add(n);
        }        
      }

    }
  }
}
