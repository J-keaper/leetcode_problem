package cn.keaper.p92;

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
            new int[]{1,2,3,4,5, 2,2},
            new int[]{1,2,3,4,5, 2,3},
            new int[]{1,2,3,4,5, 2,4},
            new int[]{1,2,3,4,5, 1,5},
            new int[]{1,2,3, 1,2},
            new int[]{1,2,3, 2,3},
            new int[]{1,2, 1,1},
            new int[]{1,2, 2,2},
            new int[]{1,2, 1,2},
            new int[]{1, 1,1}
    );


    @Test
    public void reverseBetween() {
        cases.forEach(c -> {
            ListNode head = solution.reverseBetween(
                    ListBuilder.build(Arrays.copyOf(c, c.length - 2)),
                    c[c.length - 2], c[c.length - 1]);
            ListPrinter.print(head);
        });
    }
}