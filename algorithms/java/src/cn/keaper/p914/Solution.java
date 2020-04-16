package cn.keaper.p914;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class Solution {

    /**
     * 相同的数需要被放到一组，也可以等分成几组
     * 假设不重复的数有k个，数量分别是 count[i](0 <= i < k)
     * 如果所有的count[i]的最大公约数不是1，那么一定可以分成至少为2的N组
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int i : deck) {
            count[i] ++;
        }
        int len = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0){
                count[len++] = count[i];
            }
        }
        int gcd = count[0];
        for (int i = 0; i < len; i++) {
            gcd = gcd(gcd, count[i]);
        }
        return gcd >= 2;
    }


    /**
     * 相同思路，耗时较长，可能是维护HashMap的开销
     */
    public boolean hasGroupsSizeX1(int[] deck) {
        if(deck.length < 2){
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : deck) {
            if(!count.containsKey(i)){
                count.put(i, 0);
            }
            count.put(i, count.get(i) + 1);
        }
        List<Integer> countSet = new ArrayList<>(count.values());
        int gcd = countSet.get(0);
        for (int i = 1; i < count.values().size(); i++) {
            gcd = gcd(gcd, countSet.get(i));
            if(gcd == 1){
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

}
