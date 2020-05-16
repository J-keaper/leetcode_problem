package cn.keaper.p328;

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
            new int[]{},
            new int[]{1},
            new int[]{1,2},
            new int[]{1,2,3},
            new int[]{1,2,3,4,5,6},
            new int[]{1,2,3,4,5,6,7}
    );

    @Test
    public void oddEvenList() {
        cases.forEach(c -> {
            ListNode head = solution.oddEvenList(ListBuilder.build(c));
            ListPrinter.print(head);
        });
    }
}