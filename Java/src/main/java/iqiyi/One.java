package iqiyi;

import java.util.Scanner;

/**
 * Created by zuston on 9/10/17.
 */
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        Long l1 = Long.valueOf(s1);
        int r1 = scanner.nextInt();

        String s2 = scanner.next();
        Long l2 = Long.valueOf(s2);
        int r2 = scanner.nextInt();


        if (s1.length()*r1 > s2.length()*r2){
            System.out.println("Greater");
            return;
        }

        if (s1.length()*r1 < s2.length()*r2){
            System.out.println("Less");
            return;
        }

        StringBuilder sb1 = new StringBuilder();
        for (int i=0;i<r1;i++){
            sb1.append(s1);
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i=0;i<r2;i++){
            sb2.append(s2);
        }

//        char [] s11 = sb1.toString().toCharArray();
//        char [] s22 = sb2.toString().toCharArray();
        if (sb1.toString().compareTo(sb2.toString())>0){
            System.out.println("Greater");
            return;
        }

        if (sb1.toString().compareTo(sb2.toString())<0){
            System.out.println("Less");
            return;
        }

        System.out.println("Equal");
//        for (int i=0;i<r2*s1.length();i++){
//            int v1 = Integer.valueOf(s11[i]+"");
//            int v2 = Integer.valueOf(s22[i]+"");
//            if (v1>v2){
//                System.out.println("Greater");
//                return;
//            }
//            if (v1<v2){
//                System.out.println("Less");
//                return;
//            }
//        }
//        System.out.println("Equal");
    }
}
