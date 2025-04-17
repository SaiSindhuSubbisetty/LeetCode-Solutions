import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Step 1: Store characters of t and how many times they appear
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Sliding window
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        int matchCount = 0; // how many characters from t are satisfied
        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            // If this char is in t and count is enough, increase match count
            if (tMap.containsKey(rightChar) &&
                window.get(rightChar).intValue() == tMap.get(rightChar).intValue()) {
                matchCount++;
            }

            // Step 3: Try to shrink window from left if all characters matched
            while (matchCount == tMap.size()) {
                // Update answer if this window is smaller
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Shrink the window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing leftChar breaks a match, reduce matchCount
                if (tMap.containsKey(leftChar) &&
                    window.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                    matchCount--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
