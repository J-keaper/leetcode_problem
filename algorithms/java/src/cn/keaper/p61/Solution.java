package cn.keaper.p61;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class Solution {

    /**
     * 首先遍历一遍链表，将尾节点指向首节点，同时计算链表长度
     * 然后再次遍历遍历链表，从 len-k 处截断链表即可
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int len = 1;
        ListNode node = head;
        while (node.next != null){
            node = node.next;
            len ++;
        }
        node.next = head; // 将尾节点指向首节点
        k %= len;
        int rl = len - k; // right length

        ListNode cur = head;
        for (int i = 1; i < rl; i++) {
            cur = cur.next;
        }// 此时cur指向第len-k个节点
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }

}
