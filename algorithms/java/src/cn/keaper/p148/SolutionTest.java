package cn.keaper.p148;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,3,1,4,9,7,5,8},
            new int[]{2,3,1,8,3,2,4,4,9,7,5,8}
    );

    @Test
    public void sortList() {
        cases.forEach(c -> ListPrinter.print(solution.sortList(ListBuilder.build(c))));
    }
}