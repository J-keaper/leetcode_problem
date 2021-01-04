package cn.keaper.p605;

/**
 * https://leetcode.com/problems/can-place-flowers/
 */
public class Solution {

    /**
     * 一次跳两格，如果当前格为1，直接跳两步
     * 如果当前格为0且 下一个格子为0或者到了末尾 则可以种一朵花
     * 否则的花这个空格子只能浪费了，从下一个格子重新开始
     *
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i+=2) {
            if(flowerbed[i] == 0){
                if(i == flowerbed.length - 1 || flowerbed[i + 1] == 0){
                    n--;
                }else {
                    i++;
                }
            }
        }
        return n <= 0;
    }
}
