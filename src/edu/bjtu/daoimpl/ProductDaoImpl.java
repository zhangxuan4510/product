package edu.bjtu.daoimpl;

import edu.bjtu.dao.ProductDao;
import edu.bjtu.model.Product;
import edu.bjtu.util.UtilDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by zhangxuan on 2016/7/4.
 */
public class ProductDaoImpl implements ProductDao{

    @Override
    public void addProduct(Product product){
        StringBuffer sql=new StringBuffer();
        Connection conn=null;
        sql.append("insert into t_product(product_id,product_name,price,company,num) values(?,?,?,?,?)");
        conn=UtilDB.getConn();
        System.out.println("conn is"+conn);
        PreparedStatement preparedStatement=null;
        int count=0;
        try {
            preparedStatement=conn.prepareStatement(sql.toString());
            preparedStatement.setString(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setString(4,product.getCompany());
            preparedStatement.setInt(5,product.getNumber());
            count=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeParament(null,preparedStatement,conn,null);
        }
        if(count!=0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    @Override
    public List queryProduct() {
        ResultSet res=null;
        StringBuffer sql=new StringBuffer();
        sql.append("select * from t_product");
        Connection conn=UtilDB.getConn();
        List<Vector<String>> list=new ArrayList<Vector<String>>();
        try {
            PreparedStatement stat=conn.prepareStatement(sql.toString());
            res=stat.executeQuery();
            while(res.next()){
                Vector<String> v=new Vector<String>();
               String id=res.getString("product_id");
                String name=res.getString("product_name");
                String price=res.getString("price");
                String company=res.getString("company");
                String number=res.getString("num");
                v.add(id);
                v.add(name);
                v.add(price);
                v.add(company);
                v.add(number);
                list.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("size is "+list.size());
        return list;
    }
}
