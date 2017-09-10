package netbeans2;

import java.util.*;

/**
 * Created by zuston on 9/9/17.
 */
public class Two {

    public static int findLcs(String A,String B){
        int n = A.length();
        int m = B.length();
        int dp[][] = new int[n+1][m+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (A.charAt(i) == B.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] +1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        List<String> result = res(line.length()/2);

        HashMap<Integer,Integer> lllllcs = new HashMap<Integer, Integer>();
        for (String one : result){
            if (one.equals(line)){
                continue;
            }
            int value = findLcs(one,line);
            if (lllllcs.containsKey(value)){
                int v = lllllcs.get(value);
                lllllcs.put(value,v+1);
            }else{
                lllllcs.put(value,1);
            }
        }

        int max = 0;
        for (Map.Entry<Integer,Integer> map : lllllcs.entrySet()){
            if (map.getValue() > max){
                max = map.getValue();
            }
        }
        System.out.println(max);
    }

    public static List<String> res(int pairs) {
        List<String> result = new ArrayList<String>();
        genr(pairs, pairs, "", result);
        return result;
    }

    public static void genr(int left, int right, String s,
                                List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
        }
        if (left > 0) {
            genr(left - 1, right, s + '(', result);
        }
        if (right > 0 && left < right) {
            genr(left, right - 1, s + ')', result);
        }
    }

}
