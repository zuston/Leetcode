package chubao;

import java.util.Scanner;

/**
 * Created by zuston on 9/26/17.
 */
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        for (int i=0;i<numberCount;i++){
            long start = scanner.nextInt();
            long end = scanner.nextInt();

            long res = start;
            while ((res | (res+1))<=end){
                res |= res +1 ;
            }
            System.out.println("Case "+(i+1)+": "+res);

        }
    }
}
