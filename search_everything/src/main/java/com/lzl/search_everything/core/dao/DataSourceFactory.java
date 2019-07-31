package com.lzl.search_everything.core.dao;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 数据源
public class DataSourceFactory {

    /**
     * 数据源(单例)
     */
    private static volatile DruidDataSource dataSource;
    private DataSourceFactory(){}

    public static DataSource dataSource(){
        if(dataSource == null){
            synchronized (DataSourceFactory.class){
                if(dataSource == null){
                    // 实例化
                    dataSource = new DruidDataSource();
                    // 通过反射实例化Driver对象
                    dataSource.setDriverClassName("org.h2.Driver");
                    // url,username,password
                    // 采用的是h2的嵌入式数据库，数据库以本地文件的方式存储，只需要提供url接口
                    // 获取当前工程路径
                    // 获取用户目录("user.home")
                    // JDBC规范中关于MySQL jdbc:mysql://ip:port/databaseName
                    String workDir = System.getProperty("user.dir");
                    // JDBC规范中关于H2 1：jdbc:h2:filepath -> 把数据库存储到本地文件
                    // 2：jdbc:h2://ip:port/databaseName -> 存储到服务器
                    dataSource.setUrl("jdbc:h2:"+workDir+File.separator+"search_everything");
                }
            }
        }
        return  dataSource;
    }

    public static void initDatabase(){
        //1,获取数据源
        DataSource dataSource = DataSourceFactory.dataSource();
        //2,获取SQL语句即search_everything.sql
        // 因为我们的数据库脚本search_everything.sql在classpath路径下(编译完在target中能找到)，
        // 因此可用classloader加载(classpath路径下的都推荐使用类加载器)
        // 也可以用文件输入流读它的绝对路径(别人要用，路径不同)，但不推荐使用
        try( InputStream in  = DataSourceFactory.class.getClassLoader()
                .getResourceAsStream("search_everything.sql");) {
            if(in == null){
                throw new RuntimeException("Not read init database script please check it");
            }
            StringBuilder sqlBuilder = new StringBuilder();
            // 输入流转换成String
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
                String line = null;
                while((line = reader.readLine()) != null){
                    if(!(line.startsWith("--"))){
                        sqlBuilder.append(line);
                    }
                }
            }
            //3,获取数据库连接和名称执行SQL
            String sql = sqlBuilder.toString();
            //JDBC
            //3.1 获取数据库的连接
            try {
                Connection connection = dataSource.getConnection();
                //3.2 创建命令
                PreparedStatement statement = connection.prepareStatement(sql);
                //3.3 执行SQL语句
                statement.execute();

                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e){

        }

    }

}
