package com.echo.proplem0021;

/**
 * @author yucheng
 * @description
 * @create 2021-04-06 下午9:01
 */

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode current = head1;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(5);
        current = current.next;
        current.next = new ListNode(7);
        print(head1);

        ListNode head2 = new ListNode(2);
        current = head2;
        current.next = new ListNode(4);
        current = current.next;
        current.next = new ListNode(6);
        current = current.next;
        current.next = new ListNode(8);
        print(head2);

        Solution s = new Solution();
        ListNode n = s.mergeTwoLists(head1, head2);
        print(n);
    }

    private static void print(ListNode n) {
        while (n != null) {
            System.out.print(n.val + " ->");
            n = n.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
