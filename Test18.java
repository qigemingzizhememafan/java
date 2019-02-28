abstract class CaffeeineBeverage{
	//只允许子类使用，不允许被覆写
	//不准子类修改核心冲泡方法
	final void prepareRecipe(){
		boilWater();
		pourInCup();
		brew();
		addCondiments();
	}
	void boilWater(){
		System.out.println("将水烧开");
	}
	void pourInCup(){
		System.out.println("将饮料倒入杯中");
	}
	abstract void brew();
	abstract void addCondiments();
}
class Coffee extends CaffeeineBeverage{
	void brew(){
		System.out.println("冲泡咖啡");
	}
	void addCondiments(){
		System.out.println("加糖和牛奶");
	}
}
class Tea extends CaffeeineBeverage{
	void brew(){
		System.out.println("浸泡茶叶");
	}
	void addCondiments(){
		System.out.println("加柠檬");
	}
}
public class Test18{
	public static void main(String[] args){
		CaffeeineBeverage coffee = new Coffee();
		CaffeeineBeverage tea = new Tea();
		coffee.prepareRecipe();
		tea.prepareRecipe();
	}
}
/*class Coffee{
	//咖啡冲泡方法
	void prepareRecipe(){
		boilWater();
		brewCoffee();
		pourIncup();
		addSugarAndMilk();
	}
	void boilWater(){
		System.out.println("将水烧开");
	}
	void brewCoffee(){
		System.out.println("用水冲泡咖啡");
	}
	void pourIncup(){
		System.out.println("将咖啡倒进杯子");
	}
	void addSugarAndMilk(){
		System.out.println("加糖和牛奶");
	}
}*/
/*class Tea{
	void prepareRecipe(){
		boilWater();
		steepTeaBag();
		pourIncup();
		addLemon();
	}
	void boilWater(){
		System.out.println("将水烧开");
	}
	void steepTeaBag(){
		System.out.println("浸泡茶叶");
	}
	void pourIncup(){
		System.out.println("将茶倒进杯子");
	}
	void addLemon(){
		System.out.println("加柠檬");
	}
}

public class Test18{
	public static void main(String[] args){
		Coffee coffee = new Coffee();
		Tea tea = new Tea();
		coffee.prepareRecipe();
		tea.prepareRecipe();
	}
}*/

/*abstract class Person{
	public abstract void test1();
	abstract class B{ //内部抽象类
		public abstract void test2(); //内部抽象类的抽象方法
	}
}
class Student extends Person{
	public void test1(){} //只需关心父类中的直接抽象方法，内部抽象类的抽象方法不管
	class C extends B{  //子类的内部类去覆写，也可以不覆写
		public void test2(){
			
		}
	}
}
public class Test18{
	public static void main(String[] args){
		new Student();	
	}
}*/

/*class Outter{
	private int num = 5;
	public void display(final int temp){ //jad8之后默认加final，此时final可写可不写
		//方法内部类
	   class Inner{
			 public void fun(){
				 System.out.println(num); //方法内部类可以访问外部属性，外部不可以访问方法内部类属性
				 System.out.println(temp);
				 //要想证明该temp确实是被final修饰的
				 //temp++ 此时会报错，从内部类引用的本地变量必须是最终变量或实际上的最终变量。
				 //即被final修饰的，只能用不能改
			 }
		}
		new Inner().fun();
	}
}*/
/*interface MyInterface{
	void test();
}
class Outter{
	private int num = 5;
	public void display(int temp){
		//匿名内部类，匿名的实现了MyInterface接口
		new MyInterface(){
			public void test(){
				System.out.println("匿名实现MyInterface接口");
				System.out.println(temp);
			}
		}.test();
	}
}
public class Test18{
	public static void main(String[] args){
	Outter out = new Outter();
	out.display(20);
}
}*/


