package com.lzl;
public class Client {

    public static void main(String[] args) {

        CreateDynamic cd = new CreateDynamic(new UserManagerImpl());

        IUserManager iusermanager = (IUserManager) cd.newInstanceProxyObejctFuncion();
        iusermanager.addUser("dd","22");
        iusermanager.delUser('3');
        iusermanager.modifyUser(1,"dd","44");
        iusermanager.queryUser(98);

    }
}
