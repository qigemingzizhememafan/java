package com.lzl.reflect;

public class EmpAction {
    private Emp emp = new Emp();

    public void setValue(String value) throws Exception {
        BeanOpreation.setBeanValue(this,value);
    }

    public Emp getEmp() {
        return emp;
    }
}
