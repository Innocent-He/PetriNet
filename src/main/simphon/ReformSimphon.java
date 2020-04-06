package main.simphon;

import java.util.ArrayList;

public class ReformSimphon {

    public ArrayList<ArrayList<Integer>> reform(ArrayList<ArrayList<Integer>> lis){
        for (ArrayList<Integer> list:lis){
            for (int i=0;i<list.size();i++){
                list.set(i,list.get(i)+1);
            }
        }
        return lis;
    }
}
