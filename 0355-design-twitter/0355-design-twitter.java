import java.util.*;
class Twitter {
    private static int timeStamp = 0;
    private class User{
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id)
        {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }
        public void follow(int id)
        {
            followed.add(id);
        }
        public void unfollow(int id)
        {
            if(id != this.id)
            {
                followed.remove(id);
            }
        }
        public void post(int id)
        {
            Tweet newTweet = new Tweet(id);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }
    private class Tweet{
        int id;
        int time;
        Tweet next;

        public Tweet(int id)
        {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }
    
    private Map<Integer,User> userMap;
    public Twitter() {
        userMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId))
        {
            User newUser = new User(userId);
            userMap.put(userId,newUser);
        }
        userMap.get(userId).post(tweetId);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>();
        if(!userMap.containsKey(userId)) return newsFeed;

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(followedUsers.size(), (a,b) -> b.time - a.time);
        
        for(int user : followedUsers)
        {
            Tweet tweet = userMap.get(user).tweetHead;
            if(tweet != null)
            {
                tweetHeap.add(tweet);
            }
        }

        int count = 0;
        while(!tweetHeap.isEmpty() && count < 10)
        {
            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id);
            count++;
            if(tweet.next != null)
            {
                tweetHeap.add(tweet.next);
            }
        }
        return newsFeed;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId))
        {
            User newUser = new User(followerId);
            userMap.put(followerId,newUser);
        }
        if(!userMap.containsKey(followeeId))
        {
            User newUser = new User(followeeId);
            userMap.put(followeeId,newUser);
        }
        userMap.get(followerId).follow(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId) && followerId != followeeId)
        {
            userMap.get(followerId).unfollow(followeeId);

        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */