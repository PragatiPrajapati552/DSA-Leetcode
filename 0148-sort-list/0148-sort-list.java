import java.util.*;/**
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
    public static ListNode mid(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     arr.add(temp.val);
        //     temp = temp.next;
        // }
        // int[] arr1 = new int[arr.size()];

        // for (int i = 0; i < arr.size(); i++) {
        // arr1[i] = arr.get(i);
        // }
        // Arrays.sort(arr1);
        // temp = head;
        // for(int i=0; i<arr1.length; i++){
        //     temp.val = arr1[i];
        //     temp = temp.next;
        // }
        // return head;
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = mid(head);

        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left,right);
    }
    public static ListNode merge(ListNode left, ListNode right){
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        while(left!=null && right!=null){
            if(left.val <= right.val){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
            else
            {   temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        while(left!=null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
            
        }
        while(right!=null){
            temp.next = right;
            right = right.next;
            temp = temp.next;    
        }
        return ans.next;

    }
}