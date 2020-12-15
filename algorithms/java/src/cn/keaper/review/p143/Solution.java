package cn.keaper.review.p143;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

import java.util.stream.IntStream;

public class Solution {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode tail = reverseList(mid);
        ListNode node = head;
        while (node != null && tail != null){
            ListNode nodeNext = node.next, tailNext = tail.next;
            node.next = tail;
            tail.next = nodeNext;

            node = nodeNext;
            tail = tailNext;
        }
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

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            ListNode list = ListBuilder.build(IntStream.rangeClosed(1,i).toArray());
            new Solution().reorderList(list);
            ListPrinter.print(list);
        }

    }
}
