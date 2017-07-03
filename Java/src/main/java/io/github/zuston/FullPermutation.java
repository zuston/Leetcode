package io.github.zuston;

/**
 * Created by zuston on 17-7-3.
 */


/**
 * 全排列　等算法，包括全排列，递归，回溯，动规
 */
public class FullPermutation {

    public static void main(String[] args) {
        int arr [] = {1,2,4,8,5};
        loop(arr,0);
    }


    public static void loop(int [] arr,int start){
        if (start==arr.length){
            aprint(arr);
        }
        for (int i=start;i<arr.length;i++){
            // 两次 change 即为回溯
            change(arr,start,i);
            loop(arr,i+1);
            change(arr,start,i);
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
