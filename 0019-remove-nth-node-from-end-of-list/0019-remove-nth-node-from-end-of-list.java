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
    public ListNode reverse(ListNode head){
        ListNode prevNode = null;
        ListNode currNode = head;
        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = reverse(head);
        int x = 1;
        ListNode prev = null;
        if(n==1 && temp.next == null){
            return null;
        }
        if(n==1 && temp.next!=null){
            return reverse(temp.next);
        }
        ListNode res = temp;
        while(temp!=null){
            if(x==n){
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
            x++;
        }
        return reverse(res);
    }
}