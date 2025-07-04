class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 0:
            return ""
        
        max_len = 0
        start = 0
        
        for i in range(n):
            for j in range(i, n):
                substring = s[i:j+1]
                if substring == substring[::-1]:
                    if j - i + 1 > max_len:
                        max_len = j - i + 1
                        start = i
        
        return s[start:start+max_len]
