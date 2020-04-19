package cn.keaper.p1418;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<String[]> cases = Arrays.asList(
            new String[]{"David","3","Ceviche","Corina","10","Beef Burrito","David","3","Fried Chicken","Carla","5","Water","Carla","5","Ceviche","Rous","3","Ceviche"},
            new String[]{"James","12","Fried Chicken","Ratesh","12","Fried Chicken","Amadeus","12","Fried Chicken","Adam","1","Canadian Waffles","Brianna","1","Canadian Waffles"},
            new String[]{"Laura","2","Bean Burrito","Jhon","2","Beef Burrito","Melissa","2","Soda"}
    );

    @Test
    public void displayTable() {
        cases.forEach(c -> {
            List<List<String>> param = new ArrayList<>();
            for (int i = 0; i < c.length; i+=3) {
                param.add(Arrays.asList(c[i], c[i + 1], c[i + 2]));
            }
            System.out.println(solution.displayTable(param));
        });
    }

}