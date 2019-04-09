package www.bittech;
// 抽象工厂模式
interface Computer{
    void printComputer();
}
class MacbookComputer implements Computer{
    public void printComputer(){
        System.out.println("This is a Macbookpro");
    }
}
class SurfaceBookComputer implements Computer {
    public void printComputer() {
        System.out.println("This is a Surfacebook");
    }
}
interface OperatingSystem{
    void printSystem();
}
class MacOsSystem implements OperatingSystem{
    public void printSystem(){
        System.out.println("This is a mac os");
    }
}
class Windows8System implements OperatingSystem{
    public void printSystem() {
        System.out.println("This is a Window 8");
    }
}
interface  ProductionFactory{
    Computer createComputer();
    OperatingSystem createSystem();
}
class AppleFactory implements ProductionFactory{
    public Computer createComputer(){
        return new MacbookComputer();
    }
    public OperatingSystem createSystem(){
        return new MacOsSystem();
    }
}
class MsFactory implements ProductionFactory{
    public Computer createComputer(){
        return new SurfaceBookComputer();
    }
    public OperatingSystem createSystem(){
        return new Windows8System();
    }
}
public class Client{
    public void buyComputer(Computer computer){
        computer.printComputer();
    }
    public void use(OperatingSystem s){
        s.printSystem();
    }

    public static void main(String[] args) {
        Client client = new Client();
        ProductionFactory factory = new AppleFactory();
        Computer computer = factory.createComputer();
        OperatingSystem system = factory.createSystem();
        client.buyComputer(computer);
        client.use(system);
    }
}
