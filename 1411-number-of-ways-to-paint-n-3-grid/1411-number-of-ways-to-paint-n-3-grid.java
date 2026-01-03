class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        long typeA = 6; // ABA
        long typeB = 6; // ABC

        for (int i = 2; i <= n; i++) {
            long newA = (typeA * 3 + typeB * 2) % MOD;
            long newB = (typeA * 2 + typeB * 2) % MOD;

            typeA = newA;
            typeB = newB;
        }

        return (int)((typeA + typeB) % MOD);
    }
}
