/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap <ListNode,Integer> set = new HashMap<>();
        ListNode temp = headA;
        while(temp != null){
            set.put(temp,temp.val);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
           if(set.containsKey(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }
}