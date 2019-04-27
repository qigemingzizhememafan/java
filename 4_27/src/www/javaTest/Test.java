package www.javaTest;

import java.util.Arrays;

public class Test {
    // 直接插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 待插入元素
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                // 将大于temp的往后移动一位
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
    }

    // 二分插入排序
    public static void twoInsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }
            if (left != i) {
                array[left] = temp;
            }
        }
    }

    //选择排序
    public static void selectSort(int[] a) {
        int min;
        for(int i = 0; i < a.length; i++){
            min = i;
            for(int j = i + 1; j < a.length; j++){//找到最小值下标
                if(a[j] < a[min]){
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }
    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }


     // 堆排序
    public static  void heapSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            createMaxHeap(a, a.length - 1 - i);
            swap(a, 0, a.length - 1 - i);
        }
    }

    public static void createMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
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

    // 冒泡排序
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                // 每遍历一次都把最大的数沉到最底下去了
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }


    // 快速排序 -- Hover
    private static int parition(int[] array,int left,int right) {
        int begin = left;
        int end = right;
        while(begin < end){
            while (begin < end && array[begin] <= array[right]) {
                begin++;
            }
            while (begin < end && array[end] >= array[right]) {
                end--;
            }
            swap(array,begin,end);
        }
        swap(array,begin,end);
        return begin;
    }

    // 快速排序--挖坑法
    private static int parition2(int[] array,int left,int right) {
        int begin = left;
        int end = right;
        int pivot = array[right];
        while(begin < end){
        while (begin < end && array[begin] <= pivot) {
            begin++;
        }
        // begin>pivit,坑内的值发生变化
        array[end] = array[begin];
        while (begin < end && array[end] >= pivot) {
            end--;
        }
        // 坑内再次发生变化
        array[begin] = array[end];
    }
        array[begin] = pivot;
        return begin;
    }

    // 快速排序 -- 前后坐标
    // d下标之前的都小于基准值，d到i之间的都大于基准值
    private static int parition3(int[] array,int left,int right){
        int d = left;
        for(int i = 0; i < right; i++){
            if(array[i] < array[right]){
                swap(array,d,right);
                d++;
            }
        }
        swap(array,d,right);
        return d;
    }

    // 归并排序 --- 递归
    public static void mergeSort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(array, low, mid);
            // 右边
            mergeSort(array, mid + 1, high);
            // 左右归并
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左
        int j = mid + 1;// 右
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 把新数组中的数赋值到array数组
        for (int k1 = 0; k1 < temp.length; k1++) {
            array[low + k1] = temp[k1];
        }
    }
        // 归并排序 --- 非递归

    public static void main(String[] args) {
        int[] array = new int[]{3,1,6,7,2,0,9};
//        selectSort(array);
//        insertSort(array);
//        twoInsertSort(array);
//        heapSort(array);
//        bubbleSort(array);
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}