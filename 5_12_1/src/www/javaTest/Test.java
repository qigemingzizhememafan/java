package www.javaTest;
public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{5,3,7,5,1,0,2};
        selectSort(array);
//      insertSort(array);
//      midinsertSort(array);
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i]);
        }
    }

//    简单选择排序 -- 小的数字放在前面
    public static void selectSort(int[] array){
        //  有序部分 [0,i)
        //  无序部分(i,array.length)
        //  每趟使一个数有序
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int n=i; //最小数的索引
            for(int j=i+1;j < array.length;j++){
                if(array[j] < min){  //找出最小的数
                    min = array[j];
                    n = j;
                }
            }
            array[n] = array[i];
            array[i] = min;
        }
    }

//    交换两个数
public static void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
}

//   二分插入排序
//    public static void midinsertSort(int[] array){
//        // 排length趟序
//        for (int i = 0; i < array.length; i++) {
//            // 待插入的元素
//            int temp = array[i];
//            int left = 0;
//            int right = i-1;
//            int mid = 0;
//            // 定位所要插入的位置
//            while (left <= right) {
//                mid = (left+right)/2;
//                if (temp < array[mid]) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            // 插入到定位好的位置
//            for (int j = i-1; j >= left; j--) {
//                array[j+1] = array[j];
//            }
//            if (left != i) {
//                array[left] = temp;
//            }
//        }
//    }

//    直接插入排序，小的在前面
//    public static void insertSort(int[] array){
//        // 排序的趟数
//        for(int i = 0;i < array.length; i++){
//            // 待插入的元素
//            int temp = array[i];
//            // 已排序好的元素的最后一个
//            int j = i-1;
//            // 定位并插入
//            for(;j >= 0 && array[j] > temp;j--){
//                    array[j+1] = array[j];
//            }
//            array[j+1] = temp;
//            }
//        }
}



