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
    public boolean hasCycle(ListNode head) {
        if( head==null || head.next==null || head.next.next==null) return false;
        
        ListNode fast = head.next.next;
        ListNode slow = head;

        while(slow!=fast) {
            if(slow ==null || slow.next==null) {return false;}
            if(fast ==null || fast.next==null) return false;

            slow = slow.next;
            fast= fast.next.next;
        }


        return true;
        
    }
}
