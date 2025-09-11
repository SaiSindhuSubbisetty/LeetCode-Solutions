import java.util.*;
class Solution {
    public String sortVowels(String s) {
        String vowels  = "aeiouAEIOU";

        List<Character> extracted = new ArrayList<>();
        for(char ch : s.toCharArray()){
            if(vowels.indexOf(ch) != -1){
                extracted.add(ch);
            }
        }
        Collections.sort(extracted);

        StringBuilder result = new StringBuilder();
        int j = 0;
        for(char ch : s.toCharArray()){
            if(vowels.indexOf(ch)!=-1){
                result.append(extracted.get(j++));
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
        
    }
}