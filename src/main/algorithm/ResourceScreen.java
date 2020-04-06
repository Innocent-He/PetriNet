package main.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author He
 * @Date 2020/4/3 22:05
 * @Version 1.0
 */
public class ResourceScreen {
    /**
     * 将所有环路中的资源库所筛选出来
     * @param cycles
     * @return
     */
    public static List<String> screen(List<String> cycles){
        List<String> resourceCycle=new ArrayList<>();

        for (String cycle:cycles){
            String[] split = cycle.split("-");
            if (isIncludeResource(split)){
                resourceCycle.add(cycle);
            }
        }
        return resourceCycle;
    }
    //传入所有环路，判断是否是一个ES
    public static boolean isIncludeResource(String[] cycle){
        List<String> lis=new ArrayList<>();
        int flagResource=0;
        int flagUnused=0;
        for (int i=0;i<cycle.length;i++){
            lis.add(cycle[i]);
        }
        for (int i=0;i<lis.size()-1;i++){
            switch (lis.get(i)){
                case ("P13"):flagResource++;break;
                case ("P14"):flagResource++;break;
                case ("P15"):flagResource++;break;
                case ("P16"):flagResource++;break;
                case ("P1"):flagUnused++;break;
                case ("P7"):flagUnused++;break;
                default:continue;
            }
        }
        if (flagResource>=2&&flagUnused==0){
            return true;
        }else {
            return false;
        }
    }
}
