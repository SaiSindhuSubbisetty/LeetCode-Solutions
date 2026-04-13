class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || nums == null || k<=0)
        {
            return new int[0];
        }
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n-k+1];

        for(int i=0;i<k;i++)
        {
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result[0] = nums[deque.peekFirst()];

        for(int i=k;i<n;i++)
        {
            if(deque.peekFirst() <= i-k)
            {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
            result[i-k+1] = nums[deque.peekFirst()];
        }
        return result;

        
    }
}