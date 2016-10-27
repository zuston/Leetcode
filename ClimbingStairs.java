package leetcode;

/**
 * Created by zuston on 16-10-27.
 */
public class ClimbingStairs {

    public int n;
    public int count=0;
    public int climbStairs(int n) {
        this.n = n;
        climb(0);
        System.out.println(count);
//        return count;
        return climbDesign();
    }

    /**
     * 递归算法
     * @param step
     */
    public void climb(int step){
        if(step==n){
            count++;
            return;
        }
        if(step>n){
            return;
        }
        climb(step+1);
        climb(step+2);
    }

    /**
     * 动态规划算法
     * @param
     */
    public int climbDesign(){
        if(n<=1){
            return 1;
        }
        int l = 1;
        int ll = 1;
        int pp = 0;
        for(int i=2;i<n;i++){
            pp = l+ll;
            ll = l;
            l = pp;
        }
        return pp;
    }

    public static void main(String[] args) {
        ClimbingStairs a = new ClimbingStairs();
        a.climbStairs(10);
    }
}
