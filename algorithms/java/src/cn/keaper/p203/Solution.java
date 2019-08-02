package cn.keaper.p203;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode next = removeElements(head.next,val);
        if(head.val == val){
            return next;
        }
        head.next = next;
        return head;
    }


    public ListNode removeElements1(ListNode head, int val) {
        ListNode node = head;
        while (node != null && node.val == val){
            node = node.next;
        }
        head = node;
        while (node != null){
            while (node.next != null && node.next.val == val){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }


}
