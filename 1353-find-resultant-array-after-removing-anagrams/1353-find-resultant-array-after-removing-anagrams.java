import java.util.*;
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for(int i=1;i<words.length;i++)
        {
            String prev = result.get(result.size()-1);
            if(!isAnagram(prev,words[i]))
            {
                result.add(words[i]);
            }
        }
        return result;
        
    }

    private boolean isAnagram(String a,String b)
    {
        if(a.length() != b.length()) return false;
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);
        return Arrays.equals(a1,b1);
    }
}