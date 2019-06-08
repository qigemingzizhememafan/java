package com.lzl;
// 操作Emp的类，提供给用户使用
public class EmpAction {
    private Emp emp = new Emp();
    public void setEmpValue(String str) throws Exception{
        BeanUtil.setEmpValue(this,str); //this：当前对象，即EmpAction。str：要被分解的属性串
    }
    public Emp getEmp(){
        return this.emp;
    }
}
