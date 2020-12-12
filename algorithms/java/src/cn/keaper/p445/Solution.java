package cn.keaper.p445;

import cn.keaper.utils.list.integer.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class Solution {


    /**
     * 因为数字是正序存放的，可以使用栈来翻转顺序，然后求和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            carry = sum / 10;
            ListNode newHead = new ListNode(sum % 10);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

}
