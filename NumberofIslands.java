package leetcode;

import javax.xml.parsers.FactoryConfigurationError;
import java.nio.channels.Pipe;
import java.util.Queue;

/**
 * Created by zuston on 16/11/3.
 */
public class NumberofIslands{
    public int m;
    public int n;
    public char [][] gd;
    public int sumCount = 0;
    public int tag[][];
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m==0){
            return 0;
        }
        n = grid[0].length;
        gd = grid;
        tag = new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                tag[i][j] = 0;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    // System.out.println("正在查找中"+i+":"+j);
                    sumCount += search(i,j);
                }
            }
        }
        return sumCount;
    }

    public int search(int i,int j){
        int flag = 0;
        if(i-1>=0&&gd[i-1][j]=='1'&&tag[i-1][j]==0){
            tag[i-1][j] = 1;
            search(i-1,j);
            flag = 1;
        }
        if(i+1<m&&gd[i+1][j]=='1'&&tag[i+1][j]==0){
            tag[i+1][j] = 1;
            search(i+1,j);
            flag = 1;

        }
        if(j-1>=0&&gd[i][j-1]=='1'&&tag[i][j-1]==0){
            tag[i][j-1] = 1;
            search(i,j-1);
            flag = 1;

        }
        if(j+1<n&&gd[i][j+1]=='1'&&tag[i][j+1]==0){
            tag[i][j+1] = 1;
            search(i,j+1);
            flag = 1;
        }
        if(flag==0){
            boolean a1 = (i-1>=0&&tag[i-1][j]==0)||i-1<0?true:false;
            boolean a2 = (i+1<m&&tag[i+1][j]==0)||i+1>=m?true:false;
            boolean a3 = (j-1>=0&&tag[i][j-1]==0)||j-1<0?true:false;
            boolean a4 = (j+1<n&&tag[i][j+1]==0)||j+1>=n?true:false;
            // System.out.println(a1);
            // System.out.println(a2);
            // System.out.println(a3);
            // System.out.println(a4);
            if(a1&&a2&&a3&&a4){
                flag = 1;
                tag[i][j] = 1;
            }

        }
        // System.out.println("查找的标记"+flag);
        return flag;
    }

}