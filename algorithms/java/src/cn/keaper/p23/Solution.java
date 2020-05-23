package cn.keaper.p23;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Solution {

    /**
     * 两个链表合并使用归并排序的思想
     * 多个链表也可以使用归并的思想，将链表组分成两个区间，分别合并两个区间，最后将结果合并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if(l > r){
            return null;
        }
        if(l == r){
            return lists[l];
        }
        int m = (l+r) >>> 1;
        ListNode left = mergeKLists(lists, l, m);
        ListNode right = mergeKLists(lists, m + 1, r);
        return mergeTwoLists(left, right);
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null){
            current.next = l1;
        }
        if(l2 != null){
            current.next = l2;
        }
        return head.next;
    }


}
