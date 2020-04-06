package main.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author He
 * @Date 2020/4/3 19:41
 * @Version 1.0
 */
public class MinCycleScreen {
    public static List<String> Screen(List<String> cycles) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<cycles.size();i++){
            int flag=0;
            for (int j=0;j<cycles.size();j++){
                if (i==j){
                    continue;
                }
                if (screenUtil(cycles.get(i),cycles.get(j))){
                    break;
                }
                flag++;
            }
            if (flag==cycles.size()-1){
                list.add(cycles.get(i));
            }
        }
        return list;
    }


    /**
     * s1中的变迁包含s2的变迁时则返回true s1/s2="T1-P3-T1-P6……"
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean screenUtil(String s1, String s2) {
        List<String> lis1 = new ArrayList<>();
        List<String> lis2 = new ArrayList<>();
        String c1 = s1;
        String c2 = s2;
        String[] split1 = c1.split("-");
        String[] split2 = c2.split("-");
        //分别去除两个字符串数组中的库所以及多余的变迁
        if (split1[0].charAt(0) == 'T') {
            for (int i = 1; i < split1.length; i = i + 2) {
                split1[i] = null;
            }
            split1[split1.length - 1] = null;

        } else {
            for (int i = 0; i < split1.length; i = i + 2) {
                split1[i] = null;
            }
        }
        if (split2[0].charAt(0) == 'T') {
            for (int i = 1; i < split2.length; i = i + 2) {
                split2[i] = null;
            }
            split2[split2.length - 1] = null;
        } else {
            for (int i = 0; i < split2.length; i = i + 2) {
                split2[i] = null;
            }
        }

        for (int i = 0; i < split1.length; i++) {
            if (split1[i] != null) {
                lis1.add(split1[i]);
            }
        }
        for (int i = 0; i < split2.length; i++) {
            if (split2[i] != null) {
                lis2.add(split2[i]);
            }
        }
        if (lis1.containsAll(lis2)) {
            lis1.clear();
            lis2.clear();
            return true;
        }
        lis1.clear();
        lis2.clear();
        return false;
    }
}
