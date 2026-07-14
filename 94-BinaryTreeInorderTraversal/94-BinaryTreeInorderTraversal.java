// Last updated: 14/07/2026, 16:17:00
import java.util.*;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        inorder(node.left, result);   
        result.add(node.val);         
        inorder(node.right, result);  
    }
}