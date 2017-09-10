package pinduoduo;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zuston on 8/1/17.
 */
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
//            int [] a = new int[n];
            List<BigDecimal> list = new ArrayList<BigDecimal>();
            for (int i=0;i<n;i++){
//                a[i] = scanner.nextInt();
                list.add(scanner.nextBigDecimal());
            }

            Collections.sort(list);
            if (n<3){
                BigDecimal res = new BigDecimal(1);
                for (int i=0;i<n;i++){
                    res = res.multiply(list.get(n));
                }
                System.out.println(res);
                return;
            }

            BigDecimal max = new BigDecimal(Integer.MIN_VALUE);
            if(max.compareTo(list.get(0).multiply(list.get(n-1)).multiply(list.get(n-2)))<0){
                max = list.get(0).multiply(list.get(n-1)).multiply(list.get(n-2));
            }
            if(max.compareTo(list.get(0).multiply(list.get(1)).multiply(list.get(n-1)))<0) {
                max = list.get(0).multiply(list.get(1)).multiply(list.get(n-1));
            }
            if(max.compareTo(list.get(0).multiply(list.get(1)).multiply(list.get(2)))<0){
                max = list.get(0).multiply(list.get(1)).multiply(list.get(2));
            }
            if(max.compareTo(list.get(n-1).multiply(list.get(n-2)).multiply(list.get(n-3)))<0) {
                max = list.get(n-1).multiply(list.get(n-2)).multiply(list.get(n-3));
            }
            System.out.println(max);

//            if (a[n-1]<0){
//                System.out.println(a[n-1]*a[n-2]*a[n-3]);
//            }else if (a[0]>0){
//                System.out.println(a[n-1]*a[n-2]*a[n-3]);
//            }else{
//                int max = Integer.MIN_VALUE;
//                if(max<a[0]*a[n-1]*a[n-2]){
//                    max = a[0]*a[n-1]*a[n-2];
//                }
//                if(max < a[0]*a[1]*a[n-1]) {
//                    max = a[0]*a[1]*a[n-1];
//                }
//                if(max < a[0]*a[1]*a[2]){
//                    max = a[0]*a[1]*a[2];
//                }
//                if(max < a[n-1]*a[n-2]*a[n-3]) {
//                    max = a[n-1]*a[n-2]*a[n-3];
//                }
//                System.out.println(max);
//
//            }
        }
    }
}
