package cn.keaper.p143;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class Solution {

    /**
     * 使用双指针找到链表中间节点，断开中间节点，翻转后半截
     * 然后组合两个链表
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode node1 = head;
        ListNode node2 = reverseList(slow);

        while (node1.next != null){
            ListNode temp = node2.next;
            node2.next = node1.next;
            node1.next = node2;

            node1 = node2.next;
            node2 = temp;
        }
        node1.next = node2;

    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
