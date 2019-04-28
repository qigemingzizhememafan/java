package www.bittech;
class MyThread implements Runnable{
    private int ticket = 100;
    @Override
    public void run(){ //三个线程可以同时进入run()方法和for循环
        for(int i = 0; i<100; i++){
            //同步代码块
            synchronized (this) {  //加锁操作，同一时刻只有一个线程进入同步代码块
                //--------------------------------------------------------------------
                if (ticket > 0) {
                    try {
                        //模拟网络延迟
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "张票");
                }
                //--------------------------------------------------------------------
            }
        }
    }
}
public class Test{
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread th1 = new Thread(mt,"黄牛A");
        Thread th2 = new Thread(mt,"黄牛B");
        Thread th3 = new Thread(mt,"黄牛c");
        th1.start();
        th2.start();
        th3.start();
    }
}

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Test {
//    /**
//     * 时间复杂度
//     * 最坏: O(n^2)       已经逆序
//     * 平均: O(n^2)
//     * 最好: O(n^2)       已经有序    （为什么要倒着找）
//     * 空间复杂度 O(1)
//     * 稳定性: 稳定
//     * @param array
//     */
//    public static void insertSort(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            // 有序 [0, i)
//            // 无序 [i, array.length)
//
//            // 1. 在有序区间遍历查找，从后往前
//            int j;
//            for (j = i - 1; j >= 0 && array[i] < array[j]; j--) {
//            }
//
//            // j + 1 就是要插入数据的下标
//            // 2. 插入数据，从后往前搬移数据
//            int pos = j + 1;
//            int key = array[i];
//            for (int k = i; k > pos; k--) {
//                array[k] = array[k - 1];
//            }
//
//            array[pos] = key;
//        }
//    }
//
//    // 重点
//    public static void insertSort2(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            int key = array[i];
//            int j = i - 1;
//            for (; j >= 0 && key < array[j]; j--) {
//                array[j + 1] = array[j];
//            }
//            array[j + 1] = key;
//        }
//    }
//
//    public static void insertSort3(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            int key = array[i];
//            // [0, i)
//            int left = 0;
//            int right = i;
//
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                if (key == array[mid]) {
//                    left = mid + 1;
//                } else if (key < array[mid]) {
//                    // [left, mid)
//                    // [left, right)
//                    right = mid;
//                } else {
//                    left = mid + 1;
//                }
//            }
//
//            int pos = left;
//            for (int k = i; k > pos; k--) {
//                array[k] = array[k - 1];
//            }
//            array[pos] = key;
//        }
//    }
//
//    private static void insertSortWithGap(int[] array, int gap) {
//        for (int i = 0; i < array.length; i++) {
//            int key = array[i];
//            int j = i - gap;
//            for (; j >= 0 && key < array[j]; j = j - gap) {
//                array[j + gap] = array[j];
//            }
//            array[j + gap] = key;
//        }
//    }
//
//    /**
//     * 时间复杂度
//     * 最好情况 O(n)
//     * 最坏情况 O(n^2)      概率变小了
//     * 平均情况 O(n^1.2-1.3)
//     * 空间复杂度
//     * O(1)
//     * 稳定性: 不稳定
//     * @param array
//     */
//    public static void shellSort(int[] array) {
//        int gap = array.length;
//        while (true) {
//            // gap = gap / 2;
//            gap = (gap / 3) + 1;
//
//            insertSortWithGap(array, gap);
//
//            if (gap == 1) {
//                break;
//            }
//        }
//    }
//
//    private static void swap(int[] array, int i, int j) {
//        int t = array[i];
//        array[i] = array[j];
//        array[j] = t;
//    }
//
//    // 选择排序
//    public static void selectSort(int[] array)
//    {
//        // 每次选择一个最小的放到无序部分的最开始位置
//        for (int i = 0; i < array.length; i++) {
//            // 有序 [0, i)
//            // 无序 [i, array.length)
//            int min = i;    // 记录最终最小数所在的下标
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] < array[min]) {
//                    min = j;
//                }
//            }
//
//            // 最终交换一次
//            swap(array, min, i);
//        }
//    }
//
//    private static void heapify(int[] array, int size, int index) {
//        // 1. 判断 index 是不是叶子
//        while (2 * index + 1 < size) {
//            // 2. 找到最大的孩子的下标
//            int max = 2 * index + 1;
//            if (max + 1 < size && array[max + 1] > array[max]) {
//                max = 2 * index + 2;
//            }
//
//            // 3. 判断最大的孩子和根的值
//            if (array[index] < array[max]) {
//                swap(array, index, max);
//
//                index = max;
//            } else {
//                // 4. 根的值比较大，可以直接结束了
//                // 不交换，也不继续往下走了
//                break;
//            }
//        }
//    }
//
//    private static void createHeap(int[] array) {
//        // [从最后一个非叶子结点的下标, 根] 向下调整
//        // [(array.length - 2) / 2, 0]
//
//        for (int i = (array.length - 2) / 2; i >= 0; i--) {
//            heapify(array, array.length, i);
//        }
//    }
//
//    // 堆排序
//    public static void heapSort(int[] array)
//    {
//        // 建堆   大堆
//        createHeap(array);
//
//        // 减治处理
//        for (int i = 0; i< array.length; i++) {
//            // 无序 [0, length - i - 1]
//            // 有序 [length - i, length)
//            // 最大的数在 [0], 最大的数应该放到的下标是
//            // [length - i  - 1]
//            swap(array, 0, array.length - 1 - i);
//            // 处理 [0] , 无序剩余部分满足堆的性质
//            // 无序 [0, length - i - 2]
//            // 有序 [length - i - 1, length)
//            // size 剩余无序部分的长度
//            heapify(array, array.length - 1 - i, 0);
//        }
//    }
//    // 冒泡排序
//    public static void bubbleSort(int[] array)
//    {
//        for (int i = 0; i < array.length; i++) {
//            boolean isSorted = true;
//            // 最小的数冒泡到最前面
//            // 有序 [0, i)
//            // 无序 [i, length)
//            // 要把最小的数冒泡到最开始，需要从后往前冒泡
//            for (int j = array.length - 1; j > i; j--) {
//                if (array[j] < array[j - 1]) {
//                    swap(array, j, j - 1);
//                    isSorted = false;
//                }
//            }
//
//            if (isSorted) {
//                break;
//            }
//        }
//    }
//
//    private static int partition1(int[] array, int left, int right) {
//        int begin = left;
//        int end = right;
//        int pivot = array[right];
//        while (begin < end) {
//            while (begin < end && array[begin] <= pivot) {
//                begin++;
//            }
//            // array[begin] > pivot
//            while (begin < end && array[end] >= pivot) {
//                end--;
//            }
//            // array[end] < pivot
//            swap(array, begin, end);
//        }
//        swap(array, begin, right);
//        return begin;
//    }
//
//    private static int partition2(int[] array, int left, int right) {
//        int begin = left;
//        int end = right;
//        int pivot = array[right];
//        while (begin < end) {
//            while (begin < end && array[begin] <= pivot) {
//                begin++;
//            }
//
//            array[end] = array[begin];
//            while (begin < end && array[end] >= pivot) {
//                end--;
//            }
//            array[begin] = array[end];
//        }
//        array[begin] = pivot;
//        return begin;
//    }
//
//    private static int partition3(int[] array, int left, int right) {
//        int d = left;
//        for (int i = left; i < right; i++) {
//            if (array[i] < array[right]) {
//                swap(array, d, i);
//                d++;
//            }
//        }
//
//        swap(array, d, right);
//        return d;
//    }
//
//    private static int sanShuQuZhong(int[] array, int left, int right) {
//        int mid = left + (right - left) / 2;
//        if (array[left] > array[right]) {
//            if (array[left] < array[mid]) {
//                return left;
//            } else if (array[mid] > array[right]) {
//                return mid;
//            } else {
//                return right;
//            }
//        } else {
//            if (array[right] < array[mid]) {
//                return right;
//            } else if (array[mid] > array[left]) {
//                return mid;
//            } else {
//                return left;
//            }
//        }
//    }
//
//    private static void quickSortInner(int[] array, int left, int right) {
//        // 直到 size == 1 || size == 0
//        if (left == right) {
//            // size == 1
//            return;
//        }
//
//        if (left > right) {
//            // size == 0
//            return;
//        }
//
//        // 要排序的区间是 array [left, right]
//        // 1. 找基准值，array[right];
//        int originIndex = sanShuQuZhong(array, left, right);
//        swap(array, originIndex, right);
//        // 2. 遍历整个区间，把区间分成三部分
//        int pivotIndex = partition3(array, left, right);
//        // 比基准值小的 [left, pivotIndex - 1]
//        // 比基准值的 [pivotIndex + 1, right]
//        // 3. 分治算法
//        // 处理比基准值小的区间
//        quickSortInner(array, left, pivotIndex - 1);
//        // 处理比基准值大的区间
//        quickSortInner(array, pivotIndex + 1, right);
//    }
//
//    public static void quickSort(int[] array) {
//        quickSortInner(array, 0, array.length - 1);
//    }
//
//    private static void merge(int[] array, int low, int mid, int high, int[] extra) {
//        int i = low;    // 遍历 array [low, mid)
//        int j = mid;    // 遍历 array [mid, high)
//        int x = 0;      // 遍历 extra
//
//        while (i < mid && j < high) {
//            if (array[i] <= array[j]) {
//                extra[x++] = array[i++];
//            } else {
//                extra[x++] = array[j++];
//            }
//        }
//
//        while (i < mid) {
//            extra[x++] = array[i++];
//        }
//
//        while (j < high) {
//            extra[x++] = array[j++];
//        }
//
//        for (int k = low; k < high; k++) {
//            array[k] = extra[k - low];
//        }
//    }
//
//    private static void mergeSortInner(int[] array, int low, int high, int[] extra) {
//        // array[low, high)
//        // [3, 4)
//        if (low == high - 1) {
//            return;
//        }
//
//        if (low >= high) {
//            return;
//        }
//
//        // 1. 平均切分
//        int mid = low + (high - low) / 2;
//        // [low, mid) + [mid, high)
//        // 2. 分治算法处理所有两个小区间
//        mergeSortInner(array, low, mid, extra);
//        mergeSortInner(array, mid, high, extra);
//
//        // 左右两个小区间已经有序了
//        merge(array, low, mid, high, extra);
//    }
//
//    public static void mergeSort(int[] array) {
//        int[] extra = new int[array.length];
//        mergeSortInner(array, 0, array.length, extra);
//    }
//
//    public static void mergeSortNorR(int[] array) {
//        int[] extra = new int[array.length];
//        for (int i = 1; i < array.length; i *= 2) {
//            for (int j = 0; j < array.length; j += 2 * i) {
//                int low = j;
//                int mid = low + i;
//                if (mid >= array.length) {
//                    continue;
//                }
//                int high = mid + i;
//                if (high > array.length) {
//                    high = array.length;
//                }
//
//                merge(array, low, mid, high, extra);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] array = { 9, 3, 1, 5, 2, 4, 3, 8, 7, 6 };
//        mergeSortNorR(array);
//        System.out.println(Arrays.toString(array));
//    }
//}

