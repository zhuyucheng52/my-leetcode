package com.echo.problem0086;

/**
 * @author yucheng
 * @description
 * @create 2021-04-07 下午4:32
 */

public class Solution {

    public static class ListNode {
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

    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;

        ListNode lHeader = new ListNode();
        ListNode lCur = lHeader;

        ListNode geHeader = new ListNode();
        ListNode geCur = geHeader;
        while (cur != null) {
            if (cur.val < x) {
                lCur.next = cur;
                lCur = lCur.next;
            } else {
                geCur.next = cur;
                geCur = geCur.next;
            }
            cur = cur.next;
        }
        geCur.next = null;

        lCur.next = geHeader.next;
        return lHeader.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        current.next = new ListNode(4);
        current = current.next;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(5);
        current = current.next;
        current.next = new ListNode(2);
        current = current.next;

        print(head);

        Solution s = new Solution();
        head = s.partition(head, 3);
        print(head);
    }

    private static void print(ListNode n) {
        while (n != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println();
    }
}
