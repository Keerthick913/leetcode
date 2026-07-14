// Last updated: 14/07/2026, 16:13:09
class Solution 
{
  public int minDiffInBST(TreeNode root) 
  {
    inorder(root);
    return ans;
  }

  private int ans = Integer.MAX_VALUE;
  private Integer pred = null;

  private void inorder(TreeNode root) 
  {
    if (root == null)
      return;

    inorder(root.left);
    if (pred != null)
      ans = Math.min(ans, root.val - pred);
    pred = root.val;
    inorder(root.right);
  }
}