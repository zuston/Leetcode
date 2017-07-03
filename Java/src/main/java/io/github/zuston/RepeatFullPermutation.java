package io.github.zuston;

/**
 * Created by zuston on 17-7-3.
 */

import java.util.HashMap;

/**
 * 有重复数　的全排列算法
 * 设 arr 数组总长度为 i
 * 全排列的过程是 begin到i-1　的数与 begin 的交换，那么重复的数，即存在于　begin到ｉ-1 之中，剔除即可
 */
public class RepeatFullPermutation {
    public static void main(String[] args) {
        int arr [] = {1,2,2};
        loop(arr,0);
    }


    public static void loop(int [] arr,int start){
        if (start==arr.length){
            aprint(arr);
        }
        HashMap<Integer,Integer> tempTag = new HashMap<Integer, Integer>();
        for (int i=start;i<arr.length;i++){
            // 判别是否有重复数字
            if (!tempTag.containsKey(arr[i])){
                tempTag.put(arr[i],i);

                // 两次 change 即为回溯
                change(arr,start,i);
                loop(arr,i+1);
                change(arr,start,i);
            }
        }
    }

    private static void aprint(int[] arr) {
        for (int a : arr){
            System.out.print(a);
        }
        System.out.println();
    }

    private static void change(int[] arr, int start, int i) {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }
}
