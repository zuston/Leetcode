package wap;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by zuston on 9/24/17.
 */
public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> container = new LinkedList<Integer>();
        int actionNumber = scanner.nextInt();
        boolean actionMode = true;

        int currentMax = Integer.MIN_VALUE;
        int maxNumnber = 0;
        for (int i=0;i<actionNumber;i++){
            String action = scanner.next();

            if (!actionMode){
                if (action.equals("push_front")){
                    action = "push_back";
                }
                else if (action.equals("push_back")){
                    action = "push_front";
                }
else                 if (action.equals("pop_front")){
                    action = "pop_back";
                }
else                 if (action.equals("pop_back"))
                    action = "pop_front";
            }

            if (action.equals("push_front") || action.equals("push_back")){
                int number = scanner.nextInt();
                if (number > currentMax){
                    currentMax = number;
                    maxNumnber = 0;
                }
                if (number == currentMax){
                    maxNumnber ++;
                }
                if (action.equals("push_front")){
                    container.addFirst(number);
                }
                if (action.equals("push_back")){
                    container.addLast(number);
                }
            }

            if (action.equals("pop_front")){
                try {
                    Integer res = container.getFirst();
                    if (res == currentMax){
                        currentMax = container.getFirst();
                        for (Integer value : container){
                            if (value > currentMax)
                                currentMax = value;
                        }
                    }
                    container.remove(0);
                    System.out.println(res);
                }catch (Exception e){
                    System.out.println("Error");
                }
            }

            if (action.equals("pop_back")){
                try {
                    Integer res = container.getLast();
                    if (res == currentMax){
                        currentMax = container.getFirst();
                        for (Integer value : container){
                            if (value > currentMax)
                                currentMax = value;
                        }
                    }
                    container.remove(container.size()-1);
                    System.out.println(res);
                }catch (Exception e){
                    System.out.println("Error");
                }
            }

            if (action.equals("max")){
                try {
                    int max = container.getFirst();
                    for (Integer value : container){
                        if (value > max)
                            max = value;
                    }
                    System.out.println(max);
                }catch (Exception e){
                    System.out.println("Error");
                }
            }

            if (action.equals("reverse")){
//                LinkedList<Integer> newContainer = new LinkedList<Integer>();
//                for (int value : container){
//                    newContainer.addFirst(value);
//                }
//                container = newContainer;
                actionMode = !actionMode;
            }
        }
    }
}
