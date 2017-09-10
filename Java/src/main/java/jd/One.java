package jd;

/**
 * Created by zuston on 9/8/17.
 */
import java.util.Scanner;


public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content=scanner.next();
        int left=0;
        int right=0;
        int value=1;
        char [] contentArr =content.toCharArray();

        for(int i=0;i<contentArr.length;i++){
            if(contentArr[i]=='(')
                left++;
            else{
                right++;
                value=value*(left-right+1);
            }
        }
        System.out.println(value);
    }

}
