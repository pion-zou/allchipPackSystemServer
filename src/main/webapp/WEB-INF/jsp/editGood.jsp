<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>

<html>

<head>
    <title>货物编辑</title>
</head>

<body>
    <div style="margin:0px auto; width:500px">

        <form action="editGood" method="post">
            <h3>编辑订单号${g.number}的货物id=${g.id}</h3>
            类型 : <input name="type" value="${g.type}"> <br>
            数量: <input name="count" value="${g.count}"> <br>
            已装包数量: <input name="package_count" value="${g.package_count}"> <br>
            生产商: <input name="manufacturer" value="${g.manufacturer}"> <br>
            package: <input name="package" value="${g.package}"> <br>
            单价: <input name="unit_price" value="${g.unit_price}"> <br>
            总价: <input name="total_price" value="${g.total_price}"> <br>
            年份: <input name="year" value="${g.year}"> <br>
            装包时间: <input name="package_time" value="${g.package_time}"> <br>
            <input name="id" type="hidden" value="${g.id}">
            <input name="number" type="hidden" value="${g.number}">
            <input name="item_index" type="hidden" value="${g.item_index}">
            <button type="submit">提交</button>

        </form>
    </div>
</body>

</html>
