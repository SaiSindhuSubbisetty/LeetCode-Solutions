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
    public int getDecimalValue(ListNode head) {
        ListNode curr=head;
        List<Integer> binary=new ArrayList<>();
        while(curr!=null)
        {
            binary.add(curr.val);
            curr=curr.next;
        }
        int maxpower=(int)Math.pow(2,binary.size()-1);
        //System.out.println(maxpower);
        int result=0;
        for(int bit:binary)
        {
            int digit=bit*maxpower;
            result+=digit;
            maxpower/=2;
        }
        return result;
    }
}