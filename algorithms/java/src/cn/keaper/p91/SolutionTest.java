package cn.keaper.p91;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();


    private List<String> cases = Arrays.asList(
            "0",
            "1",
            "2",
            "9",
            "10",
            "12",
            "00",
            "01",
            "03",
            "20",
            "30",
            "23",
            "26",
            "27",
            "34",
            "76",
            "99",
            "100",
            "101",
            "201",
            "202",
            "203",
            "302",
            "302",
            "320",
            "110",
            "120",
            "130",
            "226",
            "22034",
            "203420"
    );


    @Test
    public void numDecodings() {
        cases.forEach(c -> System.out.println(c + " -> " + solution.numDecodings(c) + " , " + solution.numDecodings1(c)));
    }
}