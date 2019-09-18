package cn.keaper.p374;

public class Solution extends GuessGame{

    public int guessNumber(int n) {
        int l = 1,r = n;
        while (l <= n){
            int m = l + (r - l) / 2;
            int guess = guess(m);
            if(guess == 0){
                return m;
            }
            if(guess < 0){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return -1;
    }
}


class GuessGame {

    private int target;

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    int guess(int num){
        if(target == num){
            return 0;
        }
        return target > num ? 1 : -1;
    }

}