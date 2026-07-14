// Last updated: 14/07/2026, 16:12:35
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (low <= root.val && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } 
        else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } 
        else {
            return rangeSumBST(root.left, low, high);
        }
    }
}