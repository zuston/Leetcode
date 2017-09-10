package netbeans;

import java.util.Scanner;



public class Three {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n ,k ;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int result = solution.getPermutationCount(n,k);
        System.out.println(result);
    }
}

class Solution {
    public int  count;
    public void Permutation(int n, int k, int index, int num) {
        if (index == n) {
            count++;
            return ;
        }
        for (int i=1; i<=k; i++) {
            if (i>=num || num%i != 0) {
                Permutation(n, k, index+1, i);
            }
        }
    }

    public int getPermutationCount(int n, int k) {
        count = 0;

        Permutation(n, k, 0, 1);

        return count;
    }
}
