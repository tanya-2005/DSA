/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        TreeNode current = root;
        int leftHeight = 0;
        while(current != null){
            current = current.left;
            leftHeight++;
        }

        current = root;
        int rightHeight = 0;
        while(current != null){
            current = current.right;
            rightHeight++;
        }

        if(leftHeight == rightHeight){
            return (1 << leftHeight) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}