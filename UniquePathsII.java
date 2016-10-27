package leetcode;

/**
 * Created by zuston on 16-10-27.
 */
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int res[][] = new int[m][n];
        res[0][0] = 1;
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==0){
                res[0][i] = res[0][i-1];
            }else{
                res[0][i] = 0;
            }
        }
        for(int j=1;j<m;j++){
            if(obstacleGrid[j][0]!=1){
                res[j][0] = res[j-1][0];
            }else{
                res[j][0] = 0;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (obstacleGrid[i][j]==0) {
                    res[i][j] = res[i-1][j]+res[i][j-1];
                }else{
                    res[i][j] = 0;
                }
            }
        }
        return res[m-1][n-1];
    }

    public static void main(String[] args) {
        int a[][] = {{0,0,1,0},{0,1,0,0}, {0,0,0,0}};
        System.out.println(UniquePathsII.uniquePathsWithObstacles(a));
    }
}
