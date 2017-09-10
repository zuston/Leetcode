package pinduoduo;

import java.util.Scanner;

/**
 * Created by zuston on 8/1/17.
 */
public class Two {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String str1 = value.split(" ")[0];
        String str2 = value.split(" ")[1];

        int len1 = str1.length();
        int len2 = str2.length();

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        convertting(s1, len1);
        convertting(s2, len2);

        multiply(s1, len1, s2, len2);

    }

    public static void convertting(char data[], int len) {
        //高低位对调
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }

    public static void multiply(char a[], int alen, char b[], int blen) {
        int csize = alen + blen + 3;
        int[] c = new int[csize];
        for (int ii = 0; ii < csize; ii++) {
            c[ii] = 0;
        }
        for (int j = 0; j < blen; j++) {
            for (int i = 0; i < alen; i++) {
                c[i + j] +=  Integer.parseInt(String.valueOf(a[i]))* Integer.parseInt(String.valueOf(b[j]));
            }
        }
        int m = 0;
        for (m = 0; m < csize; m++) {
            int carry = c[m] / 10;
            c[m] = c[m] % 10;
            if (carry > 0)
                c[m + 1] += carry;
        }
        for (m = csize - 1; m >= 0;) {
            if (c[m] > 0)
                break;
            m--;
        }
        for (int n = 0; n <= m; n++) {
            System.out.print(c[m - n]);
        }
    }
}


