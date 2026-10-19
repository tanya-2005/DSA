class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode originalRight = current.right;
                TreeNode rightMost = current.left;

                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = originalRight;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }
}