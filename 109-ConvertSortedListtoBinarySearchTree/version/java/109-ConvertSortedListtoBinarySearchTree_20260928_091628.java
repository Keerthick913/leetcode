// Last updated: 28/09/2026, 09:16:28
1class Solution {
2    public TreeNode sortedListToBST(ListNode head) {
3        if (head == null) return null;
4        if (head.next == null) return new TreeNode(head.val);
5        ListNode prev = null;
6        ListNode slow = head;
7        ListNode fast = head;
8        while (fast != null && fast.next != null) {
9            prev = slow;
10            slow = slow.next;
11            fast = fast.next.next;
12        }
13        if (prev != null) {
14            prev.next = null;
15        }
16
17        TreeNode root = new TreeNode(slow.val);
18        root.left = sortedListToBST(head != slow ? head : null);
19        root.right = sortedListToBST(slow.next);
20
21        return root;
22    }
23}