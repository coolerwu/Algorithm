package vip.wulang.leetcode.problem2;

import vip.wulang.leetcode.structrue.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, node;
        head = node = null;
        int count = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + count;
            count = val >= 10 ? 1 : 0;
            val = val >= 10 ? val - 10 : val;
            ListNode listNode = new ListNode(val);
            if (head == null) {
                head = node = listNode;
            } else {
                node.next = listNode;
                node = listNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + count;
            count = val >= 10 ? 1 : 0;
            val = val >= 10 ? val - 10 : val;
            ListNode listNode = new ListNode(val);
            node.next = listNode;
            node = listNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + count;
            count = val >= 10 ? 1 : 0;
            val = val >= 10 ? val - 10 : val;
            ListNode listNode = new ListNode(val);
            node.next = listNode;
            node = listNode;
            l2 = l2.next;
        }
        if (count == 1) {
            ListNode listNode = new ListNode(count);
            node.next = listNode;
        }
        return head;
    }
}