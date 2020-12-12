package cn.keaper.review.p2;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListPrinter.print(new Solution().addTwoNumbers(ListBuilder.build(2,4,3), ListBuilder.build(5,6,4)));
        ListPrinter.print(new Solution().addTwoNumbers(ListBuilder.build(2), ListBuilder.build(5,6,4)));
        ListPrinter.print(new Solution().addTwoNumbers(ListBuilder.build(2,4,3), ListBuilder.build(5)));
        ListPrinter.print(new Solution().addTwoNumbers(ListBuilder.build(9,9,9), ListBuilder.build(5)));
    }
}
