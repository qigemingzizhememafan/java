package $GongChang;

/**
 * 简单工厂模式最大的优点就是工厂内有具体的逻辑去判断生成什么产品，将类的实例化交给了工厂，这样当
 * 我们需要什么产品只需要修改工厂的调用而不需要去修改客户端，对于客户端来说降低了与具体产品的依赖
 *
 * 工厂方法模式是简单工厂的扩展，工厂方法模式把原先简单工厂中的实现那个类的逻辑判断交给了客户端，
 * 如果像添加功能只需要修改客户和添加具体的功能，不用去修改之前的类。
 *
 * 抽象工厂模式进一步扩展了工厂方法模式，它把原先的工厂方法模式中只能有一个抽象产品不能添加产品族
 * 的缺点克服了，抽象工厂模式不仅仅遵循了OCP原则，而且可以添加更多产品(抽象产品),具体工厂也不仅仅
 * 可以生成单一产品，而是生成一组产品，抽象工厂也是声明一组产品，对应扩展更加灵活，但是要是扩展族
 * 系就会很笨重。
 */

/**
 * 简单工厂
 */
//interface IFruit{
//    void makeFruit();
//}
//
//class appleImpl implements IFruit{
//    @Override
//    public void makeFruit() {
//        System.out.println("苹果好了");
//    }
//}
//
//class orangeImpl implements IFruit{
//    @Override
//    public void makeFruit() {
//        System.out.println("橙子好了");
//    }
//}
//
//class mangoImpl implements IFruit{
//    @Override
//    public void makeFruit() {
//        System.out.println("芒果好了");
//    }
//}
//
//class fruitFactory{
//    public static IFruit getInstance(String type){
//        if(type.equals("apple")){
//            return new appleImpl();
//        }else if(type.equals("orange")){
//            return new orangeImpl();
//        }else if(type.equals("mango")){
//            return new mangoImpl();
//        }else{
//            return null;
//        }
//
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        fruitFactory fruitFactory = new fruitFactory();
//        IFruit i = fruitFactory.getInstance("appe");
//        i.makeFruit();
//    }
//}

/**
 *  反射改造简单工厂模式
 */
interface IFruit{
    void makeFruit();
}

class appleImpl implements IFruit{
    @Override
    public void makeFruit() {
        System.out.println("苹果好了");
    }
}

class orangeImpl implements IFruit{
    @Override
    public void makeFruit() {
        System.out.println("橙子好了");
    }
}

class mangoImpl implements IFruit{
    @Override
    public void makeFruit() {
        System.out.println("芒果好了");
    }
}
class fruitFactory{
    public static IFruit getInstance(String type) {
        IFruit iFruit = null;
        Class<?> cls = null;
        try {
            cls = Class.forName(type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            iFruit = (IFruit) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return iFruit;
    }
}
public class Test {
    public static void main(String[] args) {
        IFruit fruit = $GongChang.fruitFactory.getInstance("$GongChang.appleImpl");
        fruit.makeFruit();
    }
}

/**
 * 工厂方法模式
 */
//interface IFruit{
//    void print();
//}
//
//class appleImpl implements IFruit{
//    @Override
//    public void print() {
//        System.out.println("我是苹果");
//    }
//}
//
//class orangeImpl implements IFruit{
//    @Override
//    public void print() {
//        System.out.println("我是橙子");
//    }
//}
//
//interface fruitFactory{
//    IFruit get();
//}
//
//class appleFactory implements fruitFactory{
//    @Override
//    public IFruit get() {
//        return new appleImpl();
//    }
//}
//
//class orangeFactory implements fruitFactory{
//    @Override
//    public IFruit get() {
//        return new orangeImpl();
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        fruitFactory fruitFactory = new orangeFactory();
//        IFruit i = fruitFactory.get();
//        i.print();
//    }
//}

/**
 * 抽象工厂模式
 */
//interface IFruit{
//    void print();
//}
//
//class appleImpl implements IFruit{
//    @Override
//    public void print() {
//        System.out.println("我是苹果");
//    }
//}
//
//class orangeImpl implements IFruit{
//    @Override
//    public void print() {
//        System.out.println("我是橙子");
//    }
//}
//
//interface juice{
//    void print();
//}
//
//class appleJuice implements juice{
//    @Override
//    public void print() {
//        System.out.println("我是苹果汁");
//    }
//}
//
//class orangeJuice implements juice{
//    @Override
//    public void print() {
//        System.out.println("我是橙汁");
//    }
//}
//
//interface fruitFactory{
//    IFruit get();
//    juice print();
//}
//
//class appleFactory implements fruitFactory{
//    @Override
//    public IFruit get() {
//        return new appleImpl();
//    }
//    @Override
//    public juice print() {
//        return new appleJuice();
//    }
//}
//
//class orangeFactory implements fruitFactory{
//    @Override
//    public IFruit get() {
//        return new orangeImpl();
//    }
//
//    @Override
//    public juice print() {
//        return new orangeJuice();
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        fruitFactory fruitFactory = new orangeFactory();
//        IFruit i = fruitFactory.get();
//        juice j = fruitFactory.print();
//        i.print();
//        j.print();
//    }
//}