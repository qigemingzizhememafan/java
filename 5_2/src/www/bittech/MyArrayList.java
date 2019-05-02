package www.bittech;

public class MyArrayList {
    private Object[] elementData;
    private int size;
    public MyArrayList(){
        this(10);
    }
    // 数组初始化容量
    public MyArrayList(int initialCapacity){
        if(initialCapacity < 0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 将新数组声明为elementData
        elementData = new Object[initialCapacity];
    }

    // 数组容量
    public int size(){
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向数组添加元素
    public void add(Object obj){
        // 当前数组容量不够，进行扩容
        if(size == elementData.length){
            // 初始化新数组容量
            Object[] newArray = new Object[size*2];
            // 将原数组中的元素移到新数组中
            for(int i = 0; i < size; i++){
                newArray[i] = elementData[i];
            }
            //System.arraycopy(elementData,0,newArray,0,size); 这样也可直接将原数组内容复制过来
        }
        elementData[size] = obj;
        size++;
    }

    // 获取数组中元素
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    // 删除指定下标的元素
    public void remove(int index){
        rangeCheck(index);
        int numMoved = size - index - 1; // 需要改变位置的元素个数
        if (numMoved > 0){
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        }
        elementData[--size] = null;
    }


    // 下标检查
    private void rangeCheck(int index){
        if(index < 0 || index >= size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(5);
        myArrayList.add(333);
        myArrayList.add("hello world");
        myArrayList.add("hello java");
        System.out.println(myArrayList.size);
        System.out.println(myArrayList.get(1));
        System.out.println(myArrayList.get(19));

    }
}
