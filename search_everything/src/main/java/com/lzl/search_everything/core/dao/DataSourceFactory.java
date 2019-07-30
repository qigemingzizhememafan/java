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
                    dataSource.setDriverClassName("org.h2.Driver");
                    // url,username,password
                    // 采用的是h2的嵌入式数据库，数据库以本地文件的方式存储，只需要提供url接口
                    // 获取当前工程路径
                    // 获取用户目录("user.home")
                    String workDir = System.getProperty("user.dir");
                    // JDBC规范中关于H2 jdbc:h2:filepath -> 存储到本地文件
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
        // 因为这个在classpath路径下，因此可用classloader加载
        // 也可以用文件输入流读它的绝对路径，但不推荐使用
        try(  InputStream in  = DataSourceFactory.class.getClassLoader()
                .getResourceAsStream("search_everything.sql");) {
            if(in == null){
                throw new RuntimeException("Not read init database script please check it");
            }
            StringBuilder sqlBuilder = new StringBuilder();
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(in));){
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
