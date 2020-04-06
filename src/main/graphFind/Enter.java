package main.graphFind;


import main.algorithm.*;
import main.util.LoadDataUtil;
import main.util.LoopUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Author He
 * @Date 2020/4/3 19:11
 * @Version 1.0
 */
public class Enter {
    public static void run() {
        LoadDataUtil loadDataP = new LoadDataUtil();
        LoadDataUtil loadDataT = new LoadDataUtil();
        Properties tProp = loadDataT.loadProp("src/main/resources/isTGraph.properties");
        Properties pProp =loadDataP.loadProp("src/main/resources/isPGraph.properties");


        LoopUtil.loadData(pProp, "P");
        LoopUtil.loadData(tProp, "T");

        //得到所有的环路
        List<String> cycles = LoopUtil.find();
        //个数为580

        //筛选特殊环路
        String[] specialCycles = QuerySpecialCycle.screen(pProp,cycles);
        System.out.println(specialCycles.length);
        System.out.println(Arrays.toString(specialCycles));

        //筛选资源库所数目大于2且不包括闲置库所的环路（√）
        List<String> resourceCycle = ResourceScreen.screen(cycles);
        //个数为220

        //筛选掉重复的环路(√)
        List<String> noRepeatSourceCycle = RepeatScreen.screen(resourceCycle);
       // System.out.println(noRepeatSourceCycle);
     //   System.out.println(noRepeatSourceCycle.size());
        // System.out.println(noRepeatSourceCycle.size());
        //个数为87


        //筛选掉包含其它环路变迁的环路(√)
        List<String> realResourceCycle = MinCycleScreen.Screen(noRepeatSourceCycle);
      //  System.out.println(realResourceCycle);

        //筛选掉相似环路(√)
        List<String> screen = SimilarScreen.screen(realResourceCycle);
    //    System.out.println(screen);

        //找特殊环路
    }
}
