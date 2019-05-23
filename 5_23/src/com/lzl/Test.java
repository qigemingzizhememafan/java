package com.lzl;
// 选择排序：直接选择排序、堆排序
// 插入排序：普通插入排序、希尔排序
// 冒泡排序
// 快速排序 (***)
// 归并排序 (***)
public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 6, 3, 2, -2, 0, 3};
//        heapSort(array);
//        selectSort(array);
//        bubble1(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "、");
        }
    }

    /*
     *  插入排序（减治排序。每次使一张变得有序）
     *  如打扑克牌，从无序的牌中每次拿一张放到有序的手中的牌里
     *  step1:在有序部分，查找合适的位置
     *         1. 遍历查找
     *             从后往前、从前往后
     *             当数组本身为有序升序时，从后往前时间复杂度为O(1)，从前往后为O(n)
     *  step2:把待插入的数插入到合适的下标处
     *          2. 顺序表，给定pos做插入，把pos之后的数都往后挪一下
     **/
// 先找到合适的位置，再做插入
    public static void insertSort(int[] array) {
        // 每次处理一个数
        for (int i = 0; i < array.length; i++) {
            // 有序部分 [0,i)
            // 无序部分[i,array.length]
            int j;
            // 在有序区间，从后往前遍历找合适的位置
            for (j = i - 1; j >= 0 && array[i] < array[j]; j--) {

            }
            // 找到合适的位置了，做插入
            int key = array[i];
            for (int k = i; k > j + 1; k--) {
                array[k] = array[k - 1];
            }
            array[j + 1] = key;
        }
    }

    //  找到合适位置的同时，做插入
    public static void insertSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }

    //  二分插入排序
    public static void insertSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            // 在有序部分[0.i)做二分查找
            int left = 0;
            int right = i;
            while (left < right) { //当left == right，就找到了
                int mid = left + (right - left) / 2;
                if (key == array[mid]) {
                    // 为了考虑稳定性，与mid后的再比较，mid后的数有可能都是相等的
                    left = mid + 1;
                } else if (key < array[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int pos = left;
            for (int k = i; k > pos; k--) {
                array[k] = array[k - 1];
            }
            array[pos] = key;
        }
    }

    //  希尔排序
    private static void insertWithGap(int[] array, int gap) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - gap;
            for (; j >= 0 && key < array[j]; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length;
        while (true) {
            // gap = gap / 2;
            gap = (gap / 3) + 1;
            insertWithGap(array, gap);
            if (gap == 1) {
                break;
            }
        }
    }


    /*
     *  选择排序
     **/
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selectSort(int[] array) {
        // 每次选一个最小的数放在有序部分的最开始
        for (int i = 0; i < array.length; i++) {
            // 有序 [0,i)
            // 无序[i,array.length]
            int minindex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minindex]) {
                    minindex = j;
                }
            }
            swap(array, minindex, i);
        }
    }

    /*
     *  堆排序
     *  step1：建大堆
     *         从最后一个非叶子节点的下标到根做向下调整
     *         [(array.length - 2)/ 2 ,0]
     *  step2：
     **/
    private static void heapify(int[] array, int size, int index) {
        // 1. 判断 index 是不是叶子节点
        while (2 * index + 1 < size) {
            // 2. 找到最大的孩子的下标
            int maxindex = 2 * index + 1;
            if (maxindex + 1 < size && array[maxindex + 1] > array[maxindex]) {
                maxindex = 2 * index + 1 + 1;
            }
            // 3. 判断最大的孩子和根的值
            if (array[index] < array[maxindex]) {
                swap(array, index, maxindex);
                index = maxindex;
            } else {
                // 4. 根的值比较大，直接结束
                //    不交换，也不继续向下调整
                break;
            }
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            // 向下调整
            heapify(array, array.length, i);
        }
    }

    public static void heapSort(int[] array) {
        // 建堆  大堆
        createHeap(array);
        // 减治处理
        for (int i = 0; i < array.length; i++) {
            // 无序 [0，length-i-1]
            // 有序[length - i,length)
            swap(array, 0, array.length - 1 - i);
            heapify(array, array.length - 1 - i, 0);
        }
    }

    /*
     *   冒泡排序
     **/
    public static void bubbleSort(int[] array) {
        boolean isSort = true; // 优化条件，判断是否发生过交换
        for (int i = 0; i < array.length; i++) {
            // 最小的数冒泡到最前面(从后往前冒泡)、把最大的数冒泡到最后面
            // 有序[0,i)
            // 无序[i,array.length]
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }
}

//    /*
//    * 快速排序
//    * */
//    private static void quickSortInner(int[] array,int left,int right){
//        // 直到 size == 1 || size == 0
//        if(left == right){
//            // size == 1
//            return;
//        }
//        if(left > right){
//            // size == 0
//            // 此时left = 0，right = array.length -1 = -1
//            return;
//        }
//        // 要排序的区间是array[left，right]
//        // 1. 找基准值，array[right]
//        // 2. 遍历整个区间，把区间分成三部分
//        int pivotIndex = parition(array,left,right);
//        // 比基准值小的 [left，pivotIndex-1]
//        // 基准值 pivotIndex
//        //　比基准值大的[pivotIndex+1,right]
//        // 3. 分治算法
//        // 处理比基准值小的区间
//        quickSortInner(array,left,pivotIndex-1);
//        //　处理比基准值大的区间
//        quickSortInner(array,pivotIndex+1,right);
//    }
//    public static void quickSort(int[] array){
//        quickSortInner(array,0,array.length-1);
//    }
//}
//
