package com.lzl.myEverything.core.dao.impl;

import com.lzl.myEverything.core.dao.DataSourceFactory;
import com.lzl.myEverything.core.dao.FileIndexDao;
import com.lzl.myEverything.core.mudel.Condition;
import com.lzl.myEverything.core.mudel.FileType;
import com.lzl.myEverything.core.mudel.Thing;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 数据库操作
public class FileIndexDaoImpl implements FileIndexDao {
    private final DataSource dataSource;

    public FileIndexDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Thing thing) {
        // JDBC操作
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = this.dataSource.getConnection();
            String sql = "insert into thing(name,path.depth,file_type) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            // 给预编译命令中sql的占位符赋值
            statement.setString(1,thing.getName());
            statement.setString(2,thing.getPath());
            statement.setInt(3,thing.getDepth());
            statement.setString(4,thing.getFileType().name());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            releaseResource(null, statement, connection);
        }
    }

    @Override
    public List<Thing> query(Condition condition) {
        List<Thing> things = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = this.dataSource.getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("select name,path,depth,file_type from thing ");
            sb.append(" where ");
            //search <name> [file_type]
            //采用模糊匹配
            //前模糊
            //后模糊 ✔
            //前后模糊
            sb.append(" name like  '").append(condition.getName()).append("%'");
            if (condition.getFileType() != null) {
                FileType fileType = FileType.lookupFileTypeByName(condition.getFileType());
                sb.append(" and file_type='" + fileType.name() + "'");
            }
            statement = connection.prepareStatement(sb.toString());
            resultSet = statement.executeQuery();
            //处理结果
            while (resultSet.next()) {
                //Record -> Thing
                Thing thing = new Thing();
                thing.setName(resultSet.getString("name"));
                thing.setPath(resultSet.getString("path"));
                thing.setDepth(resultSet.getInt("depth"));
                thing.setFileType(FileType.lookupFileTypeByName(resultSet.getString("file_type")));
                things.add(thing);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResource(resultSet, statement, connection);
        }
        return things;
    }
//    public List<Thing> query(Condition condition) {
//        List<Thing> things = new ArrayList<>();
//        ResultSet resultSet = null;
//        // JDBC操作
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            connection = this.dataSource.getConnection();
//            StringBuilder sb = new StringBuilder();
//            sb.append("select name,path,depth,file_type from thing");
//            sb.append(" where ");
//            // 采用模糊匹配
//            // 前模糊
//            // 后模糊 ：选这个，符合用户体验，后模糊能用到索引
//            // 前后模糊
//            sb.append(" name like '").append(condition.getName()).append("%'");
//            // search <name>[file_type] 名字必选，类型可选
//            if (condition.getFileType() != null) {
//                FileType fileType = FileType.lookupFileTypeByName(condition.getFileType());
//                sb.append(" and file_type = '" + fileType.name() + "'");
//            }
//
//            statement = connection.prepareStatement(sb.toString());
//            resultSet = statement.executeQuery();
//            //处理结果
//            while (resultSet.next()) {
//                // Record -> Thing
//                Thing thing = new Thing();
//                thing.setName(resultSet.getString("name"));
//                thing.setPath(resultSet.getString("path"));
//                thing.setDepth(resultSet.getInt("depth"));
//                thing.setFileType(FileType.lookupFileTypeByName(resultSet.getString("file_type")));
//                things.add(thing);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            releaseResource(resultSet, statement, connection);
//        }
//        return  things;
//    }

    @Override
    public void delete(Thing thing) {
        // thing -> path => D:\a\b\hello.java
        // thing -> path => D:\a\b 我们希望能把b目录下的所有文件都删除
        // 但是这里用isFile判断不起作用，因为它要先判断path是否有效，此处这个path不存在，就会false
        // 考虑用like path% ，但还是有BUG，如果我们要删D:\a\b，但有个文件是D:\a\ba，就会误删除
        // 这里我们采用 = 判断，绝对匹配，每次只能删一个，效率低，但是能满足要求
        // JDBC操作
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = this.dataSource.getConnection();
            String sql = "delete from thing where path = ? ";
            statement = connection.prepareStatement(sql);
            // 给预编译命令中sql的占位符赋值
            statement.setString(1,thing.getPath());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
          releaseResource(null, statement, connection);
        }
    }

    // 重构：在不改变程序的功能和业务的前提下，对代码进行优化，使得代码更易阅读
    private void releaseResource(ResultSet resultSet,PreparedStatement statement,Connection connection){
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
        DataSource dataSource = DataSourceFactory.getInstance();
        FileIndexDao dao = new FileIndexDaoImpl(dataSource);
        Condition condition = new Condition();
        condition.setName("简历.pdf");
        List<Thing> things = dao.query(condition);
        for(Thing thing: things){
            System.out.println(thing);
        }
    }
}
