// Last updated: 15/07/2026, 14:15:43
1class Solution {
2    private int check(TreeNode root){
3        if (root == null) {
4            return 0;
5        }
6        int left = check(root.left);
7        int right = check(root.right);
8        if(left==-1 || right==-1) return -1;
9        if(Math.abs(left-right)>1) return -1;
10        return 1 + Math.max(left, right); 
11    }
12    public boolean isBalanced(TreeNode root) {
13       return check(root)!=-1;
14	}
15}