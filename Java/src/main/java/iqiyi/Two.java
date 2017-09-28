package iqiyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zuston on 9/10/17.
 */
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if (str==""){
            System.out.println(0);
            return;
        }
        char [] arr = str.toCharArray();
        Stack<String> stack = new Stack<String>();

        int max = 0;
        int temp = 0;
        for (char a : arr){
            if (a=='('){
                temp++;
                max = temp>max ? temp : max;
                continue;
            }
            temp--;
        }

        System.out.println(max);
    }
}
