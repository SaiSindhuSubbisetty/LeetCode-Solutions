import java.util.*;
class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int maxVowel = 0;
        int maxConsonant = 0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                char ch = (char) ('a'+i);
                if(vowels.contains(ch)){
                    maxVowel = Math.max(maxVowel,freq[i]);
                }
                else{

                    maxConsonant = Math.max(maxConsonant,freq[i]);
                
                }
            }
        }
        
        return maxVowel+maxConsonant;
    }
}