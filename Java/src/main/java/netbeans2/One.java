package netbeans2;

import java.util.Arrays;
import java.util.Scanner;


public class One {

    public static int sort(int n){
        int count=0;
        while(n>0){
            if(n%2==0)
                count++;
            else
                break;
            n=n/2;
        }
        return count;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            int ppp=scanner.nextInt();
            int array[]=new int[ppp];
            for(int j=0;j<ppp;j++){
                array[j]=scanner.nextInt();
            }
            if(Geet(array)==false)
                System.out.println("No");
            else{
                System.out.println("Yes");
            }
        }

    }

    public static boolean Geet(int arr[]){
        int len=arr.length;
        int eee[]=new int[arr.length];
        for(int i=0;i<len;i++){
            eee[i]=sort(arr[i]);
        }
        Arrays.sort(eee);
        int b[]=new int[len];
        int temp=0;
        int tmp=len-1;
        for(int i=0;i<len;i++){
            if(i%2==0){
                b[i]=eee[temp];
                temp++;}
            else{
                b[i]=eee[tmp];
                tmp--;
            }
        }
        eee=null;
        for(int i=0;i<len-1;i++){
            if(b[i]+b[i+1]<2)
                return false;
        }
        return true;
    }

}