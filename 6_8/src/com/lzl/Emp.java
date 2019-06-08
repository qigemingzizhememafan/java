package com.lzl;
// 员工信息类
public class Emp {
    private String name;
    private String job;
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
