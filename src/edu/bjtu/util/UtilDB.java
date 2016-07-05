package edu.bjtu.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by zhangxuan on 2016/7/3.
 */
public class UtilDB {
    //通过连接数据源来连接数据库
    public static Connection getConn(){
        /*
        * 由于数据源信息配置在tomcat容器
        * 如果需要获取数据源连接，首先需要初始化容器
        * */
        DataSource ds=null;
        Connection conn=null;
        try{
            //初始化容器
            Context context=new InitialContext();
            //通过JNDI查找数据源
            ds=(DataSource) context.lookup("java:comp/env/mysql");
            //
            conn=ds.getConnection();
        }catch (Exception e){
            System.out.println(e);
        };
        return conn;
    }

    public static void closeParament(Statement stt, PreparedStatement stat,Connection conn, ResultSet res) {
        try {
            if (stt != null) {
                stt.close();
            }
            if(stat!=null){
                stat.close();
            }
            if(conn!=null){
                conn.close();
            }
            if(res!=null){
                res.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
