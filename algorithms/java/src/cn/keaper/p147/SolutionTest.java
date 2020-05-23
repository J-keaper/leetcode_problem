package cn.keaper.p147;

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
            new int[]{4,2,1,3},
            new int[]{3,4,5,2,2,3,2,1,6,8,5,4}
    );

    @Test
    public void insertionSortList() {
        cases.forEach(c -> {
            ListNode head = ListBuilder.build(c);
            ListPrinter.print(solution.insertionSortList(head));
        });

    }
}