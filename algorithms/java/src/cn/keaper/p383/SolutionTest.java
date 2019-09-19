package cn.keaper.p383;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private List<Case> cases = Arrays.asList(
            new Case("a","b"),
            new Case("aa","ab"),
            new Case("aa","aab")
    );

    private Solution solution = new Solution();

    @Test
    public void canConstruct() {
        cases.forEach(c -> System.out.println(solution.canConstruct(c.ransomNote,c.magazine)));
    }

    private class Case {
        String ransomNote;
        String magazine;

        Case(String ransomNote, String magazine) {
            this.ransomNote = ransomNote;
            this.magazine = magazine;
        }
    }

}