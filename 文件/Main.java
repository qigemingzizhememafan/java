package com.lzl;
import java.util.*;
public class Main{
    /**
     * d36_1 字母统计
     * 将输入的字符串先转为字符数组
     * 建立结果数组，遍历字符数组，
     * 将每个字符存入结果数组中的合适下标处
     * 有相同的++即可，最后输出
     */
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            char[] data = s.toCharArray();
            int[] res = new int[26];
            for(int i = 0; i < s.length(); i++){
                if(data[i] >= 'A' && data[i] <= 'Z'){
                    res[data[i]-'A']++;
                }
            }
            for(int i = 0; i < 26;i++){
                System.out.println((char)('A'+i)+":"+res[i]);
            }
        }
    }
}