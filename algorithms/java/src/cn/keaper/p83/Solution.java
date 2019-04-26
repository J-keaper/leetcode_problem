package cn.keaper.p83;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node =  node.next;
            }
        }
        return head;
    }

}
