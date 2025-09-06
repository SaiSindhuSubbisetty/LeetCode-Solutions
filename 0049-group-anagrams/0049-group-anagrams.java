import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> map = new HashMap<>();
       for(String word : strs){
          int[] count = new int[26];
          for(char c:word.toCharArray())
          {
             count[c - 'a']++;
          }
         StringBuilder sb = new StringBuilder();
          for(int c:count)
          {
             sb.append('#').append(c);
          }
          String key = sb.toString();
          map.computeIfAbsent(key,k->new ArrayList<>()).add(word);
       }
       return new ArrayList<>(map.values());
       
    }
}
