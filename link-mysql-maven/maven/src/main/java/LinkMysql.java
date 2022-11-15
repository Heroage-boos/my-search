import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LinkMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取数据库连接
        Connection connection = JdbcUtil.getConnection();
        //3.需要执行的sql语句（?是占位符，代表一个参数）
        String sql = "insert into nation(N_ID,N_Name) values(?,?)";
        //4.获取预处理对象，并依次给参数赋值
        PreparedStatement statement = connection.prepareCall(sql);
        statement.setInt(1,1112); //数据库字段类型是int，就是setInt；1代表第一个参数
        statement.setString(2,"china");    //数据库字段类型是String，就是setString；2代表第二个参数
        //执行sql语句（插入了几条记录，就返回几）
        int i = statement.executeUpdate();  //executeUpdate：执行并更新
        System.out.println(i);
        //关闭jdbc连接
        statement.close();
        connection.close();
    }
}