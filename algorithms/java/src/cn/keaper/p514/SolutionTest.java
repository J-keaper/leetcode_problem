package cn.keaper.p514;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"godding","gd"},
            new String[]{"godding","god"},
            new String[]{"godding","gdg"},
            new String[]{"godding","doing"},
            new String[]{"godding","dog"},
            new String[]{"caotmcaataijjxi","oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"}
    );
    @Test
    public void findRotateSteps() {
        cases.forEach(c -> {
            System.out.println(solution.findRotateSteps(c[0], c[1]));
            System.out.println(solution.findRotateSteps1(c[0], c[1]));
            System.out.println(solution.findRotateSteps2(c[0], c[1]));
            System.out.println();

        });
    }
}