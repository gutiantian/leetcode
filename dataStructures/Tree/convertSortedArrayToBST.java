/* Convert Sorted Array to Binary Search Tree
Given a sorted (increasing order) array, 
Convert it to create a binary tree with minimal height(Balanced Height BST).
Notice
There may exist multiple valid solutions, return any of them.

Example
Given [1,2,3,4,5,6,7], return

     4
   /   \
  2     6
 / \    / \
1   3  5   7
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if(A == null || A.length == 0) {
            return null;
        }
        return buildTree(A, 0, A.length - 1);        
    }  
    private TreeNode buildTree(int[] A, int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(A[(start + end) / 2]);
        root.left = buildTree(A, start, (start + end) / 2 - 1);
        root.right = buildTree(A, (start + end) / 2 + 1, end);
        return root;
    }
}
