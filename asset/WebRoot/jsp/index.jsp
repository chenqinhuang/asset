<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<%=request.getContextPath() %>/img/logo.png"/>
    <title>资产系统</title>
    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mmss.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/font-awesome.min.css"/>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <style>

    </style>
</head>
<body>
<header>
    <%@ include file="/jsp/common/header.jsp"%> 
</header>
<section>
    <div class="container-fluid">
        <div class="row ">
            <!--左侧导航开始-->
            <%@ include file="/jsp/common/sidebar.jsp"%> 
            <!--左侧导航结束-->
            <!----------------------------------------------------------------------------------------------------->
            <!--右侧内容开始-->
            <div class="col-xs-10">
                <br/>
                <ol class="breadcrumb">
                    <li class="active"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</li>
                </ol>
                <h1 class="text-center text-white">资产管理系统</h1>
                <!----------------------------------------------------------    ------------------------------------------->
            </div>
            <!--右侧内容结束-->
        </div>
    </div>
</section>

<%@ include file="/jsp/common/footer.jsp"%> 

<script src="<%=request.getContextPath() %>/js/jquery-1.11.3.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/js/common/login.js"></script>

</body>
</html>