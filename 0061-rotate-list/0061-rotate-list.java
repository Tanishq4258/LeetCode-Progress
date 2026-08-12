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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k==0) return head;
        ListNode temp = head;
        ListNode end = head;
        int c=1;
        
        while(end.next!=null){
            end = end.next;
            c++;
        }
        k = k%c;
        if(k==0) return head;
        end.next = head;
        for(int i=0;i<c-k-1;i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

}