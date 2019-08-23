import com.sun.javafx.collections.MappingChange;

import java.util.List;
import java.util.Scanner;

// m进制数转为n进制
//public class tenTest {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int m = sc.nextInt();
//            int n = sc.nextInt();
//            if(m > 0){
//                change(m, n);
//            }
//        }
//    }
//
//    private static void change(int m,int n){
//        Stack<Integer> stack = new Stack();
//      if(m == 10){
//          System.out.println(m);
//          return;
//      }
//      while(m != 0){
//          if(m % n < 10){
//              stack.push(m%n + '0');
//          }else{
//              stack.push(m%n - 10 + 'A');
//          }
//          m = m/n;
//      }
//    }
//}


//
/// K个一组翻转链表
// * Definition for singly-linked list.
// class Node { int val;
//     Node next;
//     Node(int x) { val = x; }
//
//  }
//
//class Solution {
//    public Node reverseKGroup(Node head, int k) {
//        int len = 0;
//        Node tmp = head;
//        //计算链表长度
//        while(tmp != null){
//            len++;
//            tmp = tmp.next;
//        }
//        // 分成len组
//        len /= k;
//        //当没有要反转链表的时候直接返回
//        if(len==0){
//            return head;
//        }
//
//        Node begin = head;
//        Node end = begin;
//        // 对每组进行逆序
//        for(int i = 0; i < len; i++){
//            //newlist表示分离出来的链表
//            Node res = null;
//            //newhead表示分离出来链表的头
//            Node newhead = begin;
//            int count = k;
//            //反转分离出来的链表
//            while(count > 0){
//                tmp = begin;
//                begin = begin.next;
//                tmp.next = res;
//                res = tmp;
//                count--;
//            }
//            //只有当第一次反转链表时不用将首尾相连，因为只有头，所以只需要将链表原本的头
//            //更新即可，在后面的链表反转中，则需要将分离出来的链表与之前的链表首尾相连
//            if(i == 0){
//                head = res;
//            }else{
//                end.next = res;
//                end = newhead;
//            }
//        }
//        //链接链表剩余的部分
//        while(begin != null){
//            end.next = begin;
//        }
//        //返回头节点
//        return head;
//    }
//}

//
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        char[] ch = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
//        StringBuffer sb = new StringBuffer();
//        if(m < 0) {
//            m = -m;
//        }
//        while(m >= n) {
//            sb.insert(0, ch[m % n]);
//            m /= n;
//        }
//        sb.insert(0, ch[m]);
//        System.out.println(sb.toString());
//    }
//}


// 最大公共子串长度
//public class tenTest{
//    public static String maxString(String s1, String s2) {
//        String res = "";
//        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
//            return res;
//        int max = 0;
//        int l1 = s1.length();
//        int l2 = s2.length();
//        int[][] dp = new int[l1][l2]; // 定义一个二维数组记录最大公共子串的长度
//        // 计算到s1的第i个字符和s2的第j个字符为止的最大公共子串长度
//        for (int i = 0; i < l1; i++) {
//            for (int j = 0; j < l2; j++) {
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    if (i == 0 || j == 0){
//                        dp[i][j] = 1;
//                    } else {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
//                    }
//                    // 记录最大长度和子串
//                    if (dp[i][j] > max) {
//                        max = dp[i][j];
//                        res = s1.substring(i - dp[i][j] + 1, i + 1);
//                    }
//                }
//            }
//        }
//        return res;
//    }
//}


//public class tenTest{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//            String res = null;
//            int longer = Math.max(s1.length(), s2.length());
//            String l = s1;
//            String s = s2;
//            if(longer == s1.length()){
//                l = s1;
//                s = s2;
//            }else{
//                l = s2;
//                s = s1;
//            }
//            int[][] dp = new int[s1.length()][s2.length()];
//            //   for(int i = 0; i < dp.length; i++){
//            //     dp[i][0] = 1;
//            //   dp[0][i] = 1;
//            //}
//            for(int i = 0; i < s.length(); i++){
//                int max = 0;
//                for(int j = 0;  j < l.length(); j++){
//                    if(s1.charAt(i) == s2.charAt(j)) {
//                        if (i == 0 || j == 0) {
//                            dp[i][j] = 1;
//                        } else {
//                            dp[i][j] = dp[i - 1][j - 1] + 1;
//                        }
//                        if (dp[i][j] > max) {
//                            max = dp[i][j];
//                            res = l.substring(i-dp[i][j]+1,i+1);
//                        }
//                    }
//                }
//            }
//        System.out.println(res);
//    }
//}



// 统计一个字符串中每个字符出现的次数
// 输出出现次数最多的那个字符
import java.util.*;
public class tenTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] a = s.toCharArray();
            Map<Character, Integer> map = new TreeMap();
            int[] res = new int[a.length];
            Character maxkey = null;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < a.length; i++) {
                if (map.containsKey(a[i])) {
                    map.put(a[i], map.get(a[i]) + 1);
                    if(map.get(a[i]) > max){
                        maxkey = a[i];
                        max = map.get(a[i]);
                    }
                } else {
                    map.put(a[i], 1);
                }
            }
//  1, 第一种输出，利用ketset迭代器
//        Set<Character> set = map.keySet();
//            Iterator iterator = set.iterator();
//            while(iterator.hasNext()){
//                Character key =  (Character) iterator.next();
//                System.out.print(key + ":");
//                System.out.println(map.get(key));
//            }
//            System.out.println("最大值");
//            System.out.println(maxkey + ":" + max);

//  2, 第二种，遍历取得map中的每一个key值
//            for(char c : map.keySet()){
//                System.out.println(c + ":" + map.get(c));
//            }
//            System.out.println("最大值");
//            System.out.println(maxkey + ":" + max);

//  3,第三种，entry
//            for(Map.Entry<Character,Integer> set : map.entrySet()){
//                System.out.print(set.getKey()+":");
//                System.out.println(set.getValue());
//            }
//            System.out.println("最大值");
//            System.out.println(maxkey + ":" + max);


//================================================================================================
//================================================================================================
// 输出出现次数最多的
   List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    //升序
                    return o1.getValue() - o2.getValue();
                    //降序
//                return o2.getValue()-o1.getValue();
                }
            });
            //输出
            ListPrint(list);
        }
    }
//
//    // 只输出字符串中出现次数最多的
//    // 若想输出全部的key，value把sout放在for循环里面即可
    public static void ListPrint(List<Map.Entry<Character,Integer>> list) {
        Map.Entry<Character, Integer> map = null;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
        }
        System.out.println(map.getKey() + ":" + map.getValue());
        }
    }














