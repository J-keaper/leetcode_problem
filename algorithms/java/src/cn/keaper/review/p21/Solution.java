package cn.keaper.review.p21;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        ListNode node1 = l1, node2 = l2;
        while (node1 != null && node2 != null){
            if(node1.val < node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else{
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null){
            cur.next = node1;
        }
        if (node2 != null){
            cur.next = node2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListPrinter.print(new Solution().mergeTwoLists(ListBuilder.build(1,3,4,6), ListBuilder.build(2,6,7)));
    }
}
