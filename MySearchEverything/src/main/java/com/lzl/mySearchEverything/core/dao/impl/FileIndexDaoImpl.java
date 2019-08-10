package com.lzl.mySearchEverything.core.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.lzl.mySearchEverything.core.dao.FileIndexDao;
import com.lzl.mySearchEverything.core.model.Condition;
import com.lzl.mySearchEverything.core.model.FileType;
import com.lzl.mySearchEverything.core.model.Thing;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务层对数据库的操作
 */
public class FileIndexDaoImpl implements FileIndexDao {

    private final DataSource datasource;

    public FileIndexDaoImpl(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public  void insert(Thing thing) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            // 1,获取数据库连接
            connection = datasource.getConnection();
            // 2,准备sql语句
            String sql = " insert into file_index(name,path,depth,file_index) values(?,?,?,?)";
            // 3,准备命令
            statement = connection.prepareStatement(sql);
            // 4,设置参数1234
            statement.setString(1, thing.getName());
            statement.setString(2, thing.getPath());
            statement.setInt(3, thing.getDepth());
            // FileType.Doc -> DOC
            statement.setString(4, thing.getFileType().name());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            releaseResource(null,statement , connection);
        }
    }

    @Override
    public void delete(Thing thing) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1,获取数据库连接
            connection = null;
            // 2,准备sql语句
            String sql = "delete from file_index where path = " + thing.getPath() + "%' ";
            // 3,准备命令
            statement = null;
            // 4,执行命令
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            releaseResource(null, statement, connection);
        }
    }

    @Override
    public  List<Thing> search(Condition condition) {
        List<Thing> things = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1,获取数据库连接
            connection = datasource.getConnection();
            // 2,准备SQL语句
            // name like% 模糊匹配
            // fileType = 严格匹配
            // 限制深度 TODO
            // 排序  TODO
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append(" select name,path,depth,file_type from file_index ")
                    .append(" where ")
                    .append(" name like '% ")
                    .append(condition.getName())
                    .append("%'");
            if (condition.getFile_type() != null) {
                sqlBuilder.append(" and file_type ")
                        .append(" '= ")
                        .append(condition.getFile_type().toUpperCase())
                        .append("' ");
            }
            //limit, order必选的
            if (condition.getOrderByAsc() != null) {
                sqlBuilder.append(" order by depth ")
                        .append(condition.getOrderByAsc() ? "asc" : "desc");
            }
            if (condition.getLimit() != null) {
                sqlBuilder.append(" limit ")
                        .append(condition.getLimit())
                        .append(" offset 0 ");
            }
            // 3,准备命令
            statement = connection.prepareStatement(sqlBuilder.toString());
            // 4,执行命令
            resultSet = statement.executeQuery();
            // 5,处理结果
            while (resultSet.next()) {
                // 把数据库中的行对象 -> Java中的Thing对象
                Thing thing = new Thing();
                thing.setName(resultSet.getString("name"));
                thing.setPath(resultSet.getNString("path"));
                thing.setDepth(resultSet.getInt("depth"));
                thing.setFileType(FileType.lookupTypeByName(resultSet.getString("file_type")));
                things.add(thing);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            releaseResource(resultSet, statement, connection);
        }
        return things;
    }

    // 重构：在不改变原有方法的基础上
    private void releaseResource(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileIndexDao dao = new FileIndexDaoImpl(new DruidDataSource());
//        Thing thing1 = new Thing();
//        thing1.setName("文件.pdf");
//        thing1.setPath("D:\\a\\b\\文件.pdf");
//        thing1.setDepth(3);
//        thing1.setFileType(FileType.valueOf("DOC"));
//        dao.insert(thing1);
//        Condition condition = new Condition();
//        condition.setName("hh");
//        dao.search(condition);
    }
}
