<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String  basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/logo.png"/>
    <title>资产管理系统</title>
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

<section >
    <div class="container-fluid">
        <div class="row ">
            <!-- 导入左侧内容 -->
            <%-- <%@include file="WEB-INF/asset/jsp/sidebar.jsp" %> --%>
            
            <!--左侧导航开始-->
            <%@ include file="/jsp/common/sidebar.jsp"%> 
            <!--左侧导航结束-->
            <!----------------------------------------------------------------------------------------------------->
            <!--右侧内容开始-->
            <div class="col-xs-10">
                <br/>
                <ol class="breadcrumb">
                    <li><a href="index.html"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</a></li>
                    <li class="active">人员管理 - 表格</li>
                </ol>
                <div class="input-group line left">
                    <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-search"></span></span>
                    <input type="text" class="form-control" placeholder="输入关键字搜索" aria-describedby="basic-addon2">
                </div>
                <select class="form-control line left">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <a href="#" class=" btn btn-primary "><span class="glyphicon glyphicon-search"></span></a>
                <a href="#" class=" btn btn-primary "><span class="glyphicon glyphicon-download"></span></a>
				<a href="#" class=" btn btn-primary btn-add openAdd"><span class="glyphicon glyphicon-plus"></span></a>   <br/>
				<br/>
                <table class="table table-bordered table-striped text-center bg-info" id="usertable">
                    <thead >
                    <tr class="info">
                        <th class="text-center">序号</th>
                        <th class="text-center">角色Id</th>
                        <th class="text-center">部门Id</th>
                        <th class="text-center">用户名</th>
                        <th class="text-center">性别</th>
                        <th class="text-center">状态</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                   
                    </tbody>
                </table>
                <!-- <ul class="pagination right">
                    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                    </li>
                    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
                </ul> -->
            </div>
            <!--右侧内容结束-->
            
             <!-- modal -->
             <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								
								
								<h4 class="modal-title" id="myModalLabel1">编辑</h4>
                                    </div>
                                    <div class="modal-body">
                                        <ul>
                                            <li>
                                                <label><span>序号 ：</span></label>
                                                <input type="text" id="userId" value="" disabled="disabled"/>
                                            </li>
                                            
                                            <li>
                                                <label><span>角色 ：</span></label>
                                                <input type="text" id="roleId" value=""/>
                                            </li>
                                            <li>
                                                <label><span>用户名 ：</span></label>
                                                <input type="text" id="userName"/>
                                            </li>
                                            
                                            <li>
                                                <label><span>部门 ：</span></label>
                                                <input type="text" id="deptId"/>
                                            </li>
                                           
                                            <li>
                                                <label><span>性别 ：</span></label>
                                                <input type="text" id="sex"/>
                                            </li>
                                            
                                            <li>
                                                <label><span>状态 ：</span></label>
                                                <input type="text" id="status"/>
                                            </li>
                                           
                                        
                                        </ul>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
                                        <button type="button" class="btn btn-primary btn-sm updateUser" data-dismiss="modal">保存</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        	
				<!-- modal-add -->
				<div class="modal fade" id="add" tabindex="-1" role="dialog"
					aria-labelledby="add">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								
								
								<h4 class="modal-title" id="myModalLabel1">添加</h4>
								
								
								
							</div>
							<div class="modal-body">
								<ul>

									<li><label><span>角色id :</span></label> <input
										type="text" id="roleId2" value="" /></li>

									<li><label><span>部门id:</span></label> <input
										type="text" id="deptId2" value="" /></li>

									<li><label><span>用户名 :</span></label> <input
										type="text" id="userName2" value="" /></li>

									<li><label><span>性别 :</span></label> <input
										type="text" id="sex2" value="" /></li>
										
									<li><label><span>状态 :</span></label> <input
										type="text" id="status2" value="" /></li>
										
									<li><label><span>密码 :</span></label> <input
										type="text" id="pwd" value="" /></li>

								</ul>
							</div>
							<div class="modal-footer">
								<i>
									<button type="button" class="btn btn-default btn-sm"
										data-dismiss="modal">取消</button>
									<button type="button"
										class="btn btn-primary btn-sm addUser"
										data-dismiss="modal">添加</button>
								</i>
							</div>
						</div>
					</div>
				</div>
 
        </div>
    </div>
</section>

<%@ include file="/jsp/common/footer.jsp"%> 

<script src="<%=request.getContextPath() %>/js/jquery-1.11.3.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/lib/datatable/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath() %>/js/sysmgt/usermanagement.js"></script>
<script>
    /*Bootlint工具用于对页面中的HTML标签以及Bootstrapclass的使用进行检测*/
    /* (function () {
        var s = document.createElement("script");
        s.onload = function () {
            bootlint.showLintReportForCurrentDocument([]);
        };
        s.src = "js/bootlint.js";
        document.body.appendChild(s)
    })(); */

//    添加编辑模态框
   /*  $('#add').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('' + recipient)
        modal.find('.modal-body input').val(recipient)
    }) */
</script>
</body>
</html>