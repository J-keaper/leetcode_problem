package cn.keaper.p297;


import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CodecTest {

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{1,2,3,null,null,4,5},
            new Integer[]{}
    );

    @Test
    public void test(){
        cases.forEach(c -> {
            TreeNode tree = TreeBuilder.buildTree(c);
            String se = new Codec().serialize(tree);
            System.out.println(se);
            TreeNode de = new Codec().deserialize(se);

        });
    }

}