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
    public static void reverse(ArrayList<Integer> arr, int low, int high){
        while(low < high){
            int temp = arr.get(low);
            arr.set(low, arr.get(high));
            arr.set(high, temp);
            low++;
            high--;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k==1) return head;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        int i=0;
        while(i+k-1 < arr.size()){
            reverse(arr, i, i+k-1);
            i += k;
        }
        for(i=0; i < arr.size(); i++){
            cur.next = new ListNode(arr.get(i));
            cur = cur.next;
        }
        return dummy.next;
    }
}