package pinduoduo;

/**
 * Created by zuston on 8/1/17.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        int i,j;
        for(i=0; i<n; i++) {
            h[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] w = new int[m];
        for(i=0; i<m; i++) {
            w[i] = in.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int count = 0;
        for(i=0,j=0; i<h.length && j<w.length; ) {
            if (w[j] >= h[i]) {
                count++;
                j++;
                i++;
            }else {
                j++;
            }
        }
        System.out.println(count);
    }
}
