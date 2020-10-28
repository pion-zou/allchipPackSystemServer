</html><%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>订单详情</title>
</head>

<body>
    <table border='1' cellspacing='0'>
        <h3>${c.number}订单详情：
            <h3 />
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
            </tr>
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
            </tr>
    </table>
    <hr>

    <table border='1' cellspacing='0'>
        <h3>合同货物情况
            <h3 />
            <form action="printQRCode" method="post">
                <input name="number" type="hidden" value="${c.number}">
                <button type="submit">打印二维码</button>
            </form>
            <tr>
                <td>序号</td>
                <td>No.</td>
                <td>类型</td>
                <td>数量</td>
                <td>已装包数量</td>
                <td>生产商</td>
                <td>package</td>
                <td>单价</td>
                <td>总价</td>
                <td>年份</td>
                <td>装包时间</td>
                <td>编辑</td>

            </tr>
            <c:forEach items="${c.goodList}" var="g" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${g.item_index}</td>
                    <td>${g.type}</td>
                    <td>${g.count}</td>
                    <td>${g.package_count}</td>
                    <td>${g.manufacturer}</td>
                    <td>${g.package}</td>
                    <td>${g.unit_price}</td>
                    <td>${g.total_price}</td>
                    <td>${g.year}</td>
                    <td>${g.package_time}</td>
                    <td><a href="editGoodPage?id=${g.id}">编辑</a></td>
                </tr>
            </c:forEach>
    </table>
    <form action="removeGoods" method="post">
        <input name="number" type="hidden" value="${c.number}">

        <button type="submit">清空</button>
    </form>
</body>

</html>