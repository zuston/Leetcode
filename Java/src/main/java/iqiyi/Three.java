package iqiyi;

import java.util.Scanner;

public class Three {
    static int max = 100000;
    static int dp [] = new int[max];
    static int p[] = new int[max];
    static int n , m;
    static boolean s[] = new boolean[max];

    void pm(){
        for (int i=0;i<max;i++)
            s[i]=false;
            for (int i=2;i*i<max;i++){
                if (!s[i]){
                    for (int j=2;j*i<max;j++){
                        s[i*j] = true;
                    }
                }
            }

            int num = 0;
        for (int i=2;i<max;i++){
            if (!s[i])
                p[num++]=i;
        }

    }

    void in(){
        dp[1] = 1;
        dp[0] = 0;
        for (int i=2;i<max;i++){
            double m = i;
            double k = Math.pow(m,1/2);
            if (Math.pow(k,2)==m) dp[i]=1;
            dp[i]+=dp[i-1];
        }
    }



    public static void main(String[] args) {

        Three a = new Three();
        a.in();
        a.pm();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = dp[m];
        for (int i=2;i<=n;i++){
            if (!s[i]){
                if (i>m) continue;
                sum += dp[m/i];
                continue;
            }

        int d=i;
        int r =1;
        for (int j=0;p[j]*p[j]<=d;j++){
            int f = 0;
            while (d%p[j]==0){
                f++;
                d=d/p[j];
            }
            if (f%2>0) r=r*p[j];

        }
            if (d>1) r*=d;
            if (r>m) continue;
            sum += dp[m/r];
        }


        System.out.println(sum);


    }

    public static int count(long a, long b) {
        double res = Math.sqrt(a*b);
        long ret = (long) res;
        if (ret == res) {
            return 2;
        }
        return -1;
    }

}