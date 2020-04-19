/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(-1);
        ListNode cur = res;
        int sum = 0;
        int carry = 0;
        while(l1 != null || l2 != null || sum > 0) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            if(sum >= 10) {
                sum -= 10;
                carry += 1;
            }
            
            cur.next = new ListNode(sum);
            cur = cur.next;
            sum = carry;
            carry = 0;
        }
        return res.next;
        
        
    }
}