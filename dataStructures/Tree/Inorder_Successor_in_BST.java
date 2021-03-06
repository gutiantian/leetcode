/* Inorder Successor in BST
Given a binary search tree and a node in it, find the in-order 
successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

In Binary Tree, Inorder successor of a node is the next node in 
Inorder traversal of the Binary Tree. 
Inorder Successor is NULL for the last node in Inoorder traversal.
In Binary Search Tree, Inorder Successor of an input node can also 
be defined as the node with the smallest key greater than the key of input node. 
So, it is sometimes important to find next node in sorted order.

                   20
                  /  \
                 8   22
                / \
               4   12
                  /  \
                 10  14 

In the above diagram, inorder successor of 8 is 10, 
inorder successor of 10 is 12 and inorder successor of 14 is 20.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while(root != null) {
            if(p.val >= root.val) { //往右拐
                root = root.right;
            }else { //往左拐
                succ = root;
                root = root.left;
            }
        }
        
        return succ;
    }
}