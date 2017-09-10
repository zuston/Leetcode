package ali;

/**
 * Created by zuston on 8/25/17.
 */
import java.util.*;

public class One {

    public static int limitedPrice = 2000;
    public static int limitedLength;
    public static int limitWidth;
    public static int limitHeight;

/** 请完成下面这个process函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     * @param items**/
    private static int process(Model[] items)
    {
        ArrayList<Model> llist = new ArrayList<Model>(Arrays.asList(items));
        Collections.sort(llist, new Comparator<Model>() {
            public int compare(Model o1, Model o2) {
                if (o1.price > o1.price)    return 1;
                if (o1.price < o2.price)    return -1;
                return 1;
            }
        });
        int packAgeSum = 0;
        boolean restartFlag = true;
        int haveCostMoney = 2000;
        int havaLength = limitedLength;
        int haveWidth = limitWidth;
        int haveHeight = limitHeight;
        for (int i=0; i<llist.size();i++){
            Model model = llist.get(i);
            if (restartFlag){
                if (model.price <= 2000){
                    List<Integer> tempList = new ArrayList<Integer>(Arrays.asList(limitedLength,limitHeight,limitWidth));
                    Collections.sort(tempList);
                    List<Integer> modelList = new ArrayList<Integer>(Arrays.asList(model.height,model.width,model.length));
                    Collections.sort(modelList);

                    for (int k=0;k<3;k++){
                        if (modelList.get(k) > tempList.get(k))    return -1;
                    }

                    restartFlag = false;
                    haveCostMoney = 2000 - model.price;
                    haveHeight = tempList.get(0) - modelList.get(0);
                    haveWidth = tempList.get(1) - modelList.get(1);
                    havaLength = tempList.get(2) - modelList.get(2);
                    packAgeSum += 1;
                    continue;
                }
            }

            if (model.price <= haveCostMoney){
                List<Integer> tempList = new ArrayList<Integer>(Arrays.asList(havaLength,haveHeight,haveWidth));
                Collections.sort(tempList);
                List<Integer> modelList = new ArrayList<Integer>(Arrays.asList(model.height,model.width,model.length));
                Collections.sort(modelList);
                int tag = -2;
                for (int k=0;k<3;k++){
                    if (modelList.get(k) > tempList.get(k)){
                        tag = 0;
                    }
                }

                if(tag == 0){
                    i -= 1;
                    restartFlag = true;
                     haveCostMoney = 2000;
                     havaLength = limitedLength;
                     haveWidth = limitWidth;
                     haveHeight = limitHeight;
                    continue;
                }

                haveCostMoney = 2000 - model.price;
                haveHeight = tempList.get(0) - modelList.get(0);
                haveWidth = tempList.get(1) - modelList.get(1);
                havaLength = tempList.get(2) - modelList.get(2);

                continue;

            }

        }
        return packAgeSum;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            limitedLength = scanner.nextInt();
            limitWidth = scanner.nextInt();
            limitHeight = scanner.nextInt();

            int itemNum = scanner.nextInt();
            Model [] items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            System.out.println (process(items));
        }
    }

}

class Model{
    int price;
    int length;
    int width;
    int height;
}
