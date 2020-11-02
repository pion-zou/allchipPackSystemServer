<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>后台包装管理系统</h1>
<b>现在时间是  ${now}</b>
<p>
<a href="/listContract">查看订单</a><p>
<a href="/addContractPage">录入订单</a><p>
<a href="/listContract">订单搜索</a><p>


<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="row" th:insert="~{common :: header}">
</div>
   <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Spring Boot</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container" style="min-height: 500px">
        <div class="starter-template">
            <h1>Spring Boot AJAX 示例</h1>
            <div id="feedback"></div>
            <form class="form-horizontal" id="search-form">
                <div class="form-group form-group-lg">
                    <label class="col-sm-2 control-label">用户名：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="bth-search"
                                class="btn btn-primary btn-lg">搜索
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript"
            src="/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>

