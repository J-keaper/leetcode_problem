package cn.keaper.p86;

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
            new int[]{1,4,3,2,5,2, 3},
            new int[]{1,4,3,2,5,2, 2},
            new int[]{1,4,3,2,5,2, 1},
            new int[]{1,4,3,2,5,2, 0},
            new int[]{1,4,3,2,5,2, 6},
            new int[]{1,2, 2},
            new int[]{2, 2}
    );

    @Test
    public void partition() {
        cases.forEach(c -> {
            ListNode head = solution.partition(
                    ListBuilder.build(Arrays.copyOf(c, c.length-1)), c[c.length-1]);
            ListPrinter.print(head);
        });

    }
}