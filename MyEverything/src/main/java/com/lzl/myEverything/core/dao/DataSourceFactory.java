package com.lzl.myEverything.core.dao;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据库的数据源
 */
public class DataSourceFactory{

    // 这里没有用DataSource instance是因为DataSource是个接口
    // 没有提供setUrl之类的方法，它只有getConnection的方法
    private static volatile DruidDataSource instance;

    private DataSourceFactory() {
    }

    public static DataSource getInstance(){
        if(instance == null){
            synchronized (DataSource.class){
                if(instance == null){
                    // DataSource是接口，不能直接new，要new它的子类
                    instance = new DruidDataSource();
                    // 只是创建了数据源，还没连接数据库
                    // url => host，port，databaseName
                    // driverClass
                    // username
                    // password
                    instance.setUrl("jdbc:mysql://127.0.0.1:3307/everything_g2?characterEncoding=utf8&useSSL=false");
                    instance.setUsername("root");
                    instance.setPassword("ROOT");
                    instance.setDriverClassName("com.mysql.jdbc.Driver");
                }
            }
        }
        return instance;
    }

//    测试代码，测试通过
//    public static void main(String[] args)  {
//        DataSource dataSource = DataSourceFactory.getInstance();
//        try(Connection connection = dataSource.getConnection();
//        PreparedStatement statement = connection.prepareStatement("insert into thing values(?,?,?,?)")){
//           statement.setString(1, "简历.pdf");
//           statement.setString(2, "D:\\b\\简历.pdf");
//           statement.setInt(3, 2);
//           statement.setString(4, "DOC");
//           statement.executeUpdate();
//        }catch (SQLException e){
//
//      }
//    }
}









//*******************************************************************************************
//import javax.sql.DataSource;
//import java.io.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//// 数据源
//public class DataSourceFactory {
//    // 单例数据源
//    private static volatile DruidDataSource instance;
//    private DataSourceFactory(){}
//
//    public static DataSource getInstance(){
//        if(instance == null){
//            synchronized (DataSourceFactory.class){
//                if(instance == null){
//                    instance = new DruidDataSource();
//                    instance.setUrl("jdbc:mysql://127.0.0.1:3307/everything_g2");
//                    instance.setUsername("root");
//                    instance.setPassword("ROOT");
//                    instance.setDriverClassName("com.mysql.jdbc.Driver");
////========================================================================================
//                    // 通过反射实例化Driver对象
////                    instance.setDriverClassName("org.h2.Driver");
//                    // url,username,password
//                    // 采用的是h2的嵌入式数据库，数据库以本地文件的方式存储，只需要提供url接口
//                    // 获取当前工程路径 : ("user.dir")
//                    // 获取用户目录("user.home") : C:\Users\Administrator
//                    // JDBC规范中关于MySQL jdbc:mysql://ip:port/databaseName
//                    String workDir = System.getProperty("user.dir");
//                    // JDBC规范中关于H2 1：jdbc:h2:filepath -> 把数据库存储到本地文件
//                    // 2：jdbc:h2://ip:port/databaseName -> 存储到服务器
////                    instance.setUrl("jdbc:h2:"+workDir+File.separator+"searchEverything");
////============================================================================================
//                }
//            }
//        }
//        return instance;
//    }
//
//    // 初始化数据源
//    public static void initDatabase(){
//        //1,获取数据源
//        DataSource dataSource = DataSourceFactory.getInstance();
//        //2,获取SQL语句即search_everything.sql
//        // 因为我们的数据库脚本search_everything.sql在classpath路径下(编译完在target中能找到)，
//        // 因此可用classloader加载(classpath路径下的都推荐使用类加载器)
//        // 也可以用文件输入流读它的绝对路径(别人要用，路径不同)，但不推荐使用
//        try( InputStream in  = DataSourceFactory.class.getClassLoader()
//                .getResourceAsStream("search_everything.sql");) {
//            if(in == null){
//                throw new RuntimeException("Not read init database script please check it");
//            }
//            StringBuilder sqlBuilder = new StringBuilder();
//            // 输入流转换成String
//            try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
//                String line = null;
//                while((line = reader.readLine()) != null){
//                    if(!(line.startsWith("--"))){
//                        sqlBuilder.append(line);
//                    }
//                }
//            }
//            //3,获取数据库连接和名称执行SQL
//            String sql = sqlBuilder.toString();
//            //JDBC
//            //3.1 获取数据库的连接
//            try {
//                Connection connection = dataSource.getConnection();
//                //3.2 创建命令
//                PreparedStatement statement = connection.prepareStatement(sql);
//                //3.3 执行SQL语句
//                statement.execute();
//                connection.close();
//                statement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        catch (IOException e){
//        }
//    }
//
//
//    public static void main(String[] args) {
//        DataSource dataSource = DataSourceFactory.getInstance();
//        try (Connection connection = dataSource.getConnection();
//            PreparedStatement statement = connection
//                    .prepareStatement("insert into file_index(name,path,depth,file_type) values(?,?,?,?)")
//                    ){
//                statement.setString(1, "简历.pdf");
//                statement.setString(2, "D:\\ABC\\简历.pdf");
//                statement.setInt(3,2 );
//                statement.setString(4,"DOC");
//                statement.executeUpdate();
//            } catch (SQLException e1) {
//            e1.printStackTrace();
//        }
//    }
//}

