package main.simphon;

import java.util.List;
//如果arr2是arr1的子集则返回true
public class Minarraytwo {
    public boolean isSubset(List<Integer> arr1, List<Integer> arr2)
    {
        int m=arr1.size();
        int n=arr2.size();
        if (n>=m){
            return false;
        }

        if (arr1.containsAll(arr2)){
            return true;
        }else{
            return false;
        }

    }
}
