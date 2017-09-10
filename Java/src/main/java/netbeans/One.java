package netbeans;

import java.util.Scanner;

/**
 * Created by zuston on 8/12/17.
 */
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String [] arr = line.split(" ");
        long x = scanner.nextLong();
        long f = scanner.nextLong();
        long d = scanner.nextLong();
        long p = scanner.nextLong();
        long needdays = 0;
        if (d/x <f){
            needdays = d/x;
        }else {
            needdays = f + ((d-x*f)/(x+p));
        }

        System.out.println(needdays);
    }
}
