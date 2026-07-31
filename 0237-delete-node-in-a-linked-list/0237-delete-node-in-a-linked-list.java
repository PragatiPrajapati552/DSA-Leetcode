/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;       //duplicates the node
        node.next = node.next.next;     //skip the next node, basically the data of 5 is replaced with 1
    }
}