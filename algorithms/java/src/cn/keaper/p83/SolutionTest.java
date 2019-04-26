package cn.keaper.p83;

import cn.keaper.utils.list.integer.ListNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void deleteDuplicates() {
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