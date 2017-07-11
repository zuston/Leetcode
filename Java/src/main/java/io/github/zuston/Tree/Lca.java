package io.github.zuston.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_jf on 2017/7/11.
 */
public class Lca {

    public static void main(String[] args) {
        TreeNode tRoot = new TreeNode(20);
        TreeNode tLeft = new TreeNode(10);
        TreeNode tRight = new TreeNode(50);
        tRoot.left = tLeft;
        tRoot.right = tRight;
        tLeft.left = null;
        tLeft.right = null;

    }
}



class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}



class Soulution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> container_1 = new ArrayList<TreeNode>();
        List<TreeNode> container_2 = new ArrayList<TreeNode>();
        container_1.add(root);
        container_2.add(root);
        findPath(root,p,container_1);
        findPath(root,q,container_2);
        TreeNode lca = null;
        for (int i=0;i<container_1.size() && i<container_2.size();i++){
            if (container_1.get(i)==container_2.get(i))
                lca = container_1.get(i);
            else
                break;
        }
        return lca;
    }

    private static Boolean findPath(TreeNode root,TreeNode p,List<TreeNode> c1){
        if (root==p)
            return true;

        if (root.left!=null){
            c1.add(root.left);
            if (findPath(root.left,p,c1))   return true;
            c1.remove(c1.size()-1);
        }

        if (root.right!=null){
            c1.add(root.right);
            if (findPath(root.right,p,c1))  return true;
            c1.remove(c1.size()-1);
        }

        return false;
    }


    public static List<String> stringPath = new ArrayList<String>();

    private static void findPath2String(TreeNode root,String strPath){
        if (root.left==null && root.right==null)    stringPath.add(strPath);
        if (root.left!=null)
            findPath2String(root.left,strPath+"->"+root.left.val);

        if (root.right!=null)
            findPath2String(root.right,strPath+"->"+root.right.val);
    }
}


