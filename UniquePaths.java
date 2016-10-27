package leetcode;

/**
 * Created by zuston on 16-10-27.
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if(m==1||n==1){
            return 1;
        }
        int res[][] = new int[m][n];
        res[0][0] = 1;
        for(int i=1;i<n;i++){
            res[0][i] = res[0][i-1];
        }
        for(int j=1;j<m;j++){
            res[j][0] = res[j-1][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                res[i][j] = res[i-1][j]+res[i][j-1];
            }
        }

        return res[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(UniquePaths.uniquePaths(3,10));
    }
}
