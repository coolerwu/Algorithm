package vip.wulang.leetcode.problem23;

import vip.wulang.leetcode.structrue.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode node = lists[0];
        if (lists.length == 1) {
            return node;
        }

        for (int i = 1; i < lists.length; i++) {
            if (node == null) {
                node = lists[i];
                continue;
            }
            node = doMergeKLists(node, lists[i]);
        }

        return node;
    }

    private ListNode doMergeKLists(ListNode newNode, ListNode list) {
        if (list == null) {
            return newNode;
        }

        ListNode head = null;
        ListNode genNode = null;

        while (newNode != null && list != null) {
            if (newNode.val >= list.val) {
                if (genNode == null) {
                    genNode = list;
                    head = list;
                } else {
                    genNode.next = list;
                    genNode = list;
                }
                list = list.next;
            } else {
                if (genNode == null) {
                    genNode = newNode;
                    head = newNode;
                } else {
                    genNode.next = newNode;
                    genNode = newNode;
                }
                newNode = newNode.next;
            }
        }

        if (newNode != null) {
            genNode.next = newNode;
        }

        if (list != null) {
            genNode.next = list;
        }

        return head;
    }
}