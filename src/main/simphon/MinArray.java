package main.simphon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**arr2是arr1的子集则返回true
 * @param
 */
public class MinArray {


    public boolean isSubset(ArrayList<Integer> arr1, ArrayList<Integer> arr2)
    {
        List<Integer> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();
        int m=arr1.size();
        int n=arr2.size();
        for(int i = 0; i < m; i++)
        {
            list1.add(arr1.get(i));
        }
        for(int i = 0; i < n; i++)
        {
            list2.add(arr2.get(i));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (list1.containsAll(list2)){
            return true;
        }else{
            return false;
        }

    }
}
