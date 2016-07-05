import edu.bjtu.dao.ProductDao;
import edu.bjtu.daoimpl.ProductDaoImpl;
import edu.bjtu.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.DoubleSummaryStatistics;

/**
 * Created by zhangxuan on 2016/7/4.
 */
@WebServlet(name = "AddProductServlet")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productID=request.getParameter("productID");
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
        ProductDao productDao=new ProductDaoImpl();
        productDao.addProduct(pro);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
