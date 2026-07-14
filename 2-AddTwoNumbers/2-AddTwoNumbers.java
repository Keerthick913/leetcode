// Last updated: 14/07/2026, 16:18:04
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Calculate the new carry and the digit to store
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            
            // Move the pointer forward
            current = current.next;
        }
        
        return dummyHead.next;
    }
}