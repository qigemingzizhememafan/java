package com.Sort;
import java.util.ArrayList;
import java.util.Stack;

public class Sort1 {
    //快速排序
    public static void quickSort(int array[],int left,int right){
        // 数组只有一个元素，即已经有序
        if(left == right){
            return;
        }
        // 数组没有元素,left = 0,right = array.length-1 = -1
        if(left > right){
            return;
        }
        // 1,找基准值
        // 2,把数组分成三部分
        int p = partion(array,left,right);
        quickSort(array,left, p-1);
        quickSort(array,p+1,right);
    }
    /*
     * Hover法
     * 选择两个下标begin，end位于left，right处
     * 从begin下标处开始和基准值比较，小于基准值，begin++，直到大于基准值，停下
     * 接着从end处下标和基准值比较，大于基准值，end--，直到小于基准值，停下
     * 交换begin和end，继续循环上述部分
     * 当begin == end ，找到了基准值的位置
     * 交换begin和right位置的元素
     * */
    // Hover法
    public static int partion(int[] array,int left,int right){
        // 选基准值
        int parviot = array[right];
        int begin = left;
        int end = right;
        while(begin < end){
            while(begin < end && array[begin] < parviot){
                begin++;
            }
            while(begin < end && array[end] >= parviot){
                end--;
            }
            swap(array,begin,end);
        }
        swap(array,begin,right);
        return begin;
    }
    // 交换两数
    public static void swap(int array[],int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7,0,9,3,1,5,10,50,-1};
        quickSort(array,0,array.length-1);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+"、");
        }
    }
}
