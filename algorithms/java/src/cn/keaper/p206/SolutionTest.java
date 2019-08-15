package cn.keaper.p206;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
            new int[]{1},
            new int[]{1,2},
            new int[]{1,2,3},
            new int[]{1,2,3,4},
            new int[]{1,2,3,4,5}
    );

    private Solution solution = new Solution();

    @Test
    public void reverseList() {
        cases.forEach(c -> ListPrinter.print(solution.reverseList(ListBuilder.build(c))));
    }
}