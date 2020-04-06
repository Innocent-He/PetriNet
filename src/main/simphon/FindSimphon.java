package main.simphon;

import java.io.*;
import java.util.*;
import java.util.List;


public class FindSimphon {
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        FindSimphon.Simphon("C:\\Users\\H\\Desktop\\My text1.txt");
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1+"毫秒");
    }

    public static void Simphon(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        int si;
        Minarraytwo airy2=new Minarraytwo();
        MinArray airy = new MinArray();
        MyCombine combine = new MyCombine();
        File file = new File(name);
        ArrayList<ArrayList<Integer>> Post = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Pre = new ArrayList<>();
        ArrayList<Integer> lisEndPost = new ArrayList<>();
        ArrayList<Integer> lisEndPre = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lisEnd = new ArrayList<>();
        ArrayList<ArrayList<Integer>> relis = new ArrayList<>();
        ArrayList<ArrayList<Integer>> end = new ArrayList<>();
        ReformSimphon re=new ReformSimphon();
        // 按行读取字符串
        String str;
        String[][] stk = new String[100][2];
        int i = 0;
        try {
            InputStreamReader input = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(input);

            while ((str = bf.readLine()) != null) {
                stk[i] = str.split(":");
                i++;
            }
            input.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < i; j++) {
            String[] v1 = stk[j][1].split(",");
            Post.add(reform(v1));
        }
        for (int j = 0; j < i; j++) {
            String[] v2 = stk[j][2].split(",");
            Pre.add(reform(v2));
        }
        String[] t=new String[i];
        for (int c=0;c<i;c++){
            t[c]=Integer.toString(c);
        }

        for (int n = 1; n < 20; n++) {
            List<String> lis = combine.combine(t, n);
            int m = combine.getSize();
            for (int m1 = 0; m1 < m; m1++) {
                    String[] s = lis.get(m1).split(" ");
                        /*
                        r存放的是nn组合的单个n组合，一个组合有n个元素
                         */

                    ArrayList<Integer> r = reform(s);

                    for (int n1 = 0; n1 < n; n1++) {
                            /*
                            lisoverPost存放的是前置子集的集合[[][][][][]]
                             */
                        lisEndPost.addAll(Post.get(r.get(n1)));
                        lisEndPre.addAll(Pre.get(r.get(n1)));
                    }
                    ArrayList<Integer> Pos = ReduceRe(lisEndPost);
                    ArrayList<Integer> Pr = ReduceRe(lisEndPre);
                    if (airy.isSubset(Pr,Pos) == true) {

                        lisEnd.add(r);
                    }
                    lisEndPost.clear();
                    lisEndPre.clear();

            }

        }

        si=lisEnd.size();
        for (int zi=0;zi<si;zi++){
            for (int ki=0;ki<si;ki++){
                if (airy2.isSubset(lisEnd.get(zi),lisEnd.get(ki))) {
                    break;
                }
                if (ki==si-1){
                    relis.add(lisEnd.get(zi));
                }
            }
        }
        for (int r1=0;r1<relis.size();r1++){
            for (int r2=0;r2<relis.get(r1).size();r2++){
                lisEndPost.addAll(Post.get(relis.get(r1).get(r2)));
                lisEndPre.addAll(Pre.get(relis.get(r1).get(r2)));
            }

            if (lisEndPost.size()==lisEndPre.size()) {
                if (lisEndPost.containsAll(lisEndPre)) {
                    end.add(relis.get(r1));
                }
            }

            lisEndPost.clear();
            lisEndPre.clear();
        }
        relis.removeAll(end);

        ArrayList<ArrayList<Integer>> r = re.reform(relis);
        System.out.println(r);
        System.out.println(r.size());


    }

    static ArrayList<Integer> reform(String[] s) {
        ArrayList<Integer> a = new ArrayList<>();

        if (s.length > 1) {
            for (int i = 0; i < s.length; i++) {
                a.add(Integer.parseInt(s[i]));
            }
            return a;
        } else {
            a.add(Integer.parseInt(s[0]));
            return a;
        }
    }

    static ArrayList<Integer> ReduceRe(ArrayList<Integer> a) {
        Set set = new HashSet();
        ArrayList<Integer> newList = new ArrayList();
        for (int cd : a) {
            if (set.add(cd)) {
                newList.add(cd);
            }

        }
        return newList;

    }
}