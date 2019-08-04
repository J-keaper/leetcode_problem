package cn.keaper.p204;

import java.util.BitSet;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class Solution {

    /**
     * Sieve of Eratosthenes：https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */



    public int countPrimes(int n){
        if(n <= 2){
            return 0;
        }
        int count = n;
        boolean[] notPrime = new boolean[n];
        for(int i = 2 , sqr = 4 ; sqr < n ; i ++ , sqr = i * i){
            if(notPrime[i]){
                continue;
            }
            for(int j = sqr ; j < n ; j += i){
                if(!notPrime[j]){
                    count --;
                    notPrime[j] = true;
                }
            }
        }
        return count - 2;
    }


    public int countPrimes3(int n){
        boolean[] notPrime = new boolean[n];
        for(int i = 2 ; i * i <= n ; i ++){
            if(notPrime[i]){
                continue;
            }
            for(int j = i * i ; j < n ; j += i){
                notPrime[j] = true;
            }
        }
        int count = 0;
        for(int i = 2 ; i < n ; i ++){
            if(!notPrime[i]){
                count ++;
            }
        }
        return count;
    }



    public int countPrimes2(int n){
        BitSet notPrime = new BitSet();
        for(int i = 2 ; i * i <= n ; i ++){
            if(notPrime.get(i)){
                continue;
            }
            for(int j = i * i ; j < n ; j += i){
                notPrime.set(j);
            }
        }
        int count = 0;
        for(int i = 2 ; i < n ; i ++){
            if(!notPrime.get(i)){
                count ++;
            }
        }
        return count;
    }


    public int countPrimes1(int n) {
        int count = 0;
        BitSet notPrime = new BitSet();
        for(int i = 2 ; i < n ; i ++){
            if(notPrime.get(i)){
                continue;
            }
            count ++;
            for(int j = i ; i <= n / j; j += 1){
                notPrime.set(i * j);
            }
        }
        return count;
    }
}
