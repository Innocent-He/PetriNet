package main.algorithm;

import main.resources.Constant;
import main.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author He
 * @Date 2020/4/5 19:28
 * @Version 1.0
 */
public class QuerySpecialCycle {
    public static String[] screen(String[] cycles) {
//        该集合存储只有一个资源库所的环路
        List<String> onlyResourcePlaceCycle = new ArrayList<>();
        //筛选只有一个资源库所的环路
        for (int i = 0; i < cycles.length; i++) {
            int flag = 0;
            String[] cycle = cycles[i].split("-");
            List<String> placeList = CollectionUtils.arrToList(Constant.RESOURCE_PLACE);
            for (int j = 0; j < cycle.length - 1; j++) {
                if (placeList.contains(cycle[j])) {
                    flag++;
                }
            }
            if (flag == 1) {
                onlyResourcePlaceCycle.add(cycles[i]);
            }
        }
        return CollectionUtils.listToArray(onlyResourcePlaceCycle);
    }

}

