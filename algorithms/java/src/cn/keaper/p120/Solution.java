package cn.keaper.p120;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int sum;
                if(j - 1 >= 0 && j < triangle.get(i-1).size()){
                    sum = Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j));
                }else{
                    sum = j - 1 < 0 ? triangle.get(i-1).get(j) : triangle.get(i-1).get(j-1);
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + sum);
            }
        }
        int res = Integer.MAX_VALUE;
        List<Integer> last = triangle.get(triangle.size() - 1);
        for (int i = 0; i < last.size(); i++) {
            res = Math.min(res, last.get(i));
        }
        return res;
    }
}
