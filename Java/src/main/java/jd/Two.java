package jd;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zuston on 9/8/17.
 */
public class Two {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = 2;

        if (n==1){
            System.out.println(3);
            return;
        }

        HashMap<BigDecimal,Integer> hashMap = new HashMap<BigDecimal, Integer>();
        Set<String> hashset = new HashSet<String>();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                BigDecimal value = BigDecimal.valueOf(Math.pow(i,j));
                if (hashset.contains(i+":"+j)){
                    continue;
                }
                hashset.add(i+":"+j);
                if (hashMap.containsKey(value)){
                    Integer v = hashMap.get(value);
                    hashMap.put(value,v+1);
                }else{
                    hashMap.put(value,1);
                }
            }
        }
        int count = 0;
        for (Map.Entry<BigDecimal,Integer> mapper : hashMap.entrySet()){
            int vv = mapper.getValue();
            count += Math.pow(vv,2);
        }
        System.out.println(count%(Math.pow(9,10)+7));
    }

    private static BigDecimal pow(BigDecimal index, int up){
        if (up==0){
            return BigDecimal.valueOf(1);
        }
        else {
            if (up%2==0){
                return pow(index.multiply(index),up/2);

            }else{
                return pow(index.multiply(index),(up-1)/2).multiply(index);
            }
        }
    }
}
