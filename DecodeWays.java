package leetcode;

/**
 * Created by zuston on 16-11-1.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        char [] arrays = s.toCharArray();
        int length = arrays.length;
        if(length==0){
            return 0;
        }
        if(length==1){
            if(Integer.parseInt(String.valueOf(arrays[0]))==0){
                return 0;
            }else {
                return 1;
            }
        }
        int one = Integer.parseInt(String.valueOf(arrays[0]));
        int two = Integer.parseInt(String.valueOf(arrays[1]));
        int lo = (one!=0)?1:0;
        int lt = (one*10+two<=26&&two!=0)?2:1;
        if(lo==0||(one*10+two>26&&two==0)){
            return 0;
        }
        if(length==2){
            return lt;
        }
        int res[] = new int[length];
        for(int i=2;i<length;i++){

            int a = Integer.parseInt(String.valueOf(arrays[i]));
            int b = Integer.parseInt(String.valueOf(arrays[i-1]));
            if(a==0&&b==0){
                return 0;
            }
            if(a==0&&a+b*10>26){
                return 0;
            }
            if(a+b*10<=26&&a!=0&&b!=0){
                res[i] = lt + lo;
            }else if(a==0){
                res[i] = lo;
            }else{
                res[i] = lt;
            }
            lo = lt;
            lt = res[i];
        }
        return res[length-1];
    }

    public static void main(String[] args) {

    }
}
