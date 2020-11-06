package cn.keaper.p1356;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class Solution {


    public int[] sortByBits2(int[] arr) {
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = (Integer.bitCount(arr[i]) << 15) + arr[i];
        }
        Arrays.sort(boxedArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i] & ((1 << 15) - 1);
        }
        return arr;
    }

    /**
     * 自己实现 拆箱 装箱
     */
    public int[] sortByBits1(int[] arr) {
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }
        Arrays.sort(boxedArr, this::compare);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }
        return arr;
    }

    /**
     * Stream 拆箱 排序 装箱
     */
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(this::compare).mapToInt(Integer::intValue).toArray();
    }

    int compare(int i1, int i2){
        int bitCount1 = Integer.bitCount(i1), bitCount2 = Integer.bitCount(i2);
        if (bitCount1 == bitCount2) {
            return Integer.compare(i1, i2);
        }
        return Integer.compare(bitCount1, bitCount2);
    }


}
