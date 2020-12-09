package cn.keaper.p860;

/**
 * https://leetcode.com/problems/lemonade-change/
 */
public class Solution {

    /**
     * 因为20不能用来找零，10和5是可以的，所以我们记录10和5的数量
     * 如果给的是5，不需要找零，计数加一
     * 如果给的是10，需要找零，且只能找一张5
     * 如果给的是20，需要找零，有两种方式，10+5 或者 5+5+5，因为5可以用在20和10的找零上，而10只能用在20的找零上，所以我们优先使用10+5
     */
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int bill : bills) {
            if(bill == 5){
                count5++;
            }else if(bill == 10){
                if(count5 >= 1){
                    count5--;
                    count10++;
                }else{
                    return false;
                }
            }else{
                if(count5 >= 1 && count10 >= 1){
                    count5--;
                    count10--;
                }else if(count5 >= 3){
                    count5 -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
