package com.lzl.oj;
import java.util.*;
public class Main{

    /*
    * d 16_2 统计同成绩学生人数
    * */
    public static void main1(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] data = new int[n];
            for(int i = 0; i < n; i++){
                data[i] = scanner.nextInt();
            }
            int target = scanner.nextInt();
            int count = 0;
            for(int i = 0; i < data.length; i++){
                if(data[i] == target){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}


