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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }
        int[] arr1 = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
        arr1[i] = arr.get(i);
        }
        Arrays.sort(arr1);
        temp = head;
        for(int i=0; i<arr1.length; i++){
            temp.val = arr1[i];
            temp = temp.next;
        }
        return head;
        
    }
}