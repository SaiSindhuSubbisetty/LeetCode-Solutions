import java.util.*;
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num:nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    public int counter(int num){
       if(num < 0){
        num = num *-1;
       }
       return (int)Math.log10(num)+1;
    }
    public boolean even(int num){
        int numberOfDigits = counter(num);
        return numberOfDigits%2 == 0;

    }
}