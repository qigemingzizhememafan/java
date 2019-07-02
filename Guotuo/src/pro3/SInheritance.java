package pro3;
class A{
    int i,j;
    void showij(){
        System.out.println("i and j:" + i + " " + j);
    }
}

class B extends A{
    int k;

        void showk ()
        {
            System.out.println("k:" + k);
        }

    void sum(){
        System.out.println("i +j+k:" + (i + j + k));
    }
}

public class SInheritance {
    public static void main(String[] args) {
        A superOb = new A();
        B subOb = new B();
        System.out.println("Content of Superob:");
        superOb.showij();
        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;
        System.out.println("subOb:");
        subOb.showij();
        subOb.showk();
        subOb.sum();
    }
}
