/**
 * @author 黄平平
 * @date 
 */
$(document).ready(function () {

	var datatables = $("#assetTable").DataTable({
		"oLanguage": { // 汉化
			"sProcessing": "正在加载数据...",
			"sLengthMenu": "显示 _MENU_ 条 ",
			"sZeroRecords": "没有您要搜索的内容",
			"sInfo": "显示第_START_ 到第 _END_ 条记录，总记录数为 _TOTAL_ 条",
			"sInfoEmpty": "记录数为0",
			"sInfoFiltered": "(全部记录数 _MAX_  条)",
			"sInfoPostFix": "",
			"sSearch": "搜索 ",
			"sUrl": "",
			"oPaginate": {
				"sFirst": " <i class=\"fa fa-angle-double-left\"></i> 首页 ",
				"sPrevious": " <i class=\"fa fa-angle-left\"></i> 上一页 ",
				"sNext": " 下一页 <i class=\"fa fa-angle-right\"></i> ",
				"sLast": " 末页 <i class=\"fa fa-angle-double-right\"></i> "
			}
		},
		"aLengthMenu": [[10, 15, 20], [10, 15, 20]],
		"bStateSave": false,
		"bProcessing": true,
		"bServerSide": true,
		"scrollX": "100%",
		
		//条件查询
		"ajax": {
			"url": "getAssetList",
			"data": function (data) {
//				data.condTitle = $("#condTitle").val();
//				data.condSequence = $("#condSequence").val();
//				data.condInitiateTimeFrom = $("#condInitiateTimeFrom").val();
//				data.condInitiateTimeTo = $("#condInitiateTimeTo").val();
			}
		},
		"sDom": "t<'row'<'col-sm-4'i><'col-sm-2'l><'col-sm-6'p>>",
		"sPaginationType": "full_numbers",

		sServerMethod: "POST",
		//"aaSorting": [[ 1, "asc" ]],
		"aoColumns": [
		              {"mData": "asId", 'sClass': '', "bSortable": false},
		              //资产类别Id
		              {"mData": "assTypeByAsTypeId.asTypeId", 'sClass': '', "bSortable": false},
		              //采购部门Id
		              {"mData": "deptByBuyDeptId.deptId", 'sClass': '', "bSortable": false},
		              //使用人部门Id
		              {"mData": "deptByUserDeptId.deptId", 'sClass': '', "bSortable": false},
                      //保管人Id
		              {"mData": "userByStoremanId.userId", 'sClass': '', "bSortable": false},
		              //财务入账人Id
		              {"mData": "userByFinanceManId.userId", 'sClass': '', "bSortable": false},
		              //采购单明细
		              {"mData": "purchaseOrderDetail.purchaseOrderDetailId", 'sClass': '', "bSortable": false},
		              //上级资产类别Id
		              {"mData": "assTypeByPdAsTypeId.asTypeId", 'sClass': '', "bSortable": false},
		              
		              {"mData": "cardNo", 'sClass': '', "bSortable": false},
		              {"mData": "useStatus", 'sClass': '', "bSortable": false},
		              {"mData": "inStatue", 'sClass': '', "bSortable": false},
		              {"mData": "isInBill", 'sClass': '', "bSortable": false},
		              {"mData": "specificationsModels", 'sClass': '', "bSortable": false},
		              {"mData": "assName", 'sClass': '', "bSortable": false},
		              {
		            	  "mData": function (row, type, val) {
		            		  return row.financeBiiDate.substr(0,10);
		            	  },
		            	  "bSortable": false
		              },
		              {"mData": "financeCode", 'sClass': '', "bSortable": false},
		              {"mData": "assCode", 'sClass': '', "bSortable": false},
		              {"mData": "manufacturer", 'sClass': '', "bSortable": false},
		              {"mData": "supplier", 'sClass': '', "bSortable": false},
		              {"mData": "inWarehouseDate", 'sClass': '', "bSortable": false},
		              {"mData": "unit", 'sClass': '', "bSortable": false},
		              {"mData": "amount", 'sClass': '', "bSortable": false},
		              {"mData": "remark", 'sClass': '', "bSortable": false},
		              {"mData": "price", 'sClass': '', "bSortable": false},
		              {"mData": "isPrint", 'sClass': '', "bSortable": false},
		              {"mData": "oneLabelPath", 'sClass': '', "bSortable": false},
		              {"mData": "barCode", 'sClass': '', "bSortable": false},
		              {
		            	  "mData": function (row, type, val) {

		            		  var btn = "";
		            		  btn += '<a href="" class="btn btn-primary btn-sm addPurchaseOrderDetail" title="添加详情" data-id="' + row.purchaseOrderId + '" data-toggle="modal">添加明细</a>';
		            		  btn += "&nbsp;&nbsp";
		            		  btn += '<a href="" class="btn btn-primary btn-sm purchaseOrderDetail" title="查看详情" data-id="' + row.purchaseOrderId + '" data-toggle="modal">查看详情</a>';
		            		  btn += "&nbsp;&nbsp";
		            		  btn += '<a href="" class="btn btn-primary btn-sm addAsset" title="确认入库" data-id="' + row.purchaseOrderId + '" data-toggle="modal">确认入库</a>';
		            		  btn += "&nbsp;&nbsp";
		            		  btn += '<a href="" class="btn btn-primary btn-sm edit-PurchaseOrder" title="编辑" data-id="' + row.purchaseOrderId + '" data-toggle="modal">编辑</a>';
		            		  btn += "&nbsp;&nbsp";
		            		  btn += '<a href="" class="btn btn-primary btn-sm delete-PurchaseOrder" title="删除" data-id="' + row.purchaseOrderId + '" data-toggle="modal">删除</a> ';

		            		  return '<div class="toolmenu">' + btn + '</div>';

		            	  },
		            	  "bSortable": false
		              }

		              ],
		              "fnInitComplete": function () {
		            	  //初始化完成回调
		              },
		              "fnRowCallback": function (nRow, aData, iDisplayIndex) {
		              }

	});


	//添加按钮相应事件
	$(document).on('click', '.openAdd', function () {
		$("#add").modal('show');
	});

	//弹出查看详情列表
	$(document).on('click', '.purchaseOrderDetail', function () {
		var purchaseOrderId = $(this).attr("data-id");
		$("#hiddenPurchaseOrderId").val(purchaseOrderId),
		detailDatatables.ajax.reload();
		$("#detailTable").modal('show');
	});

	//弹出添加采购单明细框，顺便附带purchaseOrderId的值到隐藏域中
	$(document).on('click', '.addPurchaseOrderDetail', function () {
		var purchaseOrderId = $(this).attr("data-id");

		$("#hiddenPurchaseOrderId").val(purchaseOrderId),
		$("#addPurchaseOrderDetailTable").modal('show');
	});

	//添加采购单明细
	$(document).on('click', '.addPurchaseOrderDetailBtn', function () {


		$.ajax({
			type: "POST",
			url: "addPurchaseOrderDetail",
			data: {

				purchaseOrderId:$("#hiddenPurchaseOrderId").val(),
				asTypeId:$("#addAssId").val(),
				deptId:$("#addCustodianId").val(),
				userId:$("#addSuperiorId").val(),
				unit:$("#addUnit").val(),
				assType:$("#addAssType").val(),
				assName:$("#addAssName").val(),
				amount:$("#addAmount").val(),
				remark:$("#addRemarks").val(),
				manufacturer:$("#addManufacturer").val(),
				supplier:$("#addSupplier").val(),
				price:$("#addUnivalent").val(),

			},
			success: function (data) {

				if("success"==data){
					alert("添加成功！");
					datatables.ajax.reload();

				}else{
					alert("添加失败！");
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
			}
		});
	});



	//添加采购单
	$(document).on('click', '.addPurchaseOrder', function () {

//		$("#edit").modal('show');

		$.ajax({
			type: "POST",
			url: "addPurchaseOrder",
			data: {

//				asTypeId:$("#asTypeId").val(),
				userId:$("#addUserId").val(),
				deptId:$("#addDeptId").val(),
				purchaseDate:$("#addPurchaseDate").val(),
				purchaseUse:$("#addPurchaseUse").val(),
				status:$("#addStatus").val()

			},
			success: function (data) {

				if("success"==data){
					alert("添加成功！");
					datatables.ajax.reload();

				}else{
					alert("添加失败！");
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
			}
		});
	});



	//点击编辑
	$(document).on('click', '.edit-PurchaseOrder', function () {
		var purchaseOrderId = $(this).attr("data-id");

		$.ajax({
			type: "POST",
			url: "getPurchaseOrderById",
			data: {

				purchaseOrderId: purchaseOrderId
			},
			success: function (data) {

				if("get"==data.msg){

					$("#purchaseOrderId").val(data.purchaseOrderInfo.purchaseOrderId);
					$("#userId").val(data.purchaseOrderInfo.user.userId);
					$("#deptId").val(data.purchaseOrderInfo.dept.deptId);
					$("#purchaseDate").val(data.purchaseOrderInfo.purchaseDate.substr(0,10));
					$("#purchaseUse").val(data.purchaseOrderInfo.purchaseUse);
					$("#status").val(data.purchaseOrderInfo.status);


					$("#edit").modal('show');

				}else{
					alert("编辑失败！");
				}

			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
			}
		});
	});


	//更新信息
	$(document).on('click', '.updatePurchaseOrder', function () {

		$.ajax({
			type: "POST",
			url: "saveOrUpdatePurchaseOrder",
			data: {

				purchaseOrderId:$("#purchaseOrderId").val(),
				userId:$("#userId").val(),
				deptId:$("#deptId").val(),
				purchaseDate:$("#purchaseDate").val(),
				purchaseUse:$("#purchaseUse").val(),
				status:$("#status").val()


			},
			success: function (data) {

				if("success"==data){
					alert("更新成功！");
					datatables.ajax.reload();

				}else{
					alert("更新失败！");
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
			}
		});
	});


	//删除采购单
	$(document).on('click', '.delete-PurchaseOrder', function () {
		var purchaseOrderId = $(this).attr("data-id");
		$.ajax({
			type: "POST",
			url: "deletePurchaseOrder",
			data: {
				purchaseOrderId: purchaseOrderId
			},
			success: function (data) {
				if("delete"==data){
					datatables.ajax.reload();
					alert("删除成功");
				}else{
					alert("删除失败");
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
			}
		});
	});





//	//采购单明细列表
	var detailDatatables = $("#purchaseOrderDetailTable").DataTable({
		"oLanguage": { // 汉化
			"sProcessing": "正在加载数据...",
			"sLengthMenu": "显示 _MENU_ 条 ",
			"sZeroRecords": "没有您要搜索的内容",
			"sInfo": "显示第_START_ 到第 _END_ 条记录，总记录数为 _TOTAL_ 条",
			"sInfoEmpty": "记录数为0",
			"sInfoFiltered": "(全部记录数 _MAX_  条)",
			"sInfoPostFix": "",
			"sSearch": "搜索 ",
			"sUrl": "",
			"oPaginate": {
				"sFirst": " <i class=\"fa fa-angle-double-left\"></i> 首页 ",
				"sPrevious": " <i class=\"fa fa-angle-left\"></i> 上一页 ",
				"sNext": " 下一页 <i class=\"fa fa-angle-right\"></i> ",
				"sLast": " 末页 <i class=\"fa fa-angle-double-right\"></i> "
			}
		},
		"aLengthMenu": [[10, 15, 20], [10, 15, 20]],
		"bStateSave": false,
		"bProcessing": true,
		"bServerSide": true,
		//条件查询
		"ajax": {
			"url": "getPurchaseOrderDetailList",
			"data": function (data) {

				data.purchaseOrderId = $("#hiddenPurchaseOrderId").val();
//				data.condSequence = $("#condSequence").val();
//				data.condInitiateTimeFrom = $("#condInitiateTimeFrom").val();
//				data.condInitiateTimeTo = $("#condInitiateTimeTo").val();
			}
		},
		"sDom": "t<'row'<'col-sm-4'i><'col-sm-2'l><'col-sm-6'p>>",
		"sPaginationType": "full_numbers",
		sServerMethod: "POST",
		//"aaSorting": [[ 1, "asc" ]],
		"aoColumns": [
		              {"mData": "purchaseOrderDetailId", 'sClass': '', "bSortable": false},
//		              资产类别Id
		              {"mData": "assTypeByAsTypeId.asTypeId", 'sClass': '', "bSortable": false},
		              {"mData": "purchaseOrder.purchaseOrderId", 'sClass': '', "bSortable": false},
		              {"mData": "user.userId", 'sClass': '', "bSortable": false},
//		              上级资产类别Id
		              {"mData": "assTypeByPdAsTypeId.pdAsTypeId", 'sClass': '', "bSortable": false},
		              {"mData": "unit", 'sClass': '', "bSortable": false},
		              {"mData": "assType", 'sClass': '', "bSortable": false},
		              {"mData": "assName", 'sClass': '', "bSortable": false},
		              {"mData": "amount", 'sClass': '', "bSortable": false},
		              {"mData": "remark", 'sClass': '', "bSortable": false},
		              {"mData": "manufacturer", 'sClass': '', "bSortable": false},
		              {"mData": "supplier", 'sClass': '', "bSortable": false},
		              {"mData": "price", 'sClass': '', "bSortable": false},
		              {
		            	  "mData": function (row, type, val) {

		            		  var btn = "";
//		            		  btn += '<a href="" class="btn btn-primary btn-sm edit-PurchaseOrderDetail" title="编辑" data-id="' + row.purchaseOrderDetailId + '" data-toggle="modal">编辑</a>';
//		            		  btn += "&nbsp;&nbsp";
		            		  btn += '<a href="" class="btn btn-primary btn-sm delete-PurchaseOrderDetail" title="删除" data-id="' + row.purchaseOrderDetailId + '" data-toggle="modal">删除</a> ';

		            		  return '<div class="toolmenu">' + btn + '</div>';

		            	  },
		            	  "bSortable": false
		              }

		              ],
		              "fnInitComplete": function () {
		            	  //初始化完成回调
		              },
		              "fnRowCallback": function (nRow, aData, iDisplayIndex) {
		              }

	});



	//删除采购单明细
	$(document).on('click', '.delete-PurchaseOrderDetail', function () {
		var purchaseOrderDetailId = $(this).attr("data-id");
//		alert("111");
		$.ajax({
			type: "POST",
			url: "deletePurchaseOrderDetail",
			data: {

				purchaseOrderDetailId: purchaseOrderDetailId
			},
			success: function (data) {
				if("delete"==data){
					detailDatatables.ajax.reload();
					alert("删除成功");
				}else{
					alert("删除失败");
				}


			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
			}
		});
	});





	//获取数据库中用户
	$.ajax({
		type: "POST",
		url: "showUserList",
		data: {

		},
		dataType: "json",
		success: function(data){

		}
	});





});






