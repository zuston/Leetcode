package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by zuston on 16-12-12.
 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sum;
    public List<Integer> tempT;
    public List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        this.sum = sum;
        res = new ArrayList<List<Integer>>();
        tempT = new ArrayList<Integer>();
        path(root,0);

        return res;
    }


    public void path(TreeNode root,int num){

        if(root==null){
            return;
        }
        tempT.add(root.val);
        if (root.left==null&&root.right==null){
            if(num+root.val==this.sum){
                //神坑，如果是res.add(tempT)，则在删除temp时候，会出现很随机的事情，因为此处是一个引用
                res.add(new ArrayList<Integer>(tempT));
            }
            tempT.remove(tempT.size()-1);
            return;
        }

        path(root.left,num+root.val);
        path(root.right,num+root.val);
        tempT.remove(tempT.size()-1);
    }
}
