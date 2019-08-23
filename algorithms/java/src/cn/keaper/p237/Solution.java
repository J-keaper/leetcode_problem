package cn.keaper.p237;

import cn.keaper.utils.list.integer.ListNode;

public class Solution {

    public void deleteNode(ListNode node) {
        if(node == null || node.next == null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
