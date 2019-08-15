package cn.keaper.p206;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
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
