import java.util.*;
class Solution {
    public String sortVowels(String s) {
       String vowel = "aeiouAEIOU";

       List<Character> extracted = new ArrayList<>();
       int[] count = new int[128];
       for(char ch: s.toCharArray()){
         if(vowel.indexOf(ch) != -1){
            count[ch]++;
         }
       }
       StringBuilder result = new StringBuilder();
       int vowelPtr = 0;
       for(char ch:s.toCharArray()){
          if(vowel.indexOf(ch) != -1){
            while(vowelPtr < 128 && count[vowelPtr] == 0){
                vowelPtr++;
            }
            result.append((char) vowelPtr);
            count[vowelPtr]--;
          }
          else{
            result.append(ch);
          }


       }
       return result.toString();

    }
}
