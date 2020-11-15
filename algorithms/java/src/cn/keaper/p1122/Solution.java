package cn.keaper.p1122;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/relative-sort-array/
 */
public class Solution {


    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int[] res = new int[arr1.length];
        int j = 0;

        for (int i : arr1) {
            count[i]++;
        }

        for (int i : arr2) {
            while (count[i]-- > 0){
                res[j++] = i;
            }
        }

        for (int i = 0; i <= 1000; i++) {
            while (count[i]-- > 0){
                res[j++] = i;
            }
        }

        return res;
    }




    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] sort = new int[1001];
        for (int i = 0; i < arr2.length; i++) {
            sort[arr2[i]] = i + 1;
        }
        for (int value : arr1) {
            if (sort[value] == 0) {
                sort[value] = 1001 + value;
            }
        }
        return Arrays.stream(arr1).boxed().sorted(Comparator.comparingInt(i -> sort[i])).mapToInt(Integer::intValue).toArray();
    }



    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> sort = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            sort.put(arr2[i], i);
        }
        return Arrays.stream(arr1).boxed().sorted((i1,i2) -> this.compare(sort, i1,i2)).mapToInt(Integer::intValue).toArray();
    }

    int compare(Map<Integer, Integer> sort, Integer i1, Integer i2){
        Integer order1 = sort.get(i1), order2 = sort.get(i2);
        if(order1 != null && order2 != null){
            return Integer.compare(order1, order2);
        }
        if(order1 == null && order2 == null){
            return Integer.compare(i1,i2);
        }
        return order1 == null ? 1 : -1;
    }

}
