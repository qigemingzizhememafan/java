class IntDemo{
	private int intValue;
	public IntDemo(int intValue){
		this.intValue = intValue;
	}
	public int intValue(){
		return this.intValue;
	}
}
public class Test19{
public static void main(String[] args){
	//将整型常量封装到类中
	IntDemo intDemo = new IntDemo(10);
	int result = intDemo.intValue();
	System.out.println(result+20);
}
}

/*
//业务接口
interface ISubject{
	void buyComputer();
}
//真实主题类
class RealSubjectImpl implements ISubject{
	public void buyComputer(){
		System.out.println("买一台macbook pro");
	}
}
//代理类
class ProxySubjectImpl implements ISubject{
	private ISubject realSubject;
	//构造注入，注入真实主题类
	public ProxySubjectImpl(ISubject realISubject){
		this.realSubject = realISubject;
	}
	public void beforeSubject(){
		System.out.println("去银行取钱，排队");
	}
	public void buyComputer(){
		this.beforeSubject();
		this.realSubject.buyComputer();
		this.afterSubject();
	}
	public void afterSubject(){
		System.out.println("装各种软件");
	}
}
public class Test19{
	public static void main(String[] args){
		ISubject subject = new ProxySubjectImpl(new RealSubjectImpl());
		subject.buyComputer();
	}
}*/
/*class Father{
	final class Inner{
		public String msg = "test";
	}
}
public class Test19{
	public static void main(String[] args){
		
	}
}*/
/*interface Computer{
	void printComputer();
}
class MacbookPro implements Computer{
	public void printComputer(){
		System.out.println("This is a macbookpro");
	}
}
class SurfaceBook implements Computer{
	public void printComputer(){
		System.out.println("This is a Surfacebook");
	}
}
class AlienWare implements Computer{
	public void printComputer(){
		System.out.println("This is a AlienWare");
	}
}
interface ComputerFactory{
	Computer creatComputer();
}
//微软产品工厂
class MsFactory implements ComputerFactory{
	public Computer creatComputer(){
		return new SurfaceBook();
	}
}
//苹果产品工厂
class AppleFactory implements ComputerFactory{
	public Computer creatComputer(){
		return new MacbookPro();
	}
}
public class Test19{
	public static void main(String[] args){
		ComputerFactory factory = new AppleFactory();
		Computer computer = factory.creatComputer();
		computer.printComputer();		
	}
}*/
/*interface Computer{
	void printComputer();
}
class MacbookPro implements Computer{
	public void printComputer(){
		System.out.println("This is a macbookpro");
}
}
class Surface implements Computer{
	public void printComputer(){
		System.out.println("This is a Surfacebook");
}
}
//第三方工厂
class ComputerFactor{
	public static Computer getInstance(String type){
		if(type.equals("mac")){
			return new MacbookPro();
		}else if(type.equals("surface")){
			return new SurfaceBook();
		}
		return null;
	}
}
public class Test19{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你想要的电脑型号");
		String type = scanner.nextLine();
		Computer computer = ComputerFactor.getInstance();
		computer.printcomputer();
	}
}*/







