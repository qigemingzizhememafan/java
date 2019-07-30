package com.lzl.search_everything.core.dao.impl;

import com.lzl.search_everything.core.dao.DataSourceFactory;
import com.lzl.search_everything.core.dao.FileIndexDao;
import com.lzl.search_everything.core.model.Condition;
import com.lzl.search_everything.core.model.FileType;
import com.lzl.search_everything.core.model.Things;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务层
 */
public class FileIndexDaoImpl implements FileIndexDao {
    private final DataSource dataSource;

    public FileIndexDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Things things) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            // 1,获取数据库连接
            connection = dataSource.getConnection();
            // 2,准备SQL语句
            String sql = "insert into file_index(name,path,depth,file_type) values(?,?,?,?)";
            // 3,准备命令
            statement = connection.prepareStatement(sql);
            // 4,设置参数 1 2 3 4
            statement.setString(1,things.getName());
            statement.setString(2,things.getPath());
            statement.setInt(3,things.getDepth());
            statement.setString(4,things.getFileType().name());
            // 5,执行命令
            statement.executeUpdate();
        }catch (SQLException e){

        }finally {
            releaseResource(null,statement,connection);
        }
    }

//    @Override

    public List<Things> search(Condition condition) {
        List<Things> things1 = new ArrayList<>();
        // TODO
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            // 1,获取数据库连接
            connection = dataSource.getConnection();
            // 2,准备SQL语句
            // name: like ：文件名模糊匹配
            // fileType: = ：文件类型完全匹配
            // limit : limit offset
            // orderbyAsc : order by
            // 按文件深度升序显示，优先显示文件深度浅的
            // 同时对搜索得到的结果进行数量限制，不然如果搜个java，我们maven本地库中全是含java的文件
            // 体验不好，或者搜program可能能有几十万条记录
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append(" select name,path,depth,file_type from file_index ");
            // name匹配原则：前模糊，后模糊，前后模糊
            sqlBuilder.append(" where ")
                    .append(" name like '%")
                    .append(condition.getName())
                    .append("%' ");
            // 枚举名称存的是大写，这里全部转大写
            if(condition.getFileType() != null){
                sqlBuilder.append(" and file_type = '")
                        .append(condition.getFileType().toUpperCase())
                        .append("' ");
            }
            // limit,order 必选的
            // 先order在limit
            sqlBuilder.append(" order by depth ")
                    .append(condition.isOrderByAsc()? "asc": "desc");

            sqlBuilder.append(" limit ")
                    .append(condition.getLimit())
                    .append(" offset 0 ");
            System.out.println(sqlBuilder.toString());

            // 3,准备命令
            statement = connection.prepareStatement(sqlBuilder.toString());
            // 4,执行命令
            resultSet = statement.executeQuery();
            // 5,处理结果
            while(resultSet.next()){
                // 数据库中的行记录变成java中的Things对象
                Things things = new Things();
                things.setName(resultSet.getString("name"));
                things.setPath(resultSet.getNString("path"));
                things.setDepth(resultSet.getInt("depth"));
                String fileType = resultSet.getString("file_type");
                things.setFileType(FileType.lookupByName(fileType));
                things1.add(things);
            }
        }catch (SQLException e){

        }finally {
            releaseResource(resultSet,statement,connection);
        }
        return things1;
    }

    // 解决内部代码大量重复问题：重构
    private void releaseResource(ResultSet resultSet,PreparedStatement statement,Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
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


//     测试搜索功能代码，结果正确
//    public static void main(String[] args) {
//        FileIndexDao fileIndexDao = new FileIndexDaoImpl(DataSourceFactory.dataSource());
//        Things testthings = new Things();
//        testthings.setName("简历2.docx");
//        testthings.setPath("F:\\1261271622\\a\\简历2.ppt");
//        testthings.setDepth(3);
//        testthings.setFileType(FileType.DOC);
//        fileIndexDao.insert(testthings);
//
//        Condition condition = new Condition();
//        condition.setName("简历");
//        condition.setLimit(1);
//        condition.setOrderByAsc(true);
//        condition.setFileType("DOC");
//        List<Things> things = fileIndexDao.search(condition);
//        for(Things t : things){
//            System.out.println(t);
//        }
//    }
}
