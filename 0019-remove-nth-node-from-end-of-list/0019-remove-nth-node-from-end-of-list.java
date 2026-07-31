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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
        return null;
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        if(size == 1 && n==1){
        head = null;
        return head;
        }
        if(size == n){
            head = head.next;
            return head;
        }
        

        int fromStart = size - n;   // just before n , n=7 so fromstart = 6
        temp = head;
        for(int i=1; i<fromStart; i++){
            temp = temp.next;
        }
        if(n == 1){
        temp.next = null;
        return head;
        }

        temp.next = temp.next.next;
        return head;
    }
}