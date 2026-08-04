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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next= head;
        ListNode prev = dummy;

        for(int i =0;i<left-1;i++) {
            prev = prev.next;
        }

        ListNode subListHead = prev.next;
        ListNode subListTail = subListHead;

        for(int i=0;i<right-left;i++) {
            subListTail = subListTail.next;
        }

        ListNode nextNode = subListTail.next;
        subListTail.next = null;
        prev.next = reverse(subListHead);
        subListHead.next = nextNode;
        
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}