package cn.keaper.p303;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumArrayTest {

    @Test
    public void sumRange() {
        NumArray numArray = new NumArray(new int[]{1,2,3,4,5,6,7});
        System.out.println(numArray.sumRange(0,0));
        System.out.println(numArray.sumRange(0,1));
        System.out.println(numArray.sumRange(0,3));
        System.out.println(numArray.sumRange(3,3));
        System.out.println(numArray.sumRange(3,6));
        System.out.println(numArray.sumRange(6,6));

        numArray = new NumArray(new int[]{1});
        System.out.println(numArray.sumRange(0,0));
    }
}