from collections import Counter
class Solution:
    def lengthAfterTransformations(self, s, t, nums):
        m = 10**9 + 7
        A = [[0]*26]; B = [[0]*26 for _ in range(26)]
        for c, v in Counter(s).items(): A[0][ord(c)-97] = v
        for i, sh in enumerate(nums):
            for j in range(sh): B[i][(i+1+j)%26] = 1
        def mul(X, Y):
            return [[sum(a*b for a, b in zip(r, c)) % m for c in zip(*Y)] for r in X]
        def power(X, n):
            if n == 1: return X
            p = power(mul(X, X), n//2)
            return mul(X, p) if n % 2 else p
        return sum(map(sum, mul(A, power(B, t)))) % m