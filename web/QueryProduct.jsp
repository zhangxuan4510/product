<%@ page import="java.util.List" %>
<%@ page import="edu.bjtu.daoimpl.ProductDaoImpl" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/4
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <table border="1">
          <tr>
              <th>商品ID</th>
              <th>商品名称</th>
              <th>商品价格</th>
              <th>商品厂家</th>
              <th>商品价格</th>
          </tr>
          <%
              ProductDaoImpl p=new ProductDaoImpl();
              List<Vector<String>> list=p.queryProduct();
              for(int i=0;i<list.size();i++){
                  out.print("<tr>");
                  out.print("<td>"+list.get(i).get(0)+"</td>");
                  out.print("<td>"+list.get(i).get(1)+"</td>");
                  out.print("<td>"+list.get(i).get(2)+"</td>");
                  out.print("<td>"+list.get(i).get(3)+"</td>");
                  out.print("<td>"+list.get(i).get(4)+"</td>");
                  out.print("</tr>");
              }

          %>
      </table>
      <a href="index.jsp">主页</a><br>
      <a href="QueryProduct.jsp">查询商品</a>
</body>
</html>
