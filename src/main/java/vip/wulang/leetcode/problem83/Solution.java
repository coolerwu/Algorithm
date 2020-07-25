package vip.wulang.leetcode.problem83;

import vip.wulang.leetcode.structrue.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode one = head;
        ListNode two = head.next;

        while (two != null) {
            if (one.val == two.val) {
                two = two.next;
            } else {
                one.next = two;
                one = two;
                two = one.next;
            }
        }

        if (one.next != null) {
            one.next = null;
        }

        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            if (next == null) {
                break;
            } else if (next.val != cur.val) {
                cur = cur.next;
                continue;
            }

            next = next.next;
            cur.next = next;

            while (next != null && next.val == cur.val) {
                next = next.next;
                cur.next = next;
            }

            if (next == null) {
                break;
            }
        }

        return head;
    }
}