/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> toDelete = new HashSet<>();

        for(int num : nums)
        {
            toDelete.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while(current.next != null)
        {
            if(toDelete.contains(current.next.val))
            {
                current.next = current.next.next;
            }else{
                current = current.next;
            }
            

        }
        return dummy.next;
        
    }
}