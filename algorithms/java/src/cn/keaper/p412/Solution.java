package cn.keaper.p412;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/fizz-buzz/
 */
public class Solution {


    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                res.add("FizzBuzz");
            }else if (i % 3 == 0){
                res.add("Fizz");
            }else if (i % 5 == 0){
                res.add("Buzz");
            }else{
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}
