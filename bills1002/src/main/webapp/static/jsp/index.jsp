<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/2
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
<form method="post" action="/mocha">
     <span>类型：<select name="typeId">
        <option value="0">不限</option>
         <c:if test="${billType.size()>0}">
             <c:forEach items="${billType}" var="item">
                 <option value="${item.id}">${item.name}</option>
             </c:forEach>
         </c:if>
    </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
    <span>时间：从<input type="text" name="ksTime">&nbsp;到&nbsp;<input type="text" name="jsTime">
    </span>&nbsp;&nbsp;&nbsp;
    <input type="submit" value="搜索">&nbsp;&nbsp;<button class="btn"><a href="/add">记账</a></button>
</form>
<table border="1px" width="800px">
    <tr style="text-align: center" id="shou">
        <td>标题</td>
        <td>记账时间</td>
        <td>类别</td>
        <td>金额</td>
        <td>说明</td>
    </tr>
    <c:if test="${bills.size()>0}">
        <c:forEach items="${bills}" var="item2">
            <tr style="text-align: center">
                <td>${item2.title}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item2.billTime}" type="both"/></td>
                <td>${item2.typeName}</td>
                <c:if test="${item2.typeId==1||item2.typeId==3||item2.typeId==4||item2.typeId==7}">
                    <td>-${item2.price}</td>
                </c:if>
                <c:if test="${item2.typeId==2||item2.typeId==5||item2.typeId==6}">
                    <td>+${item2.price}</td>
                </c:if>
                <td>${item2.explain}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</center>
</body>
</html>
