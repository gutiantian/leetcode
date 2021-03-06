/*
A linked list is given such that each node contains 
an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head, dummy = head;
        
        while(temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            map.put(temp, newNode);
            temp = temp.next;
        }
        
        while(dummy != null) {
            RandomListNode newNode = map.get(dummy);
            RandomListNode oldNext = dummy.next;
            RandomListNode oldRPT = dummy.random;
            newNode.next = map.get(oldNext);
            newNode.random = map.get(oldRPT);
            dummy = dummy.next;
        }
        
        return map.get(head);
    }
}

