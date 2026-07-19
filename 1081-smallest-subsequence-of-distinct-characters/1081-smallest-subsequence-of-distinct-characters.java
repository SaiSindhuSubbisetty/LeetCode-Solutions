class Solution {
    public String smallestSubsequence(String s) {

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        boolean[] inStack = new boolean[26];

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {

            freq[c - 'a']--;

            if (inStack[c - 'a']) {
                continue;
            }

            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > c &&
                   freq[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(c);
            inStack[c - 'a'] = true;
        }

        return stack.toString();
    }
}