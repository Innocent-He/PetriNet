package main.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author He
 * @Date 2020/4/4 22:57
 * @Version 1.0
 */
public class CollectionUtils<T> {
    /**
     * 将数组转换为ArrayList
     * @param arr
     * @param <T>
     * @return
     */
    public static<T> List<T> arrToList(T[] arr){
        List<T> list=new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 将list转换为数组
     * @param list
     * @return
     */
     public static String[] listToArray(List<String> list){
        String[] arr=new String[list.size()];
        for (int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
     }

    /**
     * 如果lis1包含至少一个lis2的元素，则返回true
     *
     * @param lis1
     * @param lis2
     * @return
     */
    public static boolean containOnly(List<String> lis1, List<String> lis2) {
        for (int i = 0; i < lis1.size(); i++) {
            for (int j = 0; j < lis2.size(); j++) {
                if (lis1.get(i).equals(lis2.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
