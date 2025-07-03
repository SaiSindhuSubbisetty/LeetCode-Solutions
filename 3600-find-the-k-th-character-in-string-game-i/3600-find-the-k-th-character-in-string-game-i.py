class Solution:
    def kthCharacter(self, k: int) -> str:
        word = "a"
  
        while len(word) < k:
            nextpart = ""
            for ch in word:
                if nextpart == 'z':
                    nextpart += 'a'
                else:
                    nextpart += chr(ord(ch)+1)
            word += nextpart
        return word[k-1]             

        