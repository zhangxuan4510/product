package edu.bjtu.servlet;

import edu.bjtu.dao.ProductDao;
import edu.bjtu.daoimpl.ProductDaoImpl;
import edu.bjtu.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import static java.lang.System.out;

/**
 * Created by zhangxuan on 2016/7/4.
 */
@WebServlet(name = "edu.bjtu.servlet.ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method =request.getParameter("method");
        if("add".equals(method)){
            this.add(request,response);
        }else if("query".equals(method)){
            this.query(request,response);
        }else if("toUpdatePage".equals(method)){
            this.toUpdatePaget(request,response);
        }else if("updateData".equals(method)){
            this.updateData(request,response);
        }else if("update".equals(method)){
            this.update(request,response);
        }else if("delete".equals(method)){
            this.deleteupdateData(request,response);
        }else if("noExist".equals(method)){
            boolean flag=new ProductDaoImpl().ifNoExist(request.getParameter("productNo"));
            PrintWriter out = response.getWriter();
            if(flag){
                out.print("true");
            }else{
                out.print("false");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String productID= UUID.randomUUID().toString();
        String productNo=request.getParameter("productNo");
        String productName=request.getParameter("productName");
        String price_str=request.getParameter("price");
        String company=request.getParameter("company");
        String number_str=request.getParameter("number");
        Double price=Double.valueOf(price_str);
        int number=Integer.valueOf(number_str);
        Product pro=new Product();
        pro.setId(productID);
        pro.setName(productName);
        pro.setPrice(price);
        pro.setCompany(company);
        pro.setNumber(number);
        pro.setProductNo(productNo);
        ProductDao productDao=new ProductDaoImpl();
        productDao.addProduct(pro);
        request.getRequestDispatcher("QueryProduct.jsp").forward(request,response);
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ProductDaoImpl p=new ProductDaoImpl();
        List<Product> list=p.queryProduct();
        request.setAttribute("list",list);
        request.getRequestDispatcher("QueryProduct.jsp").forward(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ProductDaoImpl p=new ProductDaoImpl();
        List<Product> list=p.queryProduct();
        request.setAttribute("list",list);
        request.getRequestDispatcher("UpdateProduct.jsp").forward(request,response);
    }

    private void toUpdatePaget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id=request.getParameter("id");
        request.setAttribute("id",id);
        out.println("id is "+id);
        request.getRequestDispatcher("UpdatePage.jsp").forward(request,response);
    }

    private void updateData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String productID=request.getParameter("productID");
        String productNo=request.getParameter("productNo");
        String productName=request.getParameter("productName");
        String price_str=request.getParameter("price");
        String company=request.getParameter("company");
        String number_str=request.getParameter("number");
        Double price=Double.valueOf(price_str);
        int number=Integer.valueOf(number_str);
        Product pro=new Product();
        pro.setId(productID);
        pro.setName(productName);
        pro.setPrice(price);
        pro.setCompany(company);
        pro.setNumber(number);
        pro.setProductNo(productNo);
        ProductDao productDao=new ProductDaoImpl();
        productDao.update(pro);
        request.getRequestDispatcher("Success.jsp").forward(request,response);
    }

    private void deleteupdateData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
          String id=request.getParameter("id");
          ProductDao productDao=new ProductDaoImpl();
          productDao.delete(id);
          request.getRequestDispatcher("Success.jsp").forward(request,response);
    }

}
