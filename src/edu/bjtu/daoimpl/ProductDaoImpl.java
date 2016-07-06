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
        sql.append("insert into t_product(product_id,product_name,price,company,num,productno) values(?,?,?,?,?,?)");
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
            preparedStatement.setString(6,product.getProductNo());
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
    public List<Product> queryProduct() {
        ResultSet res=null;
        StringBuffer sql=new StringBuffer();
        sql.append("select * from t_product");
        Connection conn=UtilDB.getConn();
        List<Product> list=new ArrayList<Product>();
        PreparedStatement stat=null;
            try {
                stat=conn.prepareStatement(sql.toString());
            res=stat.executeQuery();
            while(res.next()){
                Product p=new Product();
                String id=res.getString("product_id");
                String name=res.getString("product_name");
                String price=res.getString("price");
                String company=res.getString("company");
                String number=res.getString("num");
                String no=res.getString("productno");
                p.setId(id);
                p.setName(name);
                p.setPrice(Double.valueOf(price));
                p.setCompany(company);
                p.setNumber(Integer.valueOf(number));
                p.setProductNo(no);
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                UtilDB.closeParament(null,stat,conn,null);
            }
        System.out.println("size is "+list.size());
        return list;
    }

    @Override
    public boolean delete(String id){
        StringBuffer sql=new StringBuffer();
        Connection conn=UtilDB.getConn();
        PreparedStatement stat=null;
        sql.append("delete from t_product where product_id=?");
        try {
            stat=conn.prepareStatement(sql.toString());
            stat.setString(1,id);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            UtilDB.closeParament(null,stat,conn,null);
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        String id=product.getId();
        StringBuffer sql=new StringBuffer();
        sql.append("update t_product set product_name=?,price=?,company=?,num=? where product_id=?");
        Connection conn=UtilDB.getConn();
        System.out.println("conn is"+conn);
        PreparedStatement preparedStatement=null;
        int count=0;
        try {
            preparedStatement=conn.prepareStatement(sql.toString());
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getCompany());
            preparedStatement.setInt(4,product.getNumber());
            preparedStatement.setString(5,product.getId());
            count=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilDB.closeParament(null,preparedStatement,conn,null);
        }
        return false;
    }

    @Override
    public boolean ifNoExist(String str) {
        boolean flag=true;
        StringBuffer buffer=new StringBuffer();
        buffer.append("select productno from t_product where productno=?");
        PreparedStatement stat=null;
        ResultSet res=null;
        Connection conn=UtilDB.getConn();
        try {
            stat=conn.prepareStatement(buffer.toString());
            stat.setString(1,str);
            res=stat.executeQuery();
            res.last();
            int count=res.getRow();
            if(count>0)
                flag=false;
            UtilDB.closeParament(null,stat,conn,res);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
              UtilDB.closeParament(null,stat,conn,res);
        }
        return flag;
    }
}
