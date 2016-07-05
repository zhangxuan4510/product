<%@ page import="java.util.List" %>
<%@ page import="edu.bjtu.daoimpl.ProductDaoImpl" %>
<%@ page import="java.util.Vector" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
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
          <c:forEach items="${list}" var="p">
              <tr>
                  <td>${p.id}</td>
                  <td>${p.name}</td>
                  <td>${p.price}</td>
                  <td>${p.company}</td>
                  <td>${p.number}</td>
              </tr>
          </c:forEach>
      </table>
      <a href="index.jsp">主页</a><br>
      <a href="QueryProduct.jsp">查询商品</a>
</body>
</html>
