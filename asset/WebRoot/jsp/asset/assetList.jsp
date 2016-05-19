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
    <link rel="icon" href="img/logo.png"/>
    <title>资产管理系统</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mmss.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/lib/datepicker/jquery-ui.structure.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/lib/datepicker/jquery-ui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/lib/datepicker/jquery-ui.theme.css"/>
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
				<!--左侧导航开始-->
				<%@ include file="/jsp/common/sidebar.jsp"%>
				<!--左侧导航结束-->
				<!----------------------------------------------------------------------------------------------------->
				<!--右侧内容开始-->
				<div class="col-xs-10">
					<br />
					<ol class="breadcrumb">
						<li><a href="index.html"><span
								class="glyphicon glyphicon-home"></span>&nbsp;后台首页</a></li>
						<li class="active">资产列表 - 表格</li>
					</ol>
					<div class="input-group line left">
						<span class="input-group-addon" id="basic-addon2"><span
							class="glyphicon glyphicon-search"></span></span> <input type="text"
							class="form-control" placeholder="输入关键字搜索"
							aria-describedby="basic-addon2">
					</div>
					<select class="form-control line left">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select> <a href="#" class=" btn btn-primary "><span
						class="glyphicon glyphicon-search"></span></a> <a href="#"
						class=" btn btn-primary "><span
						class="glyphicon glyphicon-download"></span></a> <a href="#"
						class=" btn btn-primary btn-add openAdd"><span
						class="glyphicon glyphicon-plus"></span></a> <br />
					<br />
					<table
						class="table table-bordered table-striped text-center bg-info"
						id="assetTable">
						<thead>
							<tr class="info">
								<th class="text-center" width="60px">序号</th>
								<th class="text-center" width="150px">资产类别Id</th>
								<th class="text-center" width="150px">使用人部门Id</th>
								<th class="text-center" width="150px">采购部门Id</th>
								<th class="text-center" width="150px">保管人Id</th>
								<th class="text-center" width="150px">财务入账人Id</th>
								<th class="text-center" width="150px">采购单明细Id</th>
								<th class="text-center" width="150px">上级资产类别Id</th>
								<th class="text-center" width="300px">卡片编号</th>
								<th class="text-center" width="300px">使用状态</th>
								<th class="text-center" width="300px">在库状态</th>
								<th class="text-center" width="300px">财务是否入账</th>
								<th class="text-center" width="300px">规格型号</th>
								<th class="text-center" width="300px">资产名称</th>
								<th class="text-center" width="300px">财务入账日期</th>
								<th class="text-center" width="300px">财务编码</th>
								<th class="text-center" width="300px">资产编码</th>
								<th class="text-center" width="300px">制造商</th>
								<th class="text-center" width="300px">供应商</th>
								<th class="text-center" width="300px">入库时间</th>
								<th class="text-center" width="300px">单位</th>
								<th class="text-center" width="300px">数量</th>
								<th class="text-center" width="300px">备注</th>
								<th class="text-center" width="300px">单价</th>
								<th class="text-center" width="300px">标签是否打印</th>
								<th class="text-center" width="300px">一维标签路径</th>
								<th class="text-center" width="300px">条码</th>
								<th class="text-center" width="400px">操作</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
					
				
					
					
					
					
					
				<!-- 	<ul class="pagination right">
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
				
				
				<!-- 添加采购单明细modal addPurchaseOrderDetailTable-->
				<div class="modal fade" id="addPurchaseOrderDetailTable" tabindex="-1" role="dialog"
					aria-labelledby="add">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel1">添加采购单明细</h4>
							</div>
							<div class="modal-body">
								<ul>

									<li><label><span>资产类别Id:</span></label> <input
										type="text" id="addAssId" value="" /></li>

									<li><label><span>保管人Id:</span></label> <input
										type="text" id="addCustodianId" value="" /></li>

									<li><label><span>上级资产类别Id:</span></label> <input
										type="text" id="addSuperiorId" value=""/></li>

									<li><label><span>单位:</span></label> <input
										type="text" id="addUnit" value="" /></li>
										
									<li><label><span>资产型号:</span></label> <input
										type="text" id="addAssType" value="" /></li>
										
									<li><label><span>资产名称:</span></label> <input
										type="text" id="addAssName" value="" /></li>
									
									<li><label><span>数量:</span></label> <input
										type="text" id="addAmount" value="" /></li>
										
									<li><label><span>备注:</span></label> <input
										type="text" id="addRemarks" value="" /></li>
										
									<li><label><span>制造商:</span></label> <input
										type="text" id="addManufacturer" value="" /></li>
										
									<li><label><span>供应商:</span></label> <input
										type="text" id="addSupplier" value="" /></li>
										
									<li><label><span>单价:</span></label> <input
										type="text" id="addUnivalent" value="" /></li>

								</ul>
							</div>
							<div class="modal-footer">
								<i>
									<button type="button" class="btn btn-default btn-sm"
										data-dismiss="modal">取消</button>
									<button type="button"
										class="btn btn-primary btn-sm addPurchaseOrderDetailBtn"
										data-dismiss="modal">添加</button>
								</i>
							</div>
						</div>
					</div>
				</div>
				
				<!-- 采购单明细modal -->
				<div class="modal fade" id="detailTable" aria-labelledby="edit">
					<div class="modal-dialog" role="document" style="width:1200px;">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel1">采购单明细</h4>
							</div>
						<div>
						<table
						class="table table-bordered table-striped text-center bg-info"
						id="purchaseOrderDetailTable">
						<thead>
							<tr>
								<th class="text-center">序号</th>
								<th class="text-center">资产类别id</th>
								<th class="text-center">采购单Id</th>
								<th class="text-center">保管人Id</th>
								<th class="text-center">上级资产类别Id</th>
								<th class="text-center">单位</th>
								<th class="text-center">资产型号</th>
								<th class="text-center">资产名称</th>
								<th class="text-center">数量</th>
								<th class="text-center">备注</th>
								<th class="text-center">制造商</th>
								<th class="text-center">供应商</th>
								<th class="text-center">单价</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
						</div>	
						</div>
					</div>
				</div>
				


				<!-- 编辑采购单modal -->
				<div class="modal fade" id="edit" tabindex="-1" role="dialog" 
					aria-labelledby="edit">
					<div class="modal-dialog" role="document" >
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
								
									<li><label><span>序号:</span></label> <input type="text"
										id="purchaseOrderId" value="" disabled="disabled" /></li>

									<li><label><span>经办人Id:</span></label> <input
										type="text" id="userId" value="" /></li>

									<li><label><span>采购部门Id:</span></label> <input
										type="text" id="deptId" value="" /></li>

									<li><label><span>采购日期:</span></label> <input readonly
										type="text" id="purchaseDate" value="" data-date-format="yyyy-mm-dd"/></li>

									<li><label><span>采购用途:</span></label> <input
										type="text" id="purchaseUse" value="" /></li>
										
									<li><label><span>状态:</span></label> <input
										type="text" id="status" value="" /></li>

								</ul>
							</div>
							<div class="modal-footer">
								<i>
									<button type="button" class="btn btn-default btn-sm"
										data-dismiss="modal">取消</button>
									<button type="button"
										class="btn btn-primary btn-sm updatePurchaseOrder"
										data-dismiss="modal">保存</button>
								</i>
							</div>
						</div>
					</div>
				</div>
				
				
				<!-- 添加采购单modal-add -->
				<div class="modal fade" id="add" tabindex="-1" role="dialog"
					aria-labelledby="add">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								
								
								<h4 class="modal-title" id="myModalLabel1">添加采购单</h4>
								
							</div>
							<div class="modal-body">
								<ul>

									<li><label><span>经办人Id:</span></label> <input
										type="text" id="addUserId" value="" /></li>

									<li><label><span>采购部门Id:</span></label> <input
										type="text" id="addDeptId" value="" /></li>

									<li><label><span>采购日期:</span></label> <input readonly
										type="text" id="addPurchaseDate" value=""/></li>

									<li><label><span>采购用途:</span></label> <input
										type="text" id="addPurchaseUse" value="" /></li>
										
									<li><label><span>状态:</span></label> <input
										type="text" id="addStatus" value="" /></li>

								</ul>
							</div>
							<div class="modal-footer">
								<i>
									<button type="button" class="btn btn-default btn-sm"
										data-dismiss="modal">取消</button>
									<button type="button"
										class="btn btn-primary btn-sm addPurchaseOrder"
										data-dismiss="modal">添加</button>
								</i>
							</div>
						</div>
					</div>
				</div>
				
				

			</div>
		</div>
</section>

<input type="hidden" id="hiddenPurchaseOrderId" value=""/>

<%@ include file="/jsp/common/footer.jsp"%> 

<script src="<%=request.getContextPath() %>/lib/common/jquery.min.js"></script>

<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/lib/datatable/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath() %>/lib/datepicker/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath() %>/js/asset/assetList.js"></script>

<script type="text/javascript">
$(function(){
	$("#purchaseDate").datepicker({ dateFormat: 'yy-mm-dd' });
	$("#addPurchaseDate").datepicker({ dateFormat: 'yy-mm-dd' });
});
</script>



</body>
</html>