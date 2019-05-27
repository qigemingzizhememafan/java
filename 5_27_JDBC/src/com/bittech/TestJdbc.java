package com.bittech;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) {
        // 1. 加载驱动程序
        // java.sql.Driver driver = new com.mysql.jdbc.Driver(); 也是加载驱动的方式，但是不推荐，
        //                                          这样导入了一个包名，就让这个对象和mysql耦合了
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 自动实例化driver对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 2. 获取连接

        // JDBC API中，获取连接有两种方式
        //  第一种：通过DriverManger驱动管理类
        //  需要：url(地址)：JDBC url schema：
        //                  jdbc:<数据库产品名称>://host:port/<databaseName>?param1 = value1
        //                                                              & param2 = value2
        //  user: root
        //  password: root
        //  第二种：DateSource 知道即可
        String url = "jdbc:mysql://127.0.0.1:3306/t_userinfo";
        Connection connection = null; // Connection选的是接口不是类
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, "root", "root");

            // 3. 创建命令
            statement = connection.createStatement();

            // 4. 准备sql语句
            String sql = "select userid,username,password from servletdb";
            resultSet = statement.executeQuery(sql); // 查询

            // 返回结果，处理结果
            while (resultSet.next()) {
                // 按行取，每一行有很多列，可以选择按列的下标取或列名取，此处按列名取
                // 取到结果
                int useridid = resultSet.getInt("userid");
                String username = resultSet.getNString("username");
                String password = resultSet.getNString("password");
                // 对结果进行输出
                System.out.println(String.format("编号:%d  名称:%s  密码:%s ", useridid, username, password));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭资源
            // 关闭顺序：结果 --> 命令 --> 连接
            if (resultSet != null) {
                try {
                    resultSet.close(); // 为空时关闭会空指针异常
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

