package cn.keaper.p876;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class Solution {

    /**
     * 两个指针，一个指针速度为2，一个指针速度为1，当快指针走到末尾，慢指针走到中间节点
     */
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode fast = head,slow = head;
        while (fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }else {
                return slow;
            }
            slow = slow.next;
        }
        return slow;
    }

}
