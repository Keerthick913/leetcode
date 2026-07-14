// Last updated: 14/07/2026, 16:16:29
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        postorder(node.left, result);   
        postorder(node.right, result);  
        result.add(node.val);           
    }
}