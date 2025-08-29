class Solution {
    public long flowerGame(int n, int m) {
        // int total = 0;
        // for(int i = 1; i <= n; i++) {
        //     if(i%2==0) {
        //         total += (m+1)/2;
        //     } else {
        //         total+= m/2;
        //     }
        // }
        // return total;

        long evenN = n/2;
        long oddN = n-evenN;
        long evenM = m/2;
        long oddM = m - evenM;
        return evenN * oddM + oddN * evenM;
    }
}