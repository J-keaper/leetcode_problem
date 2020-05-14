package cn.keaper.p60;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class Solution {

    private static int[] f = new int[10];

    static {
        f[1] = 1;
        for (int i = 2; i < 10; i++) {
            f[i] = f[i - 1] * i;
        }
    }

    /**
     * 康托编码(康托展开的逆运算)
     * https://zh.wikipedia.org/wiki/%E5%BA%B7%E6%89%98%E5%B1%95%E5%BC%80
     *
     */
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        k--;

        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        for (int i = n - 1; k > 0; i--) {
            int t = k / f[i];
            k = k % f[i];
            str.append(nums.get(t));
            nums.remove(t);
        }
        nums.forEach(str::append);
        return str.toString();
    }


    /**
     * 扩展：
     * https://zh.wikipedia.org/wiki/%E5%BA%B7%E6%89%98%E5%B1%95%E5%BC%80
     *
     * 康托展开,上述运算的逆运算
     *
     * @param n 0 < n <= 9
     * @param s [1,2,3,4,...,n]组成的全排列中的某一个
     * @return k 当前排列在全部排按照字典序排列中的顺序
     */
    public int getPermutationSerial(int n, String s){
        int x = 0;
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - '0';
            for (int j = 0; nums.get(j) < k; j++) {
                x += f[s.length() - i - 1];
            }
            nums.remove(Integer.valueOf(k));
        }

        return x + 1;
    }


}
