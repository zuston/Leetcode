package io.github.zuston.Tree;

/**
 * Created by zhang_jf on 2017/7/11.
 */
public class MaxPathSum {

}


class MSolution {
    public static Integer max = 0;
    public int maxPathSum(TreeNode root) {
        findPath(root,0);
        return max;
    }

    private static void findPath(TreeNode root, Integer current){
        if (root==null){
            if (current>max)
                max = current;
            return;
        }

        findPath(root.left,current+root.val);
        findPath(root.right,current+root.val);
    }
}