package cn.keaper.p649;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "R",
            "D",
            "RD",
            "RDD",
            "DRD",
            "RDDRRDRDDR",
            "RDRRDDRRDDDR",
            "RDRRDDRRDRDRDDR",
            "DDRRRDDRDDR",
            "DRRDDDRDD"
    );

    @Test
    public void predictPartyVictory() {
        cases.forEach(c -> {
            System.out.println(solution.predictPartyVictory(c));
            System.out.println(solution.predictPartyVictory1(c));
            System.out.println();

        });
    }
}