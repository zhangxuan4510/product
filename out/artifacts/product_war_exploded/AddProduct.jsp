<%--
  Created by IntelliJ IDEA.
  User: zhangxuan
  Date: 2016/7/4
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加物品信息</title>
</head>
<body>
   <div>
       <h2>添加物品信息</h2>
       <hr>
       <form action="ProductServlet">
           <table>
               <tr>
                   <th>属性</th>
                   <th>值</th>
               </tr>
               <tr>
                   <td>商品ID</td>
                   <td><input type="text" name="productID"></td>
               </tr>
               <tr>
                   <td>商品名称</td>
                   <td><input type="text" name="productName"></td>
               </tr>
               <tr>
                   <td>商品价格</td>
                   <td><input type="text" name="price"></td>
               </tr>
               <tr>
                   <td>商品公司</td>
                   <td><input type="text" name="company"></td>
               </tr>
               <tr>
                   <td>商品数量</td>
                   <td><input type="text" name="number"></td>
               </tr>
               <input type="submit" value="提交">
           </table>
           <input type="text" name="method" value="add" hidden="hidden">
       </form>
   </div>
</body>
</html>
