// Last updated: 14/07/2026, 16:13:21
import java.util.*;
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double levelSum = 0; 
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(levelSum / size);
        }
        
        return result;
    }
}