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
    <style>
        .container{
            width: 60%;
            margin: auto;
        }
    </style>
</head>
<body>
      <div class="container">
          <table border="1">
              <tr>
                  <th align="center" colspan="8">欢迎使用商品管理系统</th>
              </tr>
              <tr>
                  <th>商品ID</th>
                  <th>商品编号</th>
                  <th>商品名称</th>
                  <th>商品价格</th>
                  <th>商品厂家</th>
                  <th>商品价格</th>
                  <th>更新</th>
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
                      <td><a href="ProductServlet?method=delete&id=${p.id}" onclick="return sureDelete()">删除</a></td>
                  </tr>
              </c:forEach>
              <tr>
                  <td align="center " colspan="8"><a href="ProductServlet?method=query">查询</a> <a href="AddProduct.jsp">添加</a></td>
              </tr>
          </table>
      </div>

      <script type="text/javascript">
          function sureDelete() {
              var flag=confirm("您确定要删除该条商品记录吗？");
              return flag;
          }
      </script>

</body>
</html>
