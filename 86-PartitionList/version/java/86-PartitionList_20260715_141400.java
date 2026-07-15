// Last updated: 15/07/2026, 14:14:00
1class Solution {
2    public ListNode partition(ListNode head, int x) {
3        ListNode slist = new ListNode();
4        ListNode blist = new ListNode();
5        ListNode small = slist;
6        ListNode big = blist;
7        while (head != null) {
8            if (head.val < x) {
9                small.next = head;
10                small = small.next;
11            } else {
12                big.next = head;
13                big = big.next;
14            }
15            head = head.next;
16        }
17        small.next = blist.next;
18        big.next = null;
19        return slist.next;        
20    }
21}