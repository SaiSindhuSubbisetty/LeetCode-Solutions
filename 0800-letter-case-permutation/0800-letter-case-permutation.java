class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        return res;
        
    }
    private void backtrack(char[] arr,int idx, List<String> res){
        if(idx == arr.length){
            res.add(new String(arr));
            return;
        }
        if(Character.isLetter(arr[idx])){
            arr[idx] = Character.toLowerCase(arr[idx]);
            backtrack(arr,idx+1,res);
            arr[idx] = Character.toUpperCase(arr[idx]);
            backtrack(arr,idx+1,res);
        }
        else{
               backtrack(arr,idx+1,res);
        }
    }
}


