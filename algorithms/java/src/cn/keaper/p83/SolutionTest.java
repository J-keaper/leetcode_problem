package cn.keaper.p83;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{},
            new int[]{1},
            new int[]{1,1},
            new int[]{1,1,2},
            new int[]{1,1,1},
            new int[]{1,1,2,3,3},
            new int[]{1,1,2,3,3,4,4,5,5,5,5,6}
    );


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

    @Test
    public void deleteDuplicates1() {
        cases.forEach(c -> {
            ListNode head = solution.deleteDuplicates1(ListBuilder.build(c));
            ListPrinter.print(head);
        });

    }
}