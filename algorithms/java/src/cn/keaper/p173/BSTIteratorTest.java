package cn.keaper.p173;

import cn.keaper.utils.tree.integer.TreeBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BSTIteratorTest {

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{7,3,15,null,null,9,20},
            new Integer[]{7,3,15,null,null,9,20}
    );
    
    @Test
    public void test() {
        cases.forEach(c -> {
            BSTIterator iterator = new BSTIterator(TreeBuilder.buildTree(c));
            System.out.println(iterator.next());    // return 3
            System.out.println(iterator.next());    // return 7
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next());    // return 9
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next());    // return 15
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next());    // return 20
            System.out.println(iterator.hasNext()); // return false

        });

    }
    @Test
    public void test2() {
        cases.forEach(c -> {
            BSTIterator1 iterator = new BSTIterator1(TreeBuilder.buildTree(c));
            System.out.println(iterator.next());    // return 3
            System.out.println(iterator.next());    // return 7
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next());    // return 9
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next());    // return 15
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next());    // return 20
            System.out.println(iterator.hasNext()); // return false

        });

    }

}