// Last updated: 14/07/2026, 16:13:34
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null; // check null first
        if(root.val == val) return root;
        if(val > root.val){
            return searchBST(root.right, val);
        }
        if(val < root.val){
            return searchBST(root.left, val);
        }
        return null;
    }
}