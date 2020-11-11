package cn.keaper.p972;

/**
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 */
public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        while (i < A.length && j < A.length){
            while (i < A.length && (A[i] & 1) == 0){
                i += 2;
            }
            while (j < A.length && (A[j] & 1) == 1){
                j += 2;
            }
            if(i < A.length && j < A.length){
                swap(A, i ,j);
            }
        }
        return A;
    }

    void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
