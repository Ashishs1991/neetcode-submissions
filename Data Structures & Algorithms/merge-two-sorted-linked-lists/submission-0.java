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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        ListNode head = new ListNode(0);
        ListNode current =head;

        while(head1!=null && head2!=null) {
            if(head1.val<head2.val) {
                current.next = head1;
                head1 = head1.next;
            }else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

                    if(head1!=null) {
                current.next = head1;
            }

            if(head2!=null) {
                current.next = head2;
            }

        return head.next;
    }
}