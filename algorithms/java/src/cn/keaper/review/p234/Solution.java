package cn.keaper.review.p234;

import cn.keaper.utils.list.integer.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public boolean isPalindrome(ListNode head) {

        Deque<Integer> stack = new LinkedList<>();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow.val);
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        while (slow != null && slow.val == stack.pop()){
            slow = slow.next;
        }
        return slow == null;
    }


}
