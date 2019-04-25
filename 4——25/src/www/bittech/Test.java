package www.bittech;
// 已知双亲   左孩子  2*parent+1   右孩子  2*parent+2
//已知孩子     双亲   (child-1)/2

public class Test {
// 堆化1---大堆,O(log(n))
//    private static void heapify(int[] tree,int index){
//        // 1. 判断index是否为叶子节点
//        int left = 2*index+1;
//        if(left >= tree.length){
//            return;
//        }
//        // 2. 找出两个孩子中较大的孩子
//        // 无右孩子，左 为 大，max = left
//        // 有右孩子,左 > 右 ， max = left
//        //          左 < 右，max = right
//        int max = left;
//        int right = 2*index+2;
//        if(right < tree.length && tree[right] > tree[left]){
//            max = right;
//        }
//        // 3. 将较大的孩子与双亲比较
//        if(tree[index] >= tree[max]){
//            return;
//        }else{
//            // 交换
//            int tmp = tree[index];
//            tree[index] = tree[max];
//            tree[max] = tmp;
//            // 继续向下调整
//            heapify(tree,max);
//        }
//    }

// 堆化2----小堆
//    private static void adjustDown(int[] array,int index){
//        int min = 2*index+1;
//        while(min < array.length){
//            if(min+1 < array.length && array[min+1] < array[min]){
//                min = min+1;
//            }
//            if(array[index] <= array[min]){
//                break;
//            }else{
//                int t = array[index];
//                array[index] = array[min];
//                array[min] = t;
//                //继续调整
//                index = min;
//                min = 2*index +1;
//            }
//
//        }
//    }

//    建堆 --- O(n * log(n))
//    private static void createHeap(int[] array){
//        //从最后一个非叶子结点开始建堆
//        for(int i = (array.length-2)/2; i >= 0 ; i--){
//            heapify(array,i);
//        }
//    }

//    向上调整
//    private void adjustUp(int[] array,int size,int index){
//        int parent = (index-1)/2;
//        while(index > 0) {
//            if (array[parent] <= array[index]) {
//                int t = array[parent];
//                array[parent] = array[index];
//                array[index] = t;
//            }else{
//                break;
//            }
//            // 继续向上调整
//            index = parent;
//        }
//    }

    private static void selectSort(int[] array){

        // 有序部分[0,i)
        // 无序部分[i,array.length)
        // 总趟数
        for(int i = 0; i < array.length-1; i++) {
            int min = i;
            // 每一趟比较的次数
            for (int j = i+1; j < array.length; j++) {
                if (array[0] > array[j]) {
                    min = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,9,4,24,543,6,7,2};
        selectSort(arr);
        for(int arrs:arr){
            System.out.println(arrs);
        }
    }
}

//class Heap{
//    // 返回堆里的最值，即返回array[0]
//    //  返回堆里的最值，并删除最值，用数组最后一个值替代第一个值即可
//}