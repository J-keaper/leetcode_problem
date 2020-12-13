package cn.keaper.review.p25;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode lastTail = dummy, nextTail = head;
        while (nextTail != null){
            ListNode node = nextTail;
            int len = 1;
            while (node != null && len < k){
                node = node.next;
                len++;
            }
            if(node == null){
                break;
            }

            int step = 1;
            ListNode p = nextTail, c = nextTail.next;
            while (c != null && step < k){
                ListNode next= c.next;
                c.next = p;
                p = c;
                c = next;
                step++;
            }

            lastTail.next = p;
            nextTail.next = c;

            lastTail = nextTail;
            nextTail = c;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListPrinter.print(new Solution().reverseKGroup(ListBuilder.build(1,2,3,4,5,6,7,8), 3));
        ListPrinter.print(new Solution().reverseKGroup(ListBuilder.build(1,2,3,4,5,6,7,8,9), 3));
        ListPrinter.print(new Solution().reverseKGroup(ListBuilder.build(1,2,3,4,5,6,7,8), 2));
        ListPrinter.print(new Solution().reverseKGroup(ListBuilder.build(1,2,3,4,5,6,7,8,9), 2));
    }
}
