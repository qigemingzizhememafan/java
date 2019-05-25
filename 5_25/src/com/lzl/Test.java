package com.lzl;

public class Test {
    // 交换两个数
    private static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // 堆排序
    public static  void heapSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            createMaxHeap(array, array.length - 1 - i);
            swap(array, 0, array.length-1-i);
        }
    }
    public static void createMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex-1)/2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 若当前节点的右子节点存在
                if (biggerIndex + 1 <= lastIndex) {
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换两者的值
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    // 选择排序--升序
    public static void selectSort(int[] array){
        // 有序部分[0,i)
        // 无序部分[i,array,length)
        for(int i = 0; i < array.length;i++){
            for(int j = i+1; j < array.length; j++){
                int min = i; //设置最小值的下标
                if(array[i] > array[j]){
                    min = j;
                }
                swap(array,i,min);
            }
        }
    }

    // 插入排序--升序
    public static void insertSort(int[] array){
        // 有序[0,i)
        // 无序[i,array.length)
        for(int i = 0; i < array.length; i++){
            // 查找合适的插入位置
            // 停止条件是J走到最头了或者J大于等于某个i了
            for(int j = i+1; array[i] > array[j] && j >= 0; j--){
                // 插入
                int pos = j+1;
                for(int k = array.length-1; k > pos; k--){
                    array[k] = array[k-1];
                }
            }
        }
    }

    // 快速排序--升序
    // Hover法
    private static int partion(int[] array, int left, int right){
        int begin = left;
        int end = right;
        while(begin < end){
            while(begin < right && array[begin] <= array[right]){
                begin++;
            }
            while(begin< right && array[right] >= array[right]){
                end--;
            }
            swap(array,begin,end);
        }
        swap(array,begin,right);
        return begin;
    }
    //　挖坑法
    private static int partion1(int[] array,int left,int right){
        int begin = left;
        int end = right;
        int pivort = array[right];
        while(begin < end){
            while(begin < end && array[begin] < pivort){
                begin++;
            }
            array[end] = array[begin];
            while(begin < right && array[right] > pivort){
                end--;
            }
            array[begin] = array[end];
        }
        array[begin] = pivort;
        return begin;
    }
    // 前后下标法
    private static int partion2(int[] array,int left,int right){
        int div = left;
        int i = left;
        while(i <= right){
            if(array[i] > array[right]){
                swap(array,div,i);
                div++;
                i++;
            }else{
                i++;
            }
        }
        swap(array,div,right);
        return div;
    }
    public static void quickSort(int[] array,int left,int right){
        // size == 1
        if(left == right){
            return;
        }
        // size == 0
        if(left < right){
            return;
        }
        int stand = partion(array,left,right);
        quickSort(array,0,stand-1);
        quickSort(array,stand+1,right);
    }
    private static void quick(int[] array) {
        if(array.length>0){
            quickSort(array,0,array.length-1);
        }
    }
    public static void main(String[] args) {
        int[] array = {9,5,-1,10,0,2,7,3,8,6};
//        selectSort(array);
//        quick(array);
        heapSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+"、");
        }
    }
}

