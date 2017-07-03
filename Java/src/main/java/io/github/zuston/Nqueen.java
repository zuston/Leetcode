package io.github.zuston;

import java.util.ArrayList;

/**
 * Created by zuston on 17-7-3.
 */

/**
 * n 皇后问题依然是一个递归中带有回溯的问题
 */
public class Nqueen {
    private static ArrayList<Integer> container = new ArrayList<Integer>();
    private static Integer count = 0;
    public static void main(String[] args) {
        queen(4,0);
        System.out.println(count);
    }


    public static void queen(int n,int tag){
        if (tag == n){
            System.out.println(container);
            count ++ ;
            return;
        }

        for (int i=0;i<n;i++){
            if (isOK(i)){
                container.add(i);
                queen(n,tag+1);
                container.remove(container.size()-1);
            }
        }
    }

    private static boolean isOK(int i) {
        for (int j=0;j<container.size();j++){
            if (Math.abs(container.size()-j) == Math.abs(container.get(j)-i) || container.get(j) == i)  return false;
        }
        return true;
    }
}
