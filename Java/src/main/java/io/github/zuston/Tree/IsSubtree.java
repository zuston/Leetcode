package io.github.zuston.Tree;

/**
 * Created by zhang_jf on 2017/7/11.
 */


public class IsSubtree {

}

class ISolution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null)    return false;
        if (isSame(s,t))    return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private boolean isSame(TreeNode s,TreeNode p){
        if (s==null && p==null)
            return true;
        if (s==null || p==null)
            return false;
        if (s.val != p.val)
            return false;

        return isSame(s.left,p.left) && isSame(s.right,p.right);
    }
}
