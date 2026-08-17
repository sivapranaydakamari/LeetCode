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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftList = dummy;
        for(int i = 1; i < left; i++){
            leftList = leftList.next;
        }
        
        ListNode prev = null;
        ListNode curr = leftList.next;
        ListNode next = null;
        ListNode reverseEnd = curr;
        for(int i = 0; i < (right - left + 1); i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        leftList.next = prev;
        reverseEnd.next = curr;
        return dummy.next;
    }
    
}