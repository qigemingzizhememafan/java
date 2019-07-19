package com.lzl.reflect;
public class Test {
    public static void main(String[] args) throws Exception {
       String value = "emp.next:张三|emp.job:coder";
       EmpAction empAction = new EmpAction();
       empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}
