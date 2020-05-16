package cn.keaper.p61;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();
    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,4,5},
            new int[]{},
            new int[]{1},
            new int[]{1,2},
            new int[]{1,2,3},
            new int[]{1,2,3,4}
    );


    @Test
    public void rotateRight() {
        cases.forEach(c -> {
            for (int i = 0; i <= c.length * 2; i++) {
                ListNode head = solution.rotateRight(ListBuilder.build(c), i);
                ListPrinter.print(head);
            }
            System.out.println("==========");
        });
    }
}