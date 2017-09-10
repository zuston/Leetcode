package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zuston on 9/1/17.
 */
public class RotateImage {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        Map<Integer,List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        for (int i=0; i<n; i++){
            List<Integer> list = new ArrayList<Integer>();
            for (int j=0; j<n; j++){
                list.add(matrix[i][j]);
            }
            hm.put(i,list);
        }

        for (int i=0; i<n; i++){
            List<Integer> list = hm.get(n-i-1);
            for (int j=0;j<n;j++){
                matrix[j][i] = list.get(j);
            }
        }
    }
}
