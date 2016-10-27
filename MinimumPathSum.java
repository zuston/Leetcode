package leetcode;

/**
 * Created by zuston on 16-10-27.
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int res[][] = new int[m][n];
        res[0][0]  = grid[0][0];
        for(int i=1;i<m;i++){
            res[i][0] = grid[i][0] + res[i-1][0];
        }
        for(int j=1;j<n;j++){
            res[0][j] = grid[0][j] + res[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                res[i][j] = Math.min(res[i-1][j],res[i][j-1])+grid[i][j];
            }
        }
        System.out.println(res[m-1][n-1]);
        return res[m-1][n-1];
    }

    public static void main(String[] args) {
        int a[][] = {{2,3,6},{3,7,6},{5,2,4},{3,4,6}};
        System.out.println(MinimumPathSum.minPathSum(a));
    }
}
