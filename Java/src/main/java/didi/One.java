package didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zuston on 9/23/17.
 */
public class One {
    public static void main(String[] args) {
        List<Integer> resList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int arr[][] = new int[m][n];
        int actionCount = scanner.nextInt();
        for (int i=0;i<actionCount;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[x][y] = -1;
            int tempArr [][] = new int[m][n];
            // copy temp Arr
            for (int p=0;p<m;p++){
                for (int j=0;j<n;j++){
                    tempArr[p][j] = arr[p][j];
                }
            }

            int currentCount = 0;
            for (int k=0;k<m;k++){
                for (int l=0;l<n;l++){
                    if (tempArr[k][l] == -1){
                        // 上
                        int upX = k-1;
                        int upY = l;
                        if (upX >= 0 && upY >= 0 && tempArr[upX][upY]!=-1 && tempArr[upX][upY]!=0){
                            tempArr[k][l] = tempArr[upX][upY];
                        }
                        // 左
                        int leftX = k;
                        int leftY = l-1;
                        if (leftX >= 0 && leftY >= 0 && tempArr[leftX][leftY]!=-1 && tempArr[leftX][leftY]!=0){
                            if (tempArr[k][l] == -1){
                                tempArr[k][l] = tempArr[leftX][leftY];
                                continue;
                            }
                            if (tempArr[leftX][leftY] > tempArr[k][l]){
                                tempArr[leftX][leftY] = tempArr[k][l];
                                currentCount = tempArr[k][l];
                                continue;
                            }
                        }

                        if ((upX<0 || upY < 0 || tempArr[upX][upY]==-1 || tempArr[upX][upY]==0 ) && ( leftX <0 || leftY < 0
                        || tempArr[leftX][leftY]==-1 || tempArr[leftX][leftY]==0)){
                            // 一个也不相邻
                            currentCount ++;
                            tempArr[k][l] = currentCount;
                        }


                    }
                }
            }
//            for (int a=0;a<m;a++){
//                for (int b =0 ;b<n;b++){
//                    System.out.print(tempArr[a][b]+" ");
//                }
//            }
//            System.out.println();
            resList.add(currentCount);
        }
        String resString = new String();
        for (int a : resList){
            resString += a + " ";
        }
        String a = resString.substring(0,resString.length()-1);
        System.out.println(a);
    }
}
