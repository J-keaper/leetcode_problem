package cn.keaper.p236;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();


    @Test
    public void lowestCommonAncestor() {
        TreeNode root = TreeBuilder.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        System.out.println(solution.lowestCommonAncestor1(root, p, q).val);

        p = root.left;
        q = root.left.right.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        System.out.println(solution.lowestCommonAncestor1(root, p, q).val);


        p = root.left.left;
        q = root.left.right.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        System.out.println(solution.lowestCommonAncestor1(root, p, q).val);

        p = root.left.right.right;
        q = root.left;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        System.out.println(solution.lowestCommonAncestor1(root, p, q).val);


        p = root.left.left;
        q = root.left.right.left;
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        System.out.println(solution.lowestCommonAncestor1(root, p, q).val);


    }



}