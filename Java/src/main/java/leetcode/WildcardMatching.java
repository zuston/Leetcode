package leetcode;

/**
 * Created by zuston on 9/1/17.
 */

/**
 * 递归匹配，贪婪算法
 */
public class WildcardMatching {
    public char [] strArr;
    public char [] stardardArr;
    public boolean isMatch(String s, String p) {
        strArr = s.toCharArray();
        stardardArr = p.toCharArray();
        return loop(0,0);
    }

    private boolean loop(int i, int j) {
        // 判断条件退出的时候，就是两边都到底了
        if (j == stardardArr.length)    return i==stardardArr.length;
        if (strArr[i] == stardardArr[j] || stardardArr[j] == '?')
            return loop(i+1, j+1);

        if (stardardArr[j] == '*'){
            while (j < stardardArr.length){
                if (loop(i+1,j+1))    return true;
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("abcdeddd","a?*d"));
    }
}
