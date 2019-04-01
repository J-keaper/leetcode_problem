package cn.keaper.p83;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node =  node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] list = new int[]{1,1,2,2,3,4,4,4,5,5,5,6,7,7};
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int i = 0; i < list.length ; i++){
            node.next = new ListNode(list[i]);
            node = node.next;
        }

        ListNode result = solution.deleteDuplicates(head.next);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }


}
