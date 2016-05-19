/**
 * @author 黄平平
 * @date 
 */
$(document).ready(function () {

    var datatables = $("#paramInfoTable").DataTable({
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
                "sFirst": " <i class=\"fa fa-angle-double-left\"></i> ",
                "sPrevious": " <i class=\"fa fa-angle-left\"></i> ",
                "sNext": " <i class=\"fa fa-angle-right\"></i> ",
                "sLast": " <i class=\"fa fa-angle-double-right\"></i> "
            }
        },
        "aLengthMenu": [[10, 15, 20], [10, 15, 20]],
        "bStateSave": false,
        "bProcessing": true,
        "bServerSide": true,
        //条件查询
        "ajax": {
            "url": "getParaInfoList",
            "data": function (data) {
//                data.condTitle = $("#condTitle").val();
//                data.condSequence = $("#condSequence").val();
//                data.condInitiateTimeFrom = $("#condInitiateTimeFrom").val();
//                data.condInitiateTimeTo = $("#condInitiateTimeTo").val();
            }
        },
        "sDom": "t<'row'<'col-sm-4'i><'col-sm-2'l><'col-sm-6'p>>",
        "sPaginationType": "full_numbers",
        sServerMethod: "POST",
        //"aaSorting": [[ 1, "asc" ]],
        "aoColumns": [
            {"mData": "paramInfoId", 'sClass': '', "bSortable": false},
            {"mData": "paramName", 'sClass': '', "bSortable": false},
            {"mData": "paramValue", 'sClass': '', "bSortable": false},
            {"mData": "pdParamId", 'sClass': '', "bSortable": false},
            {"mData": "pdParamName", 'sClass': '', "bSortable": false},
            {
                "mData": function (row, type, val) {

                    var btn = "";
                    btn += '<a href="" class="btn btn-primary btn-sm edit-paramInfo" title="编辑" data-id="' + row.paramInfoId + '" data-toggle="modal">编辑</a>';
                    btn += "&nbsp;&nbsp";
                    btn += '<a href="" class="btn btn-primary btn-sm delete-paramInfo" title="删除" data-id="' + row.paramInfoId + '" data-toggle="modal">删除</a> ';

                    return '<div class="toolmenu">' + btn + '</div>';

                },
                "bSortable": false
            }
//            {
//                "mData": function (row, type, val) {
//                    var dataObj = new Date(); //日期对象
//                    dataObj.setTime(row.createdStamp); //设置日期时间，也就是你的毫秒
//                    var date_str = dataObj.getFullYear() + "年" + (dataObj.getMonth() + 1) + "月" + dataObj.getDate() + "日 " + checkTime(dataObj.getHours()) + ":" + checkTime(dataObj.getMinutes()) + ":" + checkTime(dataObj.getSeconds());
//                    return date_str;
//                },
//
//                "bSortable": false
//            },
//            {
//                "mData": function (row, type, val) {
//                    var sex = '';
//                    switch ( row.sex ){
//                        case 0 : sex = "女";break;
//                        case 1 : sex = "男" ;break;
//                        default :sex = row.sex;break;
//                    }
//                    return sex;
//                },
//                "bSortable": false
//            },
//            {"mData": "status", 'sClass': '', "bSortable": false},
            
        ],
        "fnInitComplete": function () {
            //初始化完成回调
        },
        "fnRowCallback": function (nRow, aData, iDisplayIndex) {
        }

    });


    function tableReload() {
        datatables.ajax.reload();
    }

    function checkTime(time) {
        var time;
        if (time < 10) {
            time = "0" + time;
        }
        return time;
    }
    
    
     //添加按钮相应事件
    $(document).on('click', '.openAdd', function () {
    	
    	
    	$("#add").modal('show');
    	

    });
    

  //添加
    $(document).on('click', '.addParamInfo', function () {

//    	$("#edit").modal('show');
    	
    	$.ajax({
    		type: "POST",
    		url: "addParaInfo",
    		data: {


    			paramName:$("#addParamName").val(),
    			paramValue:$("#addParamValue").val(),
    			pdParamId:$("#addPdParamId").val(),
    			pdParamName:$("#addPdParamName").val()
    					

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
    
    
    

    
  //编辑信息
    $(document).on('click', '.edit-paramInfo', function () {
        var paramInfoId = $(this).attr("data-id");
//        alert("111");
        $.ajax({
            type: "POST",
            url: "getParaInfoById",
            data: {
                
            	paramInfoId: paramInfoId
            },
            success: function (data) {
            	
            	if("get"==data.msg){
            		
            		$("#paramInfoId").val(data.paramInfo.paramInfoId);
            		$("#paramName").val(data.paramInfo.paramName);
            		$("#paramValue").val(data.paramInfo.paramValue);
            		$("#pdParamId").val(data.paramInfo.pdParamId);
            		$("#pdParamName").val(data.paramInfo.pdParamName);
            		
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
    $(document).on('click', '.updateParamInfo', function () {
//    	var userId = $(this).attr("data-id");

    	$.ajax({
    		type: "POST",
    		url: "saveOrUpdateParaInfo",
    		data: {

    			paramInfoId: $("#paramInfoId").val(),
    			paramName:$("#paramName").val(),
    			paramValue:$("#paramValue").val(),
    			pdParamId:$("#pdParamId").val(),
    			pdParamName:$("#pdParamName").val()
    					

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


  

    
    

    //删除模块
    $(document).on('click', '.delete-paramInfo', function () {
        var paramInfoId = $(this).attr("data-id");
//        alert("111");
        $.ajax({
            type: "POST",
            url: "deleteParaInfo",
            data: {
                
            	paramInfoId: paramInfoId
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

});






