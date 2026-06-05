class Solution {
    private String[] digitsToLetters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)
        {
            return result;
        }
        backtrack(result,digits,"",0);
        return result;
        
    }
    private void backtrack(List<String> result,String digits,String currentCombinations,int index)
    {
        if(index == digits.length())
        {
            result.add(currentCombinations);
            return;
        }
        String letters = digitsToLetters[digits.charAt(index)-'0'];
        for(char letter : letters.toCharArray())
        {
            backtrack(result,digits,currentCombinations+letter,index+1);
        }
    }
}