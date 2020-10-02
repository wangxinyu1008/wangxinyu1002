<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/30
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
<form action="/addOver" method="post">
<table border="1px" width="700px">
    <tr>
        <td colspan="2"><h1>记账</h1></td>
    </tr>
    <tr>
        <td>类型：</td>
        <td>
            <select name="typeId">
                <c:forEach items="${billTypes}" var="b">
                    <option value="${b.id}">${b.name}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>标题：</td>
        <td>
            <input type="text" name="title" class="title">
        </td>
    </tr>
    <tr>
        <td>日期：</td>
        <td>
            <input type="text" name="billTime" class="billTime">
        </td>
    </tr>
    <tr>
        <td>金额：</td>
        <td>
            <input type="text" name="price" class="price" value="0">
        </td>
    </tr>
    <tr>
        <td>说明：</td>
        <td>
            <input type="text" name="explain" class="explain">
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="reset" value="重置">
            <input type="submit" value="保存" class="commit">
            <button>返回</button>
        </td>
    </tr>
</table>
</form>
</center>
<script>
    $(document).ready(function () {
        $(".commit").click(function () {
            var title=$(".title").val();
            var billTime=$(".billTime").val();
            var price=$(".price").val();
            var explain=$(".explain").val();
            var reg=/^\d{4}-\d{2}-\d{2}$/;
            if(title==""||billTime==""||price==""||explain==""){
                alert("请填写完整信息")
                return false;
            }
            if(reg.test(billTime)==false){
                alert("日期格式不正确")
                return false;
            }
            if(price<=0){
                alert("价格必须大于0")
                return false;
            }
        })
    })
</script>
</body>
</html>
