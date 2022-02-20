package zheng.javalearn;

import java.util.ArrayList;
import java.util.HashMap;

public class Step1 {

    HashMap<ApfDto, ArrayList<Position>> hmp = new HashMap<>();
    ApfDto apf = new ApfDto();

    public HashMap<ApfDto, ArrayList<Position>> getResult(Position p) {
        ArrayList<Position> positionList = new ArrayList<>();
        if (!hmp.isEmpty()) {
            for (ApfDto a : hmp.keySet()) {
                if (a.getName().equals(p.getName())) {
                    apf = a;
                    hmp.get(apf).add(p);
                    return hmp;
                }
            }
        }
        ApfDto apf = new ApfDto();
        apf.setName(p.getName());
        apf.setAge(p.getAge());
        positionList.add(p);
        hmp.put(apf, positionList);
        return hmp;
    }
}
