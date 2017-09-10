package io.github.zuston.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuston on 7/10/17.
 */
public class Lca {


}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static List<TreeNode> c1 = new ArrayList<TreeNode>();
    public static List<TreeNode> c2 = new ArrayList<TreeNode>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPath(root,p,c1);
        findPath(root,q,c2);
        System.out.println(c1);
        System.out.println(c2);
        TreeNode lca = null;
        Integer minSize = Math.min(c1.size(),c2.size());
        for (int i=0;i<minSize;i++){
            if (c1.get(i)==null || c2.get(i)==null || c2.get(i).val!=c1.get(i).val){
                return lca;
            }else{
                lca = c1.get(i);
            }
        }
        return null;
    }

    private static void findPath(TreeNode root,TreeNode p,List<TreeNode> c1){
        if (root.val == p.val){
            return;
        }

        c1.add(root);
        if (root.left!=null){
            c1.add(root.left);
            findPath(root.left,p,c1);
            c1.remove(c1.size()-1);
        }
        if (root.right!=null)   {
            c1.add(root.right);
            findPath(root.right,p,c1);
            c1.remove(c1.size()-1);
        }
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}