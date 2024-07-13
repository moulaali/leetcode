import java.util.*;

/**
 * Simple Twitter feed
 * Print all the tweets of all the followers in most recent first fashion
 * 
 * Approach : To do global ordering, do a merge sort of lists using a heap. 
 * Use logical clocks (incremental int) for simplicity
 */
public class SimpleTwitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.post(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]

        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.follow(1, 3);    // User 1 follows user 3.
        twitter.post(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.post(2, 7); // User 2 posts a new tweet (id = 7).
        twitter.post(3, 8); // User 2 posts a new tweet (id = 8).
        System.out.println(twitter.getFeed(1));  // 8, 7, 6, 5

        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getFeed(1));  // 8, 5
    }

    static class Tweet {
        int id;
        int ts;

        Tweet(int id, int ts) {
            this.id = id;
            this.ts = ts;
        }
    }

    static class TweetList implements Comparable<TweetList> {
        Tweet t;
        List<Tweet> list;
        int idx;

        TweetList(Tweet t, List<Tweet> list, int idx) {
            this.t = t;
            this.list = list;
            this.idx = idx;
        }

        @Override
        public int compareTo(TweetList o) {
            return Integer.compare(o.t.ts, this.t.ts);
        }
    }

    static class Twitter {
        Map<Integer, List<Tweet>> userToTweets;
        Map<Integer, List<Integer>> follows;
        int current = 0;

        Twitter() {
             userToTweets = new HashMap<>();
             follows = new HashMap<>();
        }

        List<Integer> getFeed(int uId) {
            List<Integer> followes = follows.get(uId);
            PriorityQueue<TweetList> heap = new PriorityQueue<>();
            List<Integer> feed = new ArrayList<>();

            // self tweets
            if (userToTweets.containsKey(uId)) {
                List<Tweet> selfTweets = userToTweets.get(uId);
                heap.add(new TweetList(selfTweets.getFirst(), selfTweets, 0));
            }

            // create heap of recent tweets of all followes
            if (followes != null) {
                for (Integer f : followes) {
                    List<Tweet> followeeTweets = userToTweets.get(f);
                    if (followeeTweets != null && !followeeTweets.isEmpty()) {
                        heap.add(new TweetList(followeeTweets.getFirst(), followeeTweets, 0));
                    }
                }
            }


            // get the min of all and keep moving the next in the list
            while (!heap.isEmpty()) {
                TweetList list = heap.poll();
                feed.add(list.list.get(list.idx).id);
                if (list.idx + 1 < list.list.size()) {
                    heap.add(new TweetList(list.t, list.list, list.idx + 1));
                } // else : list exhausted
            }

            return feed;
        }

        void post(int uId, int tId) {
            if (!userToTweets.containsKey(uId)) {
                userToTweets.put(uId, new ArrayList<>());
            }

            userToTweets.get(uId).addFirst(new Tweet(tId, current++));
        }

        void follow(int uIdFollower, int uidFollowee) {
            if (!follows.containsKey(uIdFollower)) {
                follows.put(uIdFollower, new ArrayList<>());
            }

            follows.get(uIdFollower).addFirst(uidFollowee);
        }

        void unfollow(int uIdFollower, int uidFollowee) {
            if (follows.containsKey(uIdFollower)) {
                follows.get(uIdFollower).remove((Integer) uidFollowee);
            }
        }
    }
}
