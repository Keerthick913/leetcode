// Last updated: 14/07/2026, 16:17:36
class Solution {
    private ListNode reverse(ListNode curr, ListNode end) {
        ListNode prev = null;
        while(curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode tail = head;
        for(int i = 0; i < k; i++) {
            if(tail == null) return head;
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }
}