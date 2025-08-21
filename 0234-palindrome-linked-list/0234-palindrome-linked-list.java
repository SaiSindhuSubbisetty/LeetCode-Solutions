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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = reverseList(slow);
        ListNode p1 = head;
        ListNode p2 = secondHead;
        boolean isPalindrome = true;
        while(p2 != null){
            if(p1.val != p2.val){
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverseList(secondHead);
        return isPalindrome;
        
    }
    private ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}