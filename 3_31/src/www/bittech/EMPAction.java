package www.bittech;
public class EMPAction {
    private Emp emp = new Emp();
    public void setValue(String value){  //一次设置多个属性
        BeanOperation.setBeanValue(this,value);
    }
    public Emp getEmp() {
        return emp;
    }
}
