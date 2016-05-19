<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<%=request.getContextPath() %>/img/logo.png"/>
    <title>资产管理系统</title>
    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">

    <!--[if lt IE 9]>
  <script src="js/html5shiv.min.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
    <style>
        html,body {
            height: 100%;
        }
        .box {
            /*filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /!*  IE *!/*/
            /*background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            /*background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            /*background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            /*background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            /*background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            background-image:url("<%=request.getContextPath() %>/img/bg-login.png");
            background-repeat: no-repeat;
            background-size: 100%;
            margin: 0 auto;
            position: relative;
            width: 100%;
            height: 100%;
        }
        .login-box {
            width: 100%;
            max-width:500px;
            height: 400px;
            position: absolute;
            top: 50%;

            margin-top: -200px;
            /*设置负值，为要定位子盒子的一半高度*/

        }
        @media screen and (min-width:500px){
            .login-box {
                left: 50%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -250px;
            }
        }

        .form {
            width: 100%;
            max-width:500px;
            height: 275px;
            margin: 25px auto 0px auto;
            padding-top: 25px;
        }
        .login-content {
            height: 370px;
            width: 100%;
            max-width:500px;
            background-color: rgba(255, 250, 2550, .6);
            float: left;
        }


        .input-group {
            margin: 0px 0px 30px 0px !important;
        }
        .form-control,
        .input-group {
            height: 40px;
        }

        .form-group {
            margin-bottom: 0px !important;
        }
        .login-title {
            padding: 20px 10px;
            background-color: rgba(0, 0, 0, .6);
        }
        .login-title h1 {
            margin-top: 10px !important;
        }
        .login-title small {
            color: #fff;
        }

        .link p {
            line-height: 20px;
            margin-top: 30px;
        }
        .btn-sm {
            padding: 8px 24px !important;
            font-size: 16px !important;
        }
        .text-white{
            color: white;
        }
    </style>
</head>
<body>
<div class="box">
    <br/>
    <h1 class="text-center text-white"><span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;资产管理系统</h1>
    <div class="login-box">
        <div class="login-title text-center">
            <h1><small>注册</small></h1>
        </div>
        <div class="login-content ">
            <div class="form">
                <s:form action="registerLogin" method="post">
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" id="userName" name="userName" class="form-control" placeholder="用户名">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="text" id="pwd" name="pwd" class="form-control" placeholder="密码">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="text" id="repwd" name="repwd" class="form-control" placeholder="重复密码">
                            </div>
                        </div>
                    </div> 

                    <div class="form-group form-actions">
                        <div class="col-xs-4 col-xs-offset-4 " style="margin: 0 37%;">
                            <%-- <a href="index.html" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-record"></span> 注册</a> --%>
                            <input type="submit" value="注册" class="btn btn-sm btn-info"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 link">
                            <p class="text-center remove-margin"><small>已有账号,请点击</small> <a href="<%=request.getContextPath() %>/login.jsp" ><small>登录</small></a>
                            </p>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
    </div>
</div>


<script src="<%=request.getContextPath() %>/js/jquery-1.11.3.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script>
    /* Bootlint工具用于对页面中的HTML标签以及Bootstrapclass的使用进行检测 */
    /* (function () {
        var s = document.createElement("script");
        s.onload = function () {
            bootlint.showLintReportForCurrentDocument([]);
        };
        s.src = "js/bootlint.js";
        document.body.appendChild(s)
    })(); */
    
    
</script>
</body>
</html>