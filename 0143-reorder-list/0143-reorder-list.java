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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        ListNode curr = head;
        int left = 0, right = list.size() - 1;
        while(left <= right){
            if(left == right){
                curr.val = list.get(left);
                break;
            }
            curr.val = list.get(left);
            curr = curr.next;
            curr.val = list.get(right);
            curr = curr.next;
            left++;
            right--;
        }
    }
}