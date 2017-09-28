package didi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zuston on 9/23/17.
 */
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> resList = new ArrayList<String>();
        for (int i=0;i<2;i++){
            String a = scanner.next();
            int n = scanner.nextInt();
            System.out.println(loop(new BigDecimal(a),n).toString());
        }

    }


    private static BigDecimal loop(BigDecimal base, int ex){

        if(ex == 1)
            return base;
        if(ex == 0)
            return new BigDecimal(1);
        BigDecimal res = loop(base,ex >>1);
        res = res.multiply(res);
        if((ex&0x1) == 1)
            res = res.multiply(base);
        return res;
    }
}
