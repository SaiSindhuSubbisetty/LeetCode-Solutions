class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<>();
        backTrack(target,result,combination,0,candidates);
        return result;
    }
    public void backTrack(int target,List<List<Integer>> result,List<Integer> combination,int start,int[] candidates)
    {
        if(target == 0)
        {
            result.add(new ArrayList<Integer>(combination));
        }
        else if(target < 0)
        {
            return;
        }
        for(int i= start; i<candidates.length;i++)
        {
            combination.add(candidates[i]);
            backTrack(target-candidates[i],result,combination,i,candidates);
            combination.remove(combination.size()-1);
        }
    }
}