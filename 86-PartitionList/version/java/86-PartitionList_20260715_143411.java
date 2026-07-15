// Last updated: 15/07/2026, 14:34:11
1class Solution {
2    TreeNode first;
3    TreeNode second;
4    TreeNode prev;
5    public void recoverTree(TreeNode root) {
6        helper(root);
7        int temp = first.val;
8        first.val = second.val;
9        second.val = temp;
10    }
11    void helper(TreeNode node) {
12        if (node == null) return;
13        helper(node.left);
14        if (prev != null && prev.val > node.val) {
15            if (first == null) {
16                first = prev;
17            }
18            second = node;
19        }
20        prev = node;
21        helper(node.right);
22    }
23}