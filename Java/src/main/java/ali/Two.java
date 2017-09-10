package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> LineArr) {
        List<String> transmtting=new ArrayList<String>();
        List<String> result = new ArrayList<String>();

        for(int i=0;i<LineArr.size();i++){
            UnilateralLine temp=LineArr.get(i);
            if(transmtting.contains(temp.getId()))
                continue;
            for(int j=0;j<LineArr.size();j++){
                if(j==i)
                    continue;
                UnilateralLine tt=LineArr.get(j);
                if(transmtting.contains(tt.getId()))
                    continue;
                if(tt.getSCen().equals(temp.getECen())){
                    if(tt.getECen().equals(temp.getSCen())&&temp.getTType().equals(tt.getTType())){//Rule1
                        result.add("rule1:" + temp.getId() + "+" + tt.getId());
                        transmtting.add(temp.getId());
                        transmtting.add(tt.getId());
                    }
                    for (int k=0;k<LineArr.size();k++){
                        if(k==i||k==j)
                            continue;
                        if(transmtting.contains(temp.getId()))
                            continue;
                        UnilateralLine third=LineArr.get(k);
                        if(third.getSCen().equals(tt.getECen())&&third.getECen().equals(temp.getSCen())){//rule2
                            result.add("rule2:"+temp.getId()+"+"+tt.getId()+"+"+third.getId());
                            transmtting.add(temp.getId());
                            transmtting.add(tt.getId());
                            transmtting.add(third.getId());
                        }
                    }
                }


                if(transmtting.contains(temp.getId())||transmtting.contains(tt.getId()))
                    continue;


                if(tt.getECen().equals(temp.getSCen())){//rule3
                    if(tt.getSPro().equals(temp.getEPro())&&tt.getTType().equals(temp.getTType())){
                        result.add("rule3:"+temp.getId()+"+"+tt.getId());
                        transmtting.add(temp.getId());
                        transmtting.add(tt.getId());
                    }
                }

            }
        }
        return result;
    }
    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型
        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
        public String getId() {return id;}
        public void setId(String id) {this.id = id;}
        public String getSCen() {return sCen;}
        public void setSCen(String ePro) {this.ePro = ePro;}
        public String getSPro() {return sPro;}
        public void setSPro(String sPro) {this.sPro = sPro;}
        public String getECen() {return eCen;}
        public void setECen(String eCen) {this.eCen = eCen;}
        public String getEPro() {return ePro;}
        public void setEPro(String ePro) {this.ePro = ePro;}
        public String getTType() {return tType;}
        public void setTType(String tType) {this.tType = tType;}
    }
}
