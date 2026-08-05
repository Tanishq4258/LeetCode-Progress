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
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        for(int i=1;i<left;i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode leftNode = curr;
        ListNode prevNode = null;
        for(int i=0;i<right-left+1;i++){
            ListNode next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;
        }
        prev.next = prevNode;
        leftNode.next = curr;
        return dummy.next;
    }
}