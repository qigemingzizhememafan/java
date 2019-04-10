package www.bittech;

////业务接口
//interface ISubject{
//    void buyComputer();
//}
////真实主题类
//class RealSubjectImpl implements ISubject{
//    public void buyComputer(){
//        System.out.println("买一台macbook pro");
//    }
//}
////代理类
//class ProxySubjectImpl implements ISubject{
//    private ISubject realSubject;
//    //构造注入，注入真实主题类,此时传入接口而非类对象，是因为一个对象只买mac电脑，而接口可以代理所有
//    public ProxySubjectImpl(ISubject realISubject){
//        this.realSubject = realISubject;
//    }
//    public void beforeSubject(){
//        System.out.println("去银行取钱，排队");
//    }
//    public void buyComputer(){
//        this.beforeSubject();
//        this.realSubject.buyComputer();
//        this.afterSubject();
//    }
//    public void afterSubject(){
//        System.out.println("装各种软件");
//    }
//}
//public class Test{
//    public static void main(String[] args){
////通过代理类的构造方法传入真实业务
//        ISubject subject = new ProxySubjectImpl(new RealSubjectImpl());
//        subject.buyComputer();
//    }
//}
