package cn.keaper.p82;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution {

    /**
     * 与 P83[https://leetcode.com/problems/remove-duplicates-from-sorted-list/] 思路大致一样
     * 维护prev,cur 两个指针, prev用来生成最后的结果
     * 遍历每个元素是跳过全部重复的元素指向下一个与当前元素不同的元素再次判断有无重复
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;

        ListNode prev = dummy, cur = head;
        while (cur != null){
            boolean dup = false;
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                dup = true;
            }
            if(dup){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
