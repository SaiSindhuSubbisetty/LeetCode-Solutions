import java.util.*;

class Solution {

    class Range implements Comparable<Range> {
        int startIndex;
        long sum;
        long sumWithNext;
        Range prev;
        Range next;

        Range(int startIndex, long sum) {
            this.startIndex = startIndex;
            this.sum = sum;
        }

        @Override
        public int compareTo(Range other) {
            if (this.next == null || other.next == null) {
                return this.next == null ? 1 : -1;
            }
            long diff = this.sumWithNext - other.sumWithNext;
            return diff != 0 ? (diff < 0 ? -1 : 1)
                             : (this.startIndex - other.startIndex);
        }
    }

    public int minimumPairRemoval(int[] nums) {
        TreeSet<Range> set = new TreeSet<>();
        int decreasingCount = 0;
        Range iter = null;

        // Step 1: Build linked list and TreeSet
        for (int i = 0; i < nums.length; i++) {
            Range temp = new Range(i, nums[i]);
            if (iter == null) {
                iter = temp;
            } else {
                if (temp.sum < iter.sum) decreasingCount++;
                iter.next = temp;
                temp.prev = iter;
                iter.sumWithNext = iter.sum + temp.sum;
                set.add(iter);
                iter = temp;
            }
        }
        set.add(iter);

        // Step 2: Merge until array becomes non-decreasing
        int operations = 0;
        while (decreasingCount > 0) {
            operations++;
            Range smallest = set.pollFirst();

            if (smallest.next.sum < smallest.sum) decreasingCount--;
            smallest.sumWithNext = smallest.sum + smallest.next.sumWithNext;
            smallest.sum = smallest.sum + smallest.next.sum;

            Range removed = smallest.next;
            smallest.next = removed.next;

            if (removed.next != null) {
                if (removed.next.sum < removed.sum) decreasingCount--;
                removed.next.prev = smallest;
                if (smallest.sum > smallest.next.sum) decreasingCount++;
            }

            set.remove(removed);
            set.add(smallest);

            Range prev = smallest.prev;
            if (prev != null) {
                set.remove(prev);
                if (prev.sum > prev.sumWithNext - prev.sum) decreasingCount--;
                if (prev.sum > smallest.sum) decreasingCount++;
                prev.sumWithNext = prev.sum + smallest.sum;
                prev.next = smallest;
                set.add(prev);
            }
        }
        return operations;
    }
}