package cn.keaper.p234;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Solution {

    /**
     * 1. find middle position & reverse the first half
     * 2. compare the first half and the second half
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast = head,slow = head;
        ListNode prev = null,curr = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode newHead = fast == null ? slow : slow.next;
        while (prev != null){
            if(newHead.val != prev.val){
                return false;
            }
            newHead = newHead.next;
            prev = prev.next;
        }
        return true;
    }

    /**
     * 1. find middle position
     * 2. reverse the latter half
     * 3. compare the first half and the second half
     */
    public boolean isPalindrome1(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow locate middle position
        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode tail = prev;
        while (head != null && tail != null){
            if(head.val != tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}
