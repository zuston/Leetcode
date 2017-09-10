package ali;

/**
 * Created by zuston on 8/25/17.
 */
import java.util.Scanner;

public class Three{

    public static class BoxTemplate {
        public int length;
        public int width;
        public int height;
        public int price;
        public BoxTemplate(){}
    }

    public static class Model {
        public int length;
        public int width;
        public int height;
        public int price;
        public Model(){}
    }

    /** 请完成下面这个process函数，实现题目要求的功能 **/
    public static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    private static int process(int boxMinNum,BoxTemplate boxTemplate,Model[] items)
    {

        for(Model model:items){


        }
        return -1;

    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        BoxTemplate boxTemplate = new BoxTemplate();
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()){
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            int boxMinNum = Integer.MAX_VALUE;
            System.out.println (process(boxMinNum,boxTemplate,items));

        }
    }

}