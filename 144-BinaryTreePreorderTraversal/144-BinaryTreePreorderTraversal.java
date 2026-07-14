// Last updated: 14/07/2026, 16:16:30
class Solution {
     List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;
    }
    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        ans.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}