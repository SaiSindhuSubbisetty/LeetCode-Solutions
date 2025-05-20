import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxLength = 0, maxFreq = 0;
        for(int right = 0;right < s.length(); right++)
        {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int windowSize = right - left + 1;
            int changesNeeded = windowSize - maxFreq;
            if(changesNeeded > k)
            {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
        
    }
}