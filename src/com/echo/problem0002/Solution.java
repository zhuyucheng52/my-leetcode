package com.echo.problem0002;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 5878 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode n = head;

        int carry = 0;
        do {
            int sum = 0;
            if (Objects.nonNull(l1)) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (Objects.nonNull(l2)) {
                sum += l2.val;
                l2 = l2.next;
            }

            int total = sum + carry;

            n.next = new ListNode(total % 10);
            n = n.next;

            carry = total / 10;
        } while (Objects.nonNull(l1) || Objects.nonNull(l2));

        if (carry > 0) {
            n.next = new ListNode(carry);
        }

        return head.next;
    }


    public static void main(String[] args) {
        ListNode n11 = new ListNode(3);
        ListNode n12 = new ListNode(4, n11);
        ListNode n13 = new ListNode(2, n12);


        ListNode n21 = new ListNode(4);
        ListNode n22 = new ListNode(6, n21);
        ListNode n23 = new ListNode(5, n22);
        ListNode n24 = new ListNode(6, n23);

        Solution s = new Solution();
        ListNode n = s.addTwoNumbers(n13, n24);
        print(n);
    }

    private static void print(ListNode n) {
        while (n != null) {
            System.out.print(n.val + " ");
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
//leetcode submit region end(Prohibit modification and deletion)
