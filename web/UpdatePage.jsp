<%@ page import="java.sql.Connection" %>
<%@ page import="edu.bjtu.util.UtilDB" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/5
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ProductServlet">
    <table>
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>价格</th>
            <th>公司</th>
            <th>数量</th>
        </tr>
        <%
            String str=request.getParameter("id");
            Connection conn= UtilDB.getConn();
            StringBuffer buffer=new StringBuffer();
            buffer.append("select * from t_product where product_id=?");
            PreparedStatement p=conn.prepareStatement(buffer.toString());
            p.setString(1,str);
            ResultSet res=p.executeQuery();
            res.next();
            String id=res.getString("product_id");
            String name=res.getString("product_name");
            String price=res.getString("price");
            String company=res.getString("company");
            String number=res.getString("num");
        %>
        <tr>
            <td><input type="text"  name="productID" value=<% out.print("'"+str+"'");%> ></td>
            <td><input type="text" name="productName" value=<% out.print("'"+name+"'");%> ></td>
            <td><input type="text" name="price" value=<% out.print("'"+price+"'");%> ></td>
            <td><input type="text" name="company" value=<% out.print("'"+company+"'");%> ></td>
            <td><input type="text" name="number" value=<% out.print("'"+number+"'");%>></td>
        </tr>
    </table>
    <input type="text" name="method" value="updateData" hidden="hidden">
    <input type="submit" value="提交">
</form>
<%
%>
</body>
</html>
