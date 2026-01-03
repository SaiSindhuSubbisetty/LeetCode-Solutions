class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] countCharacter = new int[26];
        for(int i=0;i<s.length();i++)
        {
            countCharacter[s.charAt(i) - 'a']++;
            countCharacter[t.charAt(i) - 'a']--;
        }
        for(int count : countCharacter)
        {
            if(count != 0)
            {
                return false;
            }
        }
        return true;
        
        
    }
}