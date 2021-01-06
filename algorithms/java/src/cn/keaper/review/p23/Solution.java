package cn.keaper.review.p23;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if(l > r){
            return null;
        }
        if(l == r){
            return lists[l];
        }
        int m = (l + r) >>> 1;
        ListNode left = mergeKLists(lists, l, m);
        ListNode right = mergeKLists(lists, m + 1, r);
        return mergeTwoLists(left, right);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
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
        ListNode[] lists = new ListNode[]{
                ListBuilder.build(1,4,5),
                ListBuilder.build(1,3,4),
                ListBuilder.build(2,6)
        };
        ListPrinter.print(new Solution().mergeKLists(lists));

        lists = new ListNode[]{};
        ListPrinter.print(new Solution().mergeKLists(lists));

        lists = new ListNode[]{ListBuilder.build()};
        ListPrinter.print(new Solution().mergeKLists(lists));




    }
}
