package wap;

import java.util.Scanner;

/**
 * Created by zuston on 9/24/17.
 */
public class One {
    static int n = 0;
    static int m = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
         m = scanner.nextInt();
        int arr [][] = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                arr[i][j] = 0;
            }
        }
        int count = 0;
        for (int i=0;i<n;i++){
            String line = scanner.next();
            char [] arrrr = line.toCharArray();
            for (int k=0;k<arrrr.length;k++){
                if (arrrr[k]=='o'){
                    arr[i][k]=1;
                    count+=1;
                }
            }
        }
        int needNumber = scanner.nextInt();
        int needLeftNumber = count - needNumber;

        int number = loop(arr,needLeftNumber);
        System.out.println(number==Integer.MAX_VALUE?-1:number);

        // 需要移的数量
//        for (int i=needLeftNumber;i>=1;i--){
//            int leftNumber = findLeft(arr);
//            int rightNumber = findRight(arr);
//            int upNumber = findUp(arr);
//            int bottomNumber = findBottom(arr);
//            if (leftNumber == i){
//                stepNumber = loop()
//            }
//
//        }

    }

    private static int loop(int[][] arr, int needLeftNumber) {
        if (needLeftNumber<=0){
            return 0;
        }
        int leftNumber = findLeft(arr);
        int rightNumber = findRight(arr);
        int upNumber = findUp(arr);
        int bottomNumber = findBottom(arr);

        int left1 = Integer.MAX_VALUE;
        int right1 = Integer.MAX_VALUE;
        int up1 = Integer.MAX_VALUE;
        int down1 = Integer.MAX_VALUE;
        if (leftNumber<=needLeftNumber){
            // 向左移动
            int temp[][] = new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (j>0 && arr[i][j]==1){
                        temp[i][j-1] = 1;
                    }
                }
            }
            // 循环
            left1 = 1 + loop(temp,needLeftNumber-leftNumber);
        }

        if (rightNumber<=needLeftNumber){
            // 向右边移动
            int te[][] = new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (arr[i][j]==1 && j!=m-1){
                        te[i][j+1] = 1;
                    }
                }
            }
            // 循环
            right1 = 1 + loop(te,needLeftNumber-leftNumber);
        }

        if (upNumber<=needLeftNumber){
            // 向右边移动
            int te[][] = new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (arr[i][j]==1 && i!=0){
                        te[i-1][j] = 1;
                    }
                }
            }
            // 循环
            up1 = 1 + loop(te,needLeftNumber-leftNumber);
        }

        if (bottomNumber<=needLeftNumber){
            // 向右边移动
            int te[][] = new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (arr[i][j]==1 && i!=n-1){
                        te[i+1][j] = 1;
                    }
                }
            }
            // 循环
            down1 = 1 + loop(te,needLeftNumber-leftNumber);
        }
        return Math.min(Math.min(left1,right1),Math.min(up1,down1));
    }


    private static int findBottom(int[][] arr) {
        int number = 0;
        for (int i=0;i<m;i++){
            if (arr[n-1][i]==1){
                number += 1;
            }
        }
        return number;
    }

    private static int findUp(int[][] arr) {
        int number = 0;
        for (int i=0;i<m;i++){
            if (arr[0][i]==1)
                number += 1;
        }
        return number;
    }

    private static int findRight(int[][] arr) {
        int number = 0;
        for (int i=0;i<n;i++){
            if (arr[i][m-1]==1){
                number += 1;
            }
        }
        return number;
    }

    private static int findLeft(int[][] arr) {
        int number = 0;
        for (int i=0;i<n;i++){
            if (arr[i][0]==1)
                number+=1;
        }
        return number;
    }
}
