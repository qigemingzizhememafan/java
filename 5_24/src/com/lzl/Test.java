package com.lzl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
// ***************************************************Day01**********************************************
//  1.1 利用StringBuffer的reverse，手动实现将b插入a
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入两个字符串");
//        String stra = scanner.nextLine(); // 被插入的字符串
//        String strb = scanner.nextLine(); // 要插入的字符串
//        scanner.close();
//        char[] data1 = stra.toCharArray();
//        int count = 0;  // 能构成回文串的次数
//        for (int i = 0; i <= stra.length(); i++) { // 有 stra.length+1 种插入位置
//            StringBuffer sb = new StringBuffer();
//            sb.append(data1, 0, i);
//            sb.append(strb);
//            sb.append(data1, i, stra.length() - i);
//            String sb1 = sb.toString();
//            if (sb.reverse().toString().equals(sb1)) {
//                count++;
//            }
//        }
//        System.out.println(count);

// 1.2 利用StringBuffer的insert，手动实现判断回文
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入两个字符串");
//        String a = scanner.nextLine();
//        String b = scanner.nextLine();
//        scanner.close();
//        int count = 0;
//        for(int i = 0; i <= a.length(); i++){
//            StringBuffer sb = new StringBuffer(a);
//            sb.insert(i,b);
//            StringBuffer reversed = new StringBuffer(sb);
//            if(reversed.reverse().().equals(sb.toString())){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//    public static boolean isHuiwen(String a){
//        char[] data1 = a.toCharArray();
//        int i = 0;
//        int j = a.length()-1;
//        while(i < j){
//            if(data1[i] != data1[j]){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
    }
}
