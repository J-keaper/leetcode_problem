package cn.keaper.p92;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class Solution {

    /**
     * 首先遍历到m前一个位置，记录下左边一段的末尾和中间一段的末尾(就是当前相邻的两个元素)
     * 翻转[m,n]之间的元素
     * 将左边一段的末尾和新节点的头部连接
     * 中间一段的末尾和右边一段的开始连接
     *
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lt = dummy; // left tail
        for (int i = 1; i < m; i++) {
            lt = lt.next;
        }
        ListNode mt = lt.next; // mid tail

        ListNode prev = lt;
        ListNode cur = lt.next;
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        mt.next = cur;
        lt.next = prev;
        return dummy.next;
    }

}
