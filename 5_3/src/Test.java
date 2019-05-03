import java.util.Arrays;

public class Test {
//import java.util.Arrays;
//    class BubbleSort1 {
//        public static void main(String[] args) {
//            int[] arr ={9,8,7,6,5};
//            sort(arr);
//
//        }
//        public static void sort(int[] arr){
//            int len =arr.length;
//            for(int j=0;j<len-1;j++){
//                for(int i=0;i<len-1;i++){
//                    if(arr[i]>arr[i+1]){
//                        int temp = arr[i];
//                        arr[i] =arr[i+1];
//                        arr[i+1] =temp;
//                    }
//                    System.out.println(Arrays.toString(arr));
//                }
//            }
//        }
//        public static void sortSecond(int[] arr){
//            for(int i=0;i<arr.length-1;i++){
//                if(arr[i]>arr[i+1]){
//                    int temp = arr[i];
//                    arr[i] =arr[i+1];
//                    arr[i+1] =temp;
//                }
//                System.out.println(Arrays.toString(arr));
//            }
//            for(int i=0;i<arr.length-1;i++){
//                if(arr[i]>arr[i+1]){
//                    int temp = arr[i];
//                    arr[i] =arr[i+1];
//                    arr[i+1] =temp;
//                }
//                System.out.println(Arrays.toString(arr));
//            }
//            for(int i=0;i<arr.length-1;i++){
//                if(arr[i]>arr[i+1]){
//                    int temp = arr[i];
//                    arr[i] =arr[i+1];
//                    arr[i+1] =temp;
//                }
//                System.out.println(Arrays.toString(arr));
//            }
//            for(int i=0;i<arr.length-1;i++){
//                if(arr[i]>arr[i+1]){
//                    int temp = arr[i];
//                    arr[i] =arr[i+1];
//                    arr[i+1] =temp;
//                }
//                System.out.println(Arrays.toString(arr));
//            }
//
//        }
//        public static void sortFirst(int[] arr){
//            for(int i=0;i<arr.length-1;i++){
//                if(arr[i]>arr[i+1]){
//                    int temp = arr[i];
//                    arr[i] =arr[i+1];
//                    arr[i+1] =temp;
//                }
//                System.out.println(Arrays.toString(arr));
//            }
//		int i=0;
//		if(arr[i]>arr[i+1]){
//			int temp = arr[i];
//			arr[i] =arr[i+1];
//			arr[i+1] =temp;
//		}
//		System.out.println(Arrays.toString(arr));
//		i++;
//		if(arr[i]>arr[i+1]){
//			int temp = arr[i];
//			arr[i] =arr[i+1];
//			arr[i+1] =temp;
//		}
//		System.out.println(Arrays.toString(arr));
//
//		i++;
//		if(arr[i]>arr[i+1]){
//			int temp = arr[i];
//			arr[i] =arr[i+1];
//			arr[i+1] =temp;
//		}
//		System.out.println(Arrays.toString(arr));
//
//
//		i++;
//		if(arr[i]>arr[i+1]){
//			int temp = arr[i];
//			arr[i] =arr[i+1];
//			arr[i+1] =temp;
//		}
//		System.out.println(Arrays.toString(arr));
//
//
//        }
//
//    }
//
//}

//    private Node first;
//    private Node last;
//
//    private int size;
//
//    public void add(Object obj) {
//        Node n = new Node();
//
//        if (first == null) {
//            n.setPrevious(null);
//            n.setObj(obj);
//            n.setNext(null);
//
//            first = n;
//            last = n;
//        } else {
//            n.setPrevious(last);
//            n.setObj(obj);
//            n.setNext(null);
//
//            last.setNext(n);
//
//            last = n;
//        }
//        size++;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    private void rangeCheck(int index) {
//        if (index < 0 || index >= size) {
//            try {
//                throw new Exception();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public Object get(int index) {   //2
//        rangeCheck(index);
//
//        // 0 1 2 3 4
//        Node temp = node(index);
//        if (temp != null) {
//            return temp.obj;
//        }
//        return null;
//    }
//
//    public Node node(int index) {
//        Node temp = null;
//        if (first != null) {
//            if (index < (size >> 1)) {
//                temp = first;
//                for (int i = 0; i < index; i++) {
//                    temp = temp.next;
//                }
//            } else {
//                temp = last;
//                for (int i = size - 1; i > index; i--) {
//                    temp = temp.previous;
//                }
//            }
//
//        }
////		LinkedList l;
//        return temp;
//    }
//
//
//    public void remove(int index) {
//        Node temp = node(index);
//
//        if (temp != null) {
//            Node up = temp.previous;
//            Node down = temp.next;
//            up.next = down;
//            down.previous = up;
//            size--;
//        }
//
//    }
//
//    public void add(int index, Object obj) {
//        Node temp = node(index);
//
//        Node newNode = new Node();
//        newNode.obj = obj;
//
//        if (temp != null) {
//            Node up = temp.previous;
//            up.next = newNode;
//            newNode.previous = up;
//
//            newNode.next = temp;
//            temp.previous = newNode;
//
//            size++;
//        }
//    }
//
//
