class Solution {
    public int majorityElement(int[] nums) {
        //Best Solution: Boyer-Moore Voting Algorithm (Optimal)
        int count = 0;
        int candidate = 0;
        for(int num : nums)
        {
            if(count == 0)
            {
                candidate = num;
            }
            count += (num == candidate)?1:-1;
        }
        return candidate;

    }
}
/*
 Genius Idea:
We don’t need to count everything. We can “cancel out” different numbers.

Imagine two teams: majority vs. others.

Every time we see the same number, we add to the score.

If we see a different one, we subtract.

If the score hits 0, we switch to a new candidate.
*/