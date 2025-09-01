import heapq

class Solution:
    def maxAverageRatio(self, classes, extraStudents: int) -> float:
        def gain(p, t):
            return (p + 1) / (t + 1) - p / t
        
        # Max heap (use -gain because heapq is min-heap)
        heap = [(-gain(p, t), p, t) for p, t in classes]
        heapq.heapify(heap)
        
        for _ in range(extraStudents):
            g, p, t = heapq.heappop(heap)
            p, t = p + 1, t + 1
            heapq.heappush(heap, (-gain(p, t), p, t))
        
        # Calculate average
        total_ratio = sum(p / t for _, p, t in heap)
        return total_ratio / len(classes)
