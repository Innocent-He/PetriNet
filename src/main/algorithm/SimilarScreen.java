package main.algorithm;

import main.resources.Constant;
import main.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static main.util.CollectionUtils.arrToList;

/**
 * 在所有ES中剔除相似环路
 *
 * @Author He
 * @Date 2020/4/4 22:27
 * @Version 1.0
 */
public class SimilarScreen {
    //存放相似环路的集合，两两一组
    static List<String> Similar = new ArrayList<>();

    public static List<String> screen(List<String> cycles) {
        List<String> resourceList = arrToList(Constant.RESOURCE_PLACE);
        //这个循环筛选资源库所完全一样的环路
        for (int i = 0; i < cycles.size(); i++) {
            //先将第一个作比较的环路的变迁全部去掉，结果集是listI
            String[] cycleI = cycles.get(i).split("-");
            List<String> lisI = CollectionUtils.arrToList(cycleI);
            for (int m = 0; m < lisI.size(); m++) {
                if (lisI.get(m).charAt(0) == 'T') {
                    lisI.remove(m);
                }
            }
            lisI.remove(lisI.size() - 1);
            for (int rei = 0; rei < lisI.size(); rei++) {
                if (!resourceList.contains(lisI.get(rei))) {
                    lisI.remove(rei);
                }
            }
            for (int j = i + 1; j < cycles.size(); j++) {
                //cycleJ是cycleI往后的环路
                String[] cycleJ = cycles.get(j).split("-");
                List<String> lisJ = CollectionUtils.arrToList(cycleJ);
                for (int n = 0; n < lisJ.size(); n++) {
                    if (lisJ.get(n).charAt(0) == 'T') {
                        lisJ.remove(n);
                    }
                }
                lisJ.remove(lisJ.size() - 1);
                for (int rej = 0; rej < lisJ.size(); rej++) {
                    if (!resourceList.contains(lisJ.get(rej))) {
                        lisJ.remove(rej);
                    }
                }
                //此处条件成立则表明cycles[i]和cycles[j]的资源库所相同
                if (lisI.containsAll(lisJ) && lisI.size() == lisJ.size()) {
                    //就在此处判断两个资源库所相同的环路的变迁是否在同一个进程中
                    if (similarProcess(cycles.get(i), cycles.get(j))) {
                        Similar.add(cycles.get(i));
                        Similar.add(cycles.get(j));
                    }

                }

            }
        }
        cycles.removeAll(Similar);
        System.out.println("相似环路有：" + Similar);
        return cycles;
    }


    /*此处将判断具有相同资源库所的环路中变迁是否都在同一个进程中*/
    public static boolean similarProcess(String cycle1, String cycle2) {
        List<Integer> flag1 = new ArrayList<>();
        List<Integer> flag2 = new ArrayList<>();

        String[] cycleI = cycle1.split("-");
        String[] cycleJ = cycle2.split("-");

        List<String> lisI = CollectionUtils.arrToList(cycleI);
        List<String> lisJ = CollectionUtils.arrToList(cycleJ);
        for (int m = 0; m < lisI.size(); m++) {
            if (lisI.get(m).charAt(0) == 'P') {
                lisI.remove(m);
            }
        }
        for (int m = 0; m < lisJ.size(); m++) {
            if (lisJ.get(m).charAt(0) == 'P') {
                lisJ.remove(m);
            }
        }
        lisI.remove(lisI.size() - 1);
        lisJ.remove(lisJ.size() - 1);
        //此处判断环路是否包含进程1的变迁
        if (CollectionUtils.containOnly(lisI, CollectionUtils.arrToList(Constant.PROCESS_FIRST))) {
            flag1.add(1);
            if (CollectionUtils.containOnly(lisI, CollectionUtils.arrToList(Constant.PROCESS_SECOND))) {
                flag1.add(2);
            }
        }
        //此处判断环路是否包含进程2的变迁
        if (CollectionUtils.containOnly(lisJ, CollectionUtils.arrToList(Constant.PROCESS_FIRST))) {
            flag2.add(1);
            if (CollectionUtils.containOnly(lisI, CollectionUtils.arrToList(Constant.PROCESS_SECOND))) {
                flag2.add(2);
            }
        }
        if (flag1.size() == flag2.size() && flag1.containsAll(flag2)) {
            return true;
        } else {
            return false;
        }
    }


}

