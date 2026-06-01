import java.util.PriorityQueue;
class MedianFinder {
    private PriorityQueue<Integer> lo;
    private PriorityQueue<Integer> hi;

    public MedianFinder() {
        lo = new PriorityQueue<>((a,b) -> b-a); //maxHeap;
        hi = new PriorityQueue<>();//minHeap
        
    }
    
    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        if(lo.size() < hi.size())
        {
            lo.offer(hi.poll());
           
        }
        
    }
    
    public double findMedian() {
        return lo.size() > hi.size()?lo.peek():(lo.peek()+hi.peek())*0.5;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */