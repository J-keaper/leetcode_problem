package cn.keaper.p148;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 */
public class Solution {

    /**
     * 使用归并排序，首先找到中间节点，然后将链表断开，分别对两段链表排序
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode head2 = middle.next;
        middle.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(head2);
        return mergeTwoLists(list1, list2);
    }

    private ListNode findMiddle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head.next,slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
