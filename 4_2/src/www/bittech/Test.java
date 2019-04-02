package www.bittech;

import javafx.scene.chart.BubbleChart;

import java.util.*;

import static netscape.security.Privilege.add;

//public class Test {
//    public  int i;
//    public static void swap(int a,int b){
//        int temp = a;
//        a = b;
//        b = temp;
//    }
//    public static void BubbleSort(int[] arr){
//        boolean flag = true;
//        for(int len = arr.length; len > 0 ; len--){
//            for(int i = 0; i < len ;i++){
//                if(arr[i] > arr[i+1]){
//                    swap(arr[i],arr[i+1]);
//                    flag = false;
//                }
//            }
//            if(flag == true){
//                break;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr = new int[]{1,0,5,2,6,1};
//        BubbleSort(arr);
//    }
//}


class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        } else if(n == 2) {
            return "11";
        }
        String lastResult = countAndSay(n-1);
        String result = "";
        int count = 1;
        int j = 0;
        for (int i = 1; i < lastResult.length(); i++) {
            if(lastResult.charAt(j) == lastResult.charAt(i)) {
                count ++;
            } else {
                result += count + "" + lastResult.charAt(j);
                count = 1;
                j = i;
            }
            if(i == lastResult.length() - 1) {
                result+= count + "" + lastResult.charAt(i);
            }
        }

        return result;
    }
}
public class Test{
    public static void main(String[] args) {
    Solution solution  = new Solution();
        System.out.println(solution.countAndSay(6));
    }
}
//class Solution{
//    public String CountAndSay(int n){
//        if(n == 1){
//            return "1";
//        }else if( n == 2){
//            return "11";
//        }
//        String lastresult = CountAndSay(n-1);
//        String result = "";
//        int count = 1;
//        int j = 0;
//        for(int i = 0; i < lastresult.length(); i++){
//            if(lastresult.charAt(j) == lastresult.charAt(i)){
//                count++;
//            }else{
//                result += count+""+lastresult.charAt(j);
//            }
//            if( i == lastresult.length()-1){
//                result += count+""+lastresult.charAt(i);
//            }
//        }
//        return result;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.CountAndSay(6));
//    }
//}
//class Solution {
//    public String countAndSay(int n) {
//        if(n==1) return "1";
//        StringBuilder str = new StringBuilder();
//        str.append("1");
//        //到n 只需遍历n-1 次即可
//        for(int i =1;i<n;i++) {
//            char temp=str.charAt(0);
//            int count =0;
//            StringBuilder sb = new StringBuilder();
//            for(int j=0;j<str.length();j++) {
//                //当字符不相等时 或者遍历完字符时
//                if(str.charAt(j)!=temp ) {
//                    sb.append(count);
//                    sb.append(temp);
//                    //计数归零
//                    temp = str.charAt(j);
//                    count = 1;
//                }else {
//                    count++;
//                }
//            }
//            //最后遍历到字符串结尾的结果添加到字符串中
//            sb.append(count);
//            sb.append(temp);
//            str=sb;
//        }
//        return str.toString();
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.countAndSay(6));
//    }
//
//interface Add{
//    void ad(int x,int y);
//}
//interface ac{
//    void ac(int x,int y);
//}
//public class Test{
//    public static void main(String[] args) {
//        Add add = (x,y) -> System.out.println(x+y);
//        Add add1 = (x,y) ->System.out.println(x+y+10);
//        ac ac = (x,y) -> System.out.println(x-y);
//        add.ad(1,1);
//        ac.ac(2,0);
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        Collections.addAll(list,"A","B","C","D","A","B");
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            String str = iterator.next();
//            if(str.equals("B")){
//                list.remove("B");
//                continue;
//            }
//            System.out.println(str);
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Map<Integer, String> map = new Hashtable<>();
//        map.put(1, "Hello");
//        map.put(3, "java");
//        map.put(2, "bit");
//        map.put(null, null);
//        map.put(null, null);
//        map.put(4, null);
//        // 取得当前Map中的所有Key值
//        Set<Integer> keySet = map.keySet();
//        Iterator<Integer> iterator = keySet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        for(Integer i:keySet){
//            System.out.println(map.get(i));
//        }
//    }
//}
//        // 取得所有Value值
//        List<String> list = (List<String>) map.values();
//        Iterator<String> iterator1 = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator1.next());
//        }
//    }
//}
//        System.out.println(map.get(1));  //输出Hello
//        System.out.println(map.get(99)); //输出null
