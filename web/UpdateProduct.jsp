<%@ page import="java.util.Vector" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.bjtu.model.Product" %>
<%@ page import="edu.bjtu.daoimpl.ProductDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/5
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<table border="1">
    <tr>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品厂家</th>
        <th>商品价格</th>
        <th>修改</th>
    </tr>
    <c:forEach items="${list}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.productNo}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.company}</td>
            <td>${p.number}</td>
            <td><a href="ProductServlet?method=toUpdatePage&id=${p.id}">修改</a></td>
            <td><a href="ProductServlet?method=delete&id=${p.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
