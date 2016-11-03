package leetcode;

/**
 * Created by zuston on 16/10/31.
 */
import java.util.LinkedList;

/**
 * 71. Simplify Path
 *  For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
 */

public class SimplifyPath {
    public SimplifyPath() {
    }

    class zstack<T>{
        private LinkedList<T> ll = new LinkedList<T>();

        public void pop(){
            ll.removeFirst();
        }

        public void push(T v){
            ll.addFirst(v);
        }

        public T peek(){
            return ll.getFirst();
        }

        public boolean isEmpty(){
            return ll.isEmpty();
        }
        public T popAndGet(){
            T v = ll.getLast();
            ll.removeLast();
            return v;
        }

        public T getLast(){
            return ll.getLast();
        }
    }

    public String simplifyPath(String path){
        String [] list = path.split("/");
        zstack<String> zs = new zstack<>();
        int count = 0;
        if(list.length==0){
            return "/";
        }
        for(String l:list){
            count++;
            if(count==1){
                continue;
            }
            if(zs.isEmpty()&&(l.equals(".")||l.equals(".."))){
                continue;
            }
            if(l.equals(".")){
                continue;
            }
            if (l.equals("..")){
                zs.pop();
                continue;
            }
            if(l.equals("")){
                continue;
            }
            zs.push(l);
        }
        String res = "";
        if(zs.isEmpty()){
            return "/";
        }
        
        while (!zs.isEmpty()){
            res += "/" + zs.popAndGet();
        }
        System.out.println(res);
        return res;
   }


    public static void main(String[] args) {
        SimplifyPath a = new SimplifyPath();
        a.simplifyPath("/m//joe/");
    }
}


