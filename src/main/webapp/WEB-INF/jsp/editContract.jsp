<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>

<html>

<head>
    <title>订单编辑</title>
</head>

<body>
    <div style="margin:0px auto; width:500px">

        <form action="editContract" method="post">
            <h3>编辑订单号${c.number}的内容</h3>
            备 注 : <input name="remark" value="${c.remark}"> <br>
            订单状态: <input name="state" value="${c.state}"> <br>
            编 辑 者: <input name="editor" value=""> <br>
            发货日期: <input name="publish_time" value="${c.publish_time}"> <br>

            <input name="id" type="hidden" value="${c.id}">
            <button type="submit">提交</button>

        </form>
    </div>
    <hr>
    <form action="file/upload_excel" method="post" enctype="multipart/form-data">
        <p>导入excel添加商品</p>
        <input type="file" name="file">
        <input name="id" type="hidden" value="${c.number}">
        <p><input type="submit" value="添加"></p>
    </form>

</body>

</html>