package chubao;

import java.util.*;

/**
 * Created by zuston on 9/26/17.
 */
public class Two {
    public static Integer nodeCount;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        nodeCount = scanner.nextInt();
        int nodeMapper [] = new int[nodeCount];
        int nodeValue [] = new int[nodeCount];
        for (int i=1;i<nodeCount;i++){
            nodeMapper[i] = scanner.nextInt();
        }

        for (int i=0;i<nodeCount;i++){
            nodeValue[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i=1;i<nodeCount;i++){
            int value = i;
            Set<Integer> tempSet = new HashSet<Integer>();
            tempSet.add(value);
            find(nodeMapper,tempSet,value);
            List<Integer> tempList = new ArrayList<Integer>(tempSet);

            int oneMax = 0;
            for (Integer v : tempList){
                oneMax = nodeValue[v] > oneMax ? nodeValue[v] : oneMax;
            }

            List<Integer> leaveList = new ArrayList<Integer>();
            for (Integer a : nodeMapper){
                if (!tempList.contains(a)){
                    leaveList.add(a);
                }
            }
            int twoMax = 0;
            for (Integer v : leaveList)
                twoMax = twoMax > nodeValue[v] ? twoMax : nodeValue[v];
            count += Math.abs(oneMax-twoMax);
        }
        System.out.println(count);
    }

    private static void find(int[] nodeMapper, Set<Integer> tempSet,int value) {
//        for (int i=0;i<nodeCount;i++){
//            for (int k=0;k<nodeCount;k++){
//                if (tempSet.contains(nodeMapper[k])){
//                    tempSet.add(k);
//                }
//            }
//        }
        for (int k=0;k<nodeCount;k++){
            loop(nodeMapper,k,value,tempSet,k);
        }
    }

    private static void loop(int [] arr,int index,int value,Set<Integer> tempSet,int start){
        if (arr[index]==0 || start==value)   return;
        if (arr[index]==value || tempSet.contains(arr[index])){
            tempSet.add(start);
            tempSet.add(index);
            return;
        }
        loop(arr,arr[index],value,tempSet,start);
    }
}
