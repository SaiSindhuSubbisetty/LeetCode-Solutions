import java.util.*;
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int candidate1 = tops[0];
        int candidate2 = bottoms[0];
        int result = check(candidate1,tops,bottoms);
        if(result != -1)
        {
            return result;
        }
        else{
            return check(candidate2,tops,bottoms);
        }
        
    }
    private int check(int target, int[] tops, int[] bottoms){
        int rotationTops = 0;
        int rotationBottoms = 0;
        for(int i=0;i<tops.length;i++)
        {
            if(tops[i] != target && bottoms[i] != target)
            {
                return -1;
            }
            else if(tops[i] != target)
            {
                rotationTops++;
            }
            else if(bottoms[i] != target)
            {
                rotationBottoms++;
            }
        }
        return Math.min(rotationTops, rotationBottoms);
    }
}