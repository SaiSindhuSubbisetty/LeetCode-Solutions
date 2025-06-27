class Solution {
  public String longestSubsequenceRepeatedK(String s, int k) {
    String ans = "";
    int[] count = new int[26];
    List<Character> possibleChars = new ArrayList<>();
    Queue<String> q = new ArrayDeque<>(List.of(""));

    // Count characters
    for (final char c : s.toCharArray())
      ++count[c - 'a'];

    // Only keep chars with enough occurrences
    for (char c = 'a'; c <= 'z'; ++c)
      if (count[c - 'a'] >= k)
        possibleChars.add(c);

    // BFS: build subsequences, lexicographically largest first
    while (!q.isEmpty()) {
      final String currSubseq = q.poll();
      if (currSubseq.length() * k > s.length())
        return ans;
      for (final char c : possibleChars) {
        final String newSubseq = currSubseq + c;
        if (isSubsequence(newSubseq, s, k)) {
          q.offer(newSubseq);
          ans = newSubseq;
        }
      }
    }

    return ans;
  }

  // Helper: Check if subseq * k is a subsequence of s
  private boolean isSubsequence(final String subseq, final String s, int k) {
    int i = 0; // subseq's index
    for (final char c : s.toCharArray())
      if (c == subseq.charAt(i))
        if (++i == subseq.length()) {
          if (--k == 0)
            return true;
          i = 0;
        }
    return false;
  }
}