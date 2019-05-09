package cn.keaper.p141;

import cn.keaper.utils.list.integer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class Solution {

    /**
     * Time complexity : O(n)
     * Space complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true){
            if(fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
    }

    /**
     * Time complexity : O(n)
     * Space complexity: O(n)
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> listNodes = new HashSet<>();
        while (head != null){
            if (listNodes.contains(head)){
                return true;
            }
            listNodes.add(head);
            head = head.next;
        }
        return false;
    }
}
