/*  Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/

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
        ListNode reversed_add_res = addList(l1, l2);
        return reversed_add_res;
    }
    
    private ListNode addList(ListNode l1, ListNode l2) { //注意， addList 怎么写的
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        
        int carry = 0;
        
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            tmp.next = new ListNode(cur);
            tmp = tmp.next;
        }
        
        while(l1 != null) {
            int sum = l1.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            tmp.next = new ListNode(cur);
            tmp = tmp.next;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            int sum = l2.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            tmp.next = new ListNode(cur);
            tmp = tmp.next;
            l2 = l2.next;
        }
        
        if(carry != 0) {
            tmp.next = new ListNode(carry);
        }
        
        return head.next;
    }
    
    private ListNode reverseList(ListNode head) { //注意， reverse List 怎么写的
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null; // Dummy Node 应用
        while(head != null) { // Reverse Manipulation
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
}