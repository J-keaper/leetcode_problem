package cn.keaper.p299;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class Solution {

    /**
     * Bulls Solution: Traverses sequentially each character of the two strings,compare character on the same location.If yes,{bulls} add 1.
     *
     * Cows Solution: Statistics the count of {0,9} in two strings.
     *          count(i) = min(count_secret(i),count_guess(i))
     *          cows = sum(count(i))   i = 0,1,2,3...,9
     *
     */
    public String getHint(String secret, String guess) {
        int bull = 0, cows = 0;
        int[] secretCount = new int[10], guessCount = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            secretCount[secret.charAt(i) - '0']++;
        }
        for (int i = 0; i < guess.length(); i++) {
            guessCount[guess.charAt(i) - '0'] ++;
            if(guess.charAt(i) == secret.charAt(i)){
                bull ++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Integer.min(secretCount[i],guessCount[i]);
        }
        cows -= bull;
        return bull + "A" + cows + "B";
    }

}
