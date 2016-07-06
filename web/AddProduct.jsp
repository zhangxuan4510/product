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
    <script src="js/jquery-3.0.0.min.js"></script>
    <style>
        .container{
            width: 60%;
            margin: auto;
        }
    </style>
</head>
<body>
   <div class="container">
       <h2 align="center">添加物品信息</h2>
       <hr>
       <form action="ProductServlet" id="form">
           <table>
               <tr>
                   <td>商品编号</td>
                   <td><input type="text" name="productNo" id="productNo" onblur="checkProNo()"><span id="noSpan"></span></td>
               </tr>
               <tr>
                   <td>商品名称</td>
                   <td><input type="text" name="productName" id="name" onblur="checkName()"><span id="nameSpan"></span></td>
               </tr>
               <tr>
                   <td>商品价格</td>
                   <td><input type="text" name="price" id="price" onblur="checkPrice()"><span id="priceSpan" ></span></td>
               </tr>
               <tr>
                   <td>商品公司</td>
                   <td><input type="text" name="company" id="company" onblur="checkCompany()"><span id="companySpan"></span></td>
               </tr>
               <tr>
                   <td>商品数量</td>
                   <td><input type="text" name="number" id="number" onblur="checkNumber()"><span id="numberSpan"></span></td>
               </tr>
           </table>
           <input type="text" name="method" value="add" hidden="hidden">
       </form>
       <button id="but" onclick="check()">确定</button>
   </div>
   <script type="text/javascript">
       var flag1=false;
       var flag2=false;
       var flag3=false;
       var flag4=false;
       var flag5=false;
       function checkProNo() {
           var str=$("#productNo").val();
           if(str!=null&&str!=""&&str!=" "){
                checkExist();
           }else{
               flag1=false;
               $("#noSpan").html("输入的值不能为空");
               $("#noSpan").css("color","red");
           }
       }
       function checkName() {
           var str=$("#name").val();
           if(str!=null&&str!=""&&str!=" "){
               $("#nameSpan").html("输入正确");
               $("#nameSpan").css("color","green");
               flag2=true;
           }else{
               flag2=false;
               $("#nameSpan").html("输入的值不能为空");
               $("#nameSpan").css("color","red");
           }
       }
       function checkPrice() {
           var str=$("#price").val();
           if(str!=null&&str!=""&&str!=" "){
              if(isNaN(str)){
                  flag3=false;
                  $("#priceSpan").html("应该输入数字");
                  $("#priceSpan").css("color","red");
              }else{
                  $("#priceSpan").html("输入正确");
                  $("#priceSpan").css("color","green");
                  flag3=true;
              }
           }else{
               flag3=false;
               $("#priceSpan").html("输入的值不能为空");
           }
       }
       function checkCompany() {
           var str=$("#company").val();
           if(str!=null&&str!=""&&str!=" "){
               $("#companySpan").html("输入正确");
               $("#companySpan").css("color","green");
               flag4=true;
           }else{
               flag4=false;
               $("#companySpan").css("color","red");
               $("#companySpan").html("输入的值不能为空");
           }
       }

       function checkNumber() {
           var str=$("#number").val();
           if(str!=null&&str!=""&&str!=" "){
               if(isNaN(str)){
                   flag5=false;
                   $("#numberSpan").html("应该输入数字");
                   $("#numberSpan").css("color","red");
               }else{
                   $("#numberSpan").html("输入正确");
                   $("#numberSpan").css("color","green");
                   flag5=true;
               }
           }else{
               flag5=false;
               $("#numberSpan").html("输入的值不能为空");
           }
       }

       function check() {
           if(flag1==true&&flag2==true&&flag3==true&&flag4==true&&flag5==true){
               $("#form").submit();
           }else{
               alert("请您完成正确的输入");
           }
       }

       function checkExist() {
           var xmlhttp;
           if (window.XMLHttpRequest)
           {
               xmlhttp=new XMLHttpRequest();
           }
           else
           {
               xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
           }
           xmlhttp.open("GET","ProductServlet?method=noExist&productNo="+$("#productNo").val(),true);
           xmlhttp.send();
           var flag="false";
           xmlhttp.onreadystatechange=function()
           {
               if (xmlhttp.readyState==4 && xmlhttp.status==200)
               {
                   flag=xmlhttp.responseText;
                   alert("come in "+flag);
                   if(flag=="true"){
                       $("#noSpan").html("输入正确");
                       $("#noSpan").css("color","green");
                       flag1=true;
                   }
                   if(flag=="false"){
                       flag1=false;
                       $("#noSpan").html("改商品编号已经存在，请您重新输入");
                       $("#noSpan").css("color","red");
                   }
               }
           }
       }

   </script>
</body>
</html>
