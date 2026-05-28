class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freqMap= new HashMap<>();
        for(char task:tasks)
        {
            freqMap.put(task,freqMap.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        maxHeap.addAll(freqMap.values());
        int time = 0;
        while(!maxHeap.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<n+1;i++)
            {
                if(!maxHeap.isEmpty())
                {
                    temp.add(maxHeap.poll());
                }
            }

            for(int freq : temp)
            {
                if(--freq > 0)
                {
                    maxHeap.add(freq);
                }
            }

            time += maxHeap.isEmpty()?temp.size():n+1;
        }
        return time;

        
    }
}