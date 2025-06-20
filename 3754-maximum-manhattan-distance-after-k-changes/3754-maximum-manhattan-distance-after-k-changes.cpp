class Solution {
public:
    static int maxDistance(string& s, int k) {
        const int n=s.size();
        int N=0, S=0, E=0, W=0, dist=0;
        for (int i=0; i<n; i++){
            const char c=s[i];
            switch(c){
                case 'N':N++; break;
                case 'S':S++; break;
                case 'E':E++; break;
                case 'W':W++; break;
            }
            const int d=abs(N-S)+abs(E-W)+2*k;
            dist=max(dist, min(d, i+1));
        }
        return dist;
    }
};