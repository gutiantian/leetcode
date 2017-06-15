/* Merge Two Sorted Lists
Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.

Related Question: Add Two Numbers
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }else{
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        
        if(l1 != null) { // updated, simpler
            head.next = l1;
        }
        
        if(l2 != null) {
            head.next = l2;
        }
        
        return dummy.next;
    }
}


/* 加强版 Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.
Example
Given lists:
[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists.size() == 0) {
            return null;
        }
        if(lists.size() == 1) {
            return lists.get(0);
        }
        ListNode ans = lists.get(0);
        for(int i = 1; i < lists.size(); i++) {
            ans = merge(lists.get(i), ans);
        }
        return ans;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }else{
                head.next = l2;
                l2 = l2.next;
                head = head.next;                
            }
        }
        if(l1 != null) {
            head.next = l1;
        }
        
        if(l2 != null) {
            head.next = l2;
        }
        
        return dummy.next;
    }
}

