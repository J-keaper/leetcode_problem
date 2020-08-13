package cn.keaper.p127;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"hit", "cog", "hot","dot","dog","lot","log","cog"},
            new String[]{"hit", "cog", "hot","dot","dog","lot","cog","hig","hog"},
            new String[]{"hit", "cog", "hot","dot","dog","lot","log"},
            new String[]{"hit", "cog", "hit","cog"}
            );
    @Test
    public void ladderLength() {
        cases.forEach(c -> {
            List<String> wordList = Arrays.asList(Arrays.copyOfRange(c, 2, c.length));
            System.out.println(solution.ladderLength(c[0], c[1], wordList));
        });

    }

    @Test
    public void ladderLength1() {
        cases.forEach(c -> {
            List<String> wordList = Arrays.asList(Arrays.copyOfRange(c, 2, c.length));
            System.out.println(solution.ladderLength1(c[0], c[1], wordList));
        });

    }
}