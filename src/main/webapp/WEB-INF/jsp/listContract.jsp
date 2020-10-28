<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>所有订单号</title>
</head>

<body>

<table align='left' border='1' cellspacing='0'>
    <h3>所有订单号<h3/>
    <tr>
        <td>id</td>
        <td>合同号</td>
        <td>创建者</td>
        <td>备注</td>
        <td>创建日期</td>
        <td>订单状态</td>
        <td>最后更新时间</td>
        <td>编辑者</td>
        <td>预定发货日期</td>
        <td>编辑</td>
        <td>货物列表</td>


    </tr>
    <c:forEach items="${list}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.number}</td>
            <td>${c.creator}</td>
            <td>${c.remark}</td>
            <td>${c.create_time}</td>
            <td>${c.state}</td>
            <td>${c.update_time}</td>
            <td>${c.editor}</td>
            <td>${c.publish_time}</td>
            <td><a href="editContractPage?id=${c.id}">编辑</a></td>
            <td><a href="contractDetailPage?id=${c.id}">查看订单详情</a></td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
