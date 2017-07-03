package io.github.zuston;

/**
 * Created by zuston on 17-7-3.
 */

import java.util.ArrayList;

/**
 * 全组合　算法
 */
public class FullComponent {
    private static ArrayList<Integer> container = new ArrayList<Integer>();
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        loop(arr,0);
    }


    public static void loop(int [] arr, int position){
        if (position == arr.length){
            System.out.println(container);
            return;
        }

        loop(arr,position+1);
        container.add(arr[position]);
        loop(arr,position+1);
        container.remove(container.size()-1);
    }


    // 如果 arr 中有重复数字，则　。。。。　？
}
