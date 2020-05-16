package cn.keaper.p82;

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
            new int[]{1,2,3,3,4,4,5},
            new int[]{1,1,1,2,2,2,3},
            new int[]{1,2,3,4,5},
            new int[]{1,2,3,3,3,4,5},
            new int[]{},
            new int[]{1},
            new int[]{1,2},
            new int[]{1,2,3},
            new int[]{1,1,1},
            new int[]{1,1,1,2,3},
            new int[]{2,3,3,3},
            new int[]{1,1,1,2,3,3,3}
    );

    @Test
    public void deleteDuplicates() {
        cases.forEach(c -> {
            ListNode head = solution.deleteDuplicates(ListBuilder.build(c));
            ListPrinter.print(head);
        });
    }
}