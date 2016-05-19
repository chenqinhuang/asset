<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="col-xs-2 bg-blue">
                <br/>
                <div class="panel-group sidebar-menu" id="accordion" aria-multiselectable="true">
                    <div class="panel panel-default menu-first menu-first-active">
                        <a data-toggle="collapse" data-parent="#accordion" href="index.html" aria-expanded="true"
                           aria-controls="collapseOne">
                            <i class="icon-home icon-large"></i> 主页
                        </a>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true"
                           aria-controls="collapseOne">
                            <i class="icon-user-md icon-large"></i> 资产管理</a>
                        </a>

                        <div id="collapseOne" class="panel-collapse collapse " >
                            <ul class="nav nav-list menu-second">
                                <li><a href="<%=request.getContextPath() %>/jsp/asset/purchaseShow.jsp"><i class="icon-user"></i> 采购入库</a></li>
                                <li><a href="#"><i class="icon-edit"></i> 财务入账</a></li>
                                <li><a href="#"><i class="icon-list"></i> 资产卡片</a></li>
                                <li><a href="<%=request.getContextPath() %>/jsp/asset/assetList.jsp"><i class="icon-list"></i> 资产列表</a></li>
                                <li><a href="#"><i class="icon-edit"></i> 资产领用</a></li>
                                <li><a href="#"><i class="icon-list"></i> 资产归还</a></li>
                                <li><a href="#"><i class="icon-edit"></i> 资产调拨</a></li>                          
                                <li><a href="#"><i class="icon-trash"></i> 资产报废</a></li>
                                <li><a href="#"><i class="icon-list"></i> 资产维修</a></li>
                                <li><a href="#"><i class="icon-list"></i> 资产移交</a></li>
                                <li><a href="#"><i class="icon-edit"></i> 资产盘点</a></li>
                                
                                
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                           aria-expanded="false" aria-controls="collapseTwo">
                            <i class="icon-book icon-large"></i> 统计报表</a>
                        </a>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i> 子选项1</a></li>
                                <li><a href="#"><i class="icon-edit"></i> 子选项2</a></li>
                                <li><a href="#"><i class="icon-trash"></i> 子选项3</a></li>
                                <li><a href="#"><i class="icon-list"></i> 子选项4</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                           aria-expanded="false" aria-controls="collapseThree">
                            <i class="icon-book icon-large"></i> 系统管理</a>
                        </a>

                        <div id="collapseThree" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="<%=request.getContextPath() %>/jsp/sysmgt/staffShow.jsp"><i class="icon-user"></i> 人员管理</a></li>
                                <li><a href="<%=request.getContextPath() %>/jsp/sysmgt/deptShow.jsp"><i class="icon-edit"></i> 部门管理</a></li>
                                <li><a href="<%=request.getContextPath() %>/jsp/sysmgt/assTypeShow.jsp"><i class="icon-check"></i> 资产类别管理</a></li>
                                <li><a href="<%=request.getContextPath() %>/jsp/sysmgt/paramInfoShow.jsp"><i class="icon-list"></i> 参数信息配置</a></li>
                                
                            </ul>
                        </div>
                    </div>
                    
                    <%-- <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour"
                           aria-expanded="false" aria-controls="collapseThree">
                            <i class="icon-book icon-large"></i> 人员管理</a>
                        </a>

                        <div id="collapseFour" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="<%=request.getContextPath() %>/jsp/staff/staffShow.jsp"><i class="icon-user"></i> 人员展示</a></li>
                               
                            </ul>
                        </div>
                    </div> --%>
                </div>
            </div>