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
    private ListNode mergeLists(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(node1 != null && node2 != null){
            if(node1.val <= node2.val){
                curr.next = new ListNode(node1.val);
                node1 = node1.next;
            }else{
                curr.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            curr = curr.next;
        }
        while(node1 != null){
            curr.next = new ListNode(node1.val);
            node1 = node1.next;
            curr = curr.next;
        }
        while(node2 != null){
            curr.next = new ListNode(node2.val);
            node2 = node2.next;
            curr = curr.next;
        }

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if(lists.length < 1) return dummy.next;
        dummy.next = lists[0];
        for(int i = 1; i < lists.length; i++){
            dummy.next = mergeLists(dummy.next, lists[i]);
        }
        return dummy.next;
    }
}