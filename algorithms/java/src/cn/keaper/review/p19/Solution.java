package cn.keaper.review.p19;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode front = dummy, back = dummy;
        int step = -1;
        while (front != null){
            front = front.next;
            step++;
            if(step > n){
                back = back.next;
            }
        }
        back.next = back.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListPrinter.print(new Solution().removeNthFromEnd(ListBuilder.build(1,2,3,4,5),1));
        ListPrinter.print(new Solution().removeNthFromEnd(ListBuilder.build(1,2,3,4,5),2));
        ListPrinter.print(new Solution().removeNthFromEnd(ListBuilder.build(1,2,3,4,5),3));
        ListPrinter.print(new Solution().removeNthFromEnd(ListBuilder.build(1,2,3,4,5),4));
        ListPrinter.print(new Solution().removeNthFromEnd(ListBuilder.build(1,2,3,4,5),5));
    }
}
