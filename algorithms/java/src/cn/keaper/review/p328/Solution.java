package cn.keaper.review.p328;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode oldDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        ListNode old = oldDummy, even = evenDummy;

        boolean isOld = true;
        while (head != null){
            if(isOld){
                old.next = head;
                old = old.next;
            }else{
                even.next = head;
                even = even.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
            isOld = !isOld;
        }
        old.next = evenDummy.next;
        return oldDummy.next;
    }




    public static void main(String[] args) {
        ListPrinter.print(new Solution().oddEvenList(ListBuilder.build()));
        ListPrinter.print(new Solution().oddEvenList(ListBuilder.build(1)));
        ListPrinter.print(new Solution().oddEvenList(ListBuilder.build(1,2)));
        ListPrinter.print(new Solution().oddEvenList(ListBuilder.build(1,2,3,4,5,6)));
        ListPrinter.print(new Solution().oddEvenList(ListBuilder.build(1,2,3,4,5)));
    }
}
