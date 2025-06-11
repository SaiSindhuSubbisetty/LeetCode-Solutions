/**
 * A class that finds the maximum difference between frequencies of any two digits
 * within substrings of a given minimum length, considering parity constraints.
 */
import java.util.Arrays;
public class Solution {
    private static final int BAD_DIFF = Integer.MAX_VALUE / 2;

    /**
     * Calculates the maximum frequency difference between any two digits
     * in any substring of length at least k.
     * 
     * @param s The input string containing digits ('0' to '4')
     * @param k The minimum length of substring to consider
     * @return The maximum difference between counts of two digits a and b in any valid substring
     */
    public static int maxDifference(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] mpdAB = new int[4]; // Min prefix diffs for (a - b) with parity
        int[] mpdBA = new int[4]; // Min prefix diffs for (b - a) with parity
        boolean[] isAbsent = new boolean[5]; // Flags to skip digits not present
        int result = Integer.MIN_VALUE;

        // Try all pairs (a, b) where a > b
        outer:
        for (char a = '1'; a <= '4'; a++) {
            inner:
            for (char b = '0'; b < a; b++) {
                if (isAbsent[b - '0']) continue;

                int right = 0, arf = 0, brf = 0;

                // Expand window to ensure both 'a' and 'b' are present and len ≥ k
                while (right < k || arf + brf < 3 || arf == 0 || brf == 0) {
                    if (right == n) {
                        if (brf == 0) isAbsent[b - '0'] = true;
                        if (arf == 0) {
                            isAbsent[a - '0'] = true;
                            continue outer;
                        } else {
                            continue inner;
                        }
                    }
                    char c = chars[right++];
                    if (c == a) arf++;
                    else if (c == b) brf++;
                }

                int left = 0, alf = 0, blf = 0;
                Arrays.fill(mpdAB, BAD_DIFF);
                Arrays.fill(mpdBA, BAD_DIFF);
                mpdAB[0] = mpdBA[0] = 0;

                // Sliding window from left to right
                while (true) {
                    int parityState, freqDiff;

                    // Shrink window to maintain at most one fewer of a/b than total
                    while (left < right - k) {
                        char c = chars[left++];
                        if (c == a) {
                            if (arf == alf + 1) {
                                left--;
                                break;
                            }
                            alf++;
                        } else if (c == b) {
                            if (brf == blf + 1) {
                                left--;
                                break;
                            }
                            blf++;
                        } else continue;

                        parityState = ((alf & 1) << 1) + (blf & 1);
                        freqDiff = alf - blf;
                        mpdAB[parityState] = Math.min(mpdAB[parityState], freqDiff);
                        mpdBA[parityState] = Math.min(mpdBA[parityState], -freqDiff);
                    }

                    parityState = ((arf & 1) << 1) + (brf & 1);
                    freqDiff = arf - brf;

                    // Compare against opposite parity state to maximize diff
                    result = Math.max(result, freqDiff - mpdAB[parityState ^ 2]);
                    result = Math.max(result, -freqDiff - mpdBA[parityState ^ 1]);

                    if (right == n) break;

                    // Move right pointer and update freq
                    char c = chars[right++];
                    if (c == a) arf++;
                    else if (c == b) brf++;
                    else {
                        while (right < n && (c = chars[right]) != a && c != b)
                            right++;
                    }
                }
            }
        }
        return result;
    }

    /** Example usage */
    public static void main(String[] args) {
        String input = "01234401234";
        int k = 3;
        System.out.println("Max Difference: " + maxDifference(input, k));
    }
}