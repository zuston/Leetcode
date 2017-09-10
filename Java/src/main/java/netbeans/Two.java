package netbeans;

import java.util.*;

/**
 * Created by zuston on 8/12/17.
 */
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Position> list = new ArrayList<Position>();
        for (int i=0;i<count;i++){
            Position position = new Position();
            position.x = scanner.nextInt();
            list.add(i,position);
        }

        for (int i=0;i<count;i++){
            Position position = list.get(i);
            position.y = scanner.nextInt();
        }

        List<Integer> valueList = new ArrayList<Integer>();
        for (int i=0;i<count;i++){
            Position basePosition = list.get(i);
            Integer baseX = basePosition.x;
            Integer baseY = basePosition.y;
            basePosition.distance = Double.MAX_VALUE;
            for (int k=0;k<count;k++){
                if (k!=i){
                    Position comPosition = list.get(k);
                    int x = comPosition.x;
                    int y = comPosition.y;
                    comPosition.distance = Math.pow(x-baseX,2)+ Math.pow(y-baseY,2);
                }
            }
            List<Position> copyList = new ArrayList<Position>();
            int k = 0;
            for (Position p : list){
                if (k!=i){
                    copyList.add(p.qClone(p.x,p.y,p.distance));
                }
                k ++;
            }
            Collections.sort(copyList, new Comparator<Position>() {
                public int compare(Position o1, Position o2) {
                    return o1.distance>o2.distance?1:-1;
                }
            });
            int step = 0;
            for (int j=0;j<i;j++){
                Position p = copyList.get(j);
                step += Math.abs(p.x-baseX) + Math.abs(p.y-baseY);
            }
            valueList.add(step);
        }
        for (Integer c : valueList){
            System.out.print(c+" ");
        }
        String a = "";
        a.trim();
    }
}


class Position {
    Integer x;
    Integer y;
    double distance;

    protected Position qClone(Integer x,Integer y,double distance){
        Position position = new Position();
        position.x = x;
        position.y = y;
        position.distance = distance;
        return position;
    }
}
