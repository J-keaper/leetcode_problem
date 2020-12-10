package cn.keaper.review.p60;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static int[] f = new int[10];

    static {
        f[1] = 1;
        for (int i = 2; i < 10; i++) {
            f[i] = f[i - 1] * i;
        }
    }

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        StringBuilder res = new StringBuilder();
        k--;
        for (int i = n - 1; k > 0; i--) {
            int d = k / f[i];
            k = k % f[i];
            res.append(list.get(d));
            list.remove(d);
        }
        list.forEach(res::append);
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4,9));
    }
}