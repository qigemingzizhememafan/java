package www.bittech;
//interface Computer{
//    void printCompuer();
//}
//class MacbookComputer implements Computer{
//    public void printComputer(){
//        System.out.println("This is a Macbookpro");
//    }
//}
//class SurfaceBookComputer implements Computer {
//    public void printComputer() {
//        System.out.println("This is a Surfacebook");
//    }
//}
//interface OperatingSystem{
//    void printSystem();
//}
//class MacOsSystem implements OperatingSystem{
//    public void printSystem(){
//        System.out.println("This is a mac os");
//    }
//}
//class Windows8System implements OperatingSystem{
//    public void printSystem() {
//        System.out.println("This is a Window 8");
//    }
//}
//interface  ProductionFactory{
//    Computer createComputer();
//    OperatingSystem createSystem();
//}
//class AppleFactory implements ProductionFactory{
//    public Computer createComputer(){
//        return new MacbookComputer();
//    }
//    public OperatingSystem createSystem(){
//        return new MacOsSystem();
//    }
//}
//class MsFactory implements ProductionFactory{
//    public Computer createComputer(){
//        return new SurfaceBookComputer();
//    }
//    public OperatingSystem createSystem(){
//        return new Windows8System();
//    }
//}
//public class Client{
//    public void buyComputer(Computer computer){
//        computer.printCompuer();
//    }
//    public void use(OperatingSystem s){
//        s.printSystem();
//    }
//
//    public static void main(String[] args) {
//        Client client = new Client();
//        ProductionFactory factory = new AppleFactory();
//        Computer computer = factory.createComputer();
//        OperatingSystem system = factory.createSystem();
//        client.buyComputer(computer);
//        client.use(system);
//    }
//}
//interface Computer{
//    void printComputer();
//}
//class MacbookPro implements Computer{
//    public void printComputer(){
//        System.out.println("This is a macbookpro");
//    }
//}
//class SurfaceBook implements Computer{
//    public void printComputer(){
//        System.out.println("This is a Surfacebook");
//    }
//}
//class AlienWare implements Computer{
//    public void printComputer(){
//        System.out.println("This is a AlienWare");
//    }
//}
//interface ComputerFactory{
//    Computer creatComputer();
//}
////微软产品工厂
//class MsFactory implements ComputerFactory{
//    public Computer creatComputer(){
//        return new SurfaceBook();
//    }
//}
////苹果产品工厂
//class AppleFactory implements ComputerFactory{
//    public Computer creatComputer(){
//        return new MacbookPro();
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        ComputerFactory factory = new AppleFactory();
//        Computer computer = factory.creatComputer();
//        computer.printComputer();
//    }
//}
//import java.util.Scanner;
//interface Computer{
//    void printComputer();
//}
//class MacbookPro implements Computer{
//    public void printComputer(){
//        System.out.println("This is a macbookpro");
//    }
//}
//class SurfaceBook implements Computer{
//    public void printComputer(){
//        System.out.println("This is a Surfacebook");
//    }
//}
////第三方工厂类
//class ComputerFactory{
//    public static Computer getInstance(String type){
//        if(type.equals("mac")){
//            return new MacbookPro();
//        }else if(type.equals("surface")){
//            return new SurfaceBook();
//        }
//        return null;
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入你选择的电脑的型号");
//        String type = scanner.nextLine();
//        Computer computer = ComputerFactory.getInstance(type);
//        computer.printComputer();
//    }
//}