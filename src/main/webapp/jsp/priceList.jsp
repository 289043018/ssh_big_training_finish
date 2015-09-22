<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>客户价格配置列表</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
 <link rel="stylesheet" href="<%=path %>/css/style1.css">
 <script src="<%=path %>/js/jquery-2.1.4.min.js"></script>
 <script src="<%=path %>/js/bootstrap.min.js"></script> 
</head>
<body>
	<div class="container">
		<div class="head">
			<a class="btn btn-primary"
				href="<%= request.getContextPath() %>/Logout_Logout!Logout.do">退出</a>
		</div>
		<div class="body">
			<div class="menu">
				<ul id="mytab" class="nav nav-tabs nav-stacked" role="tablist">
					<li role="presentation"><a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">用户管理<span
							class="glyphicon glyphicon-chevron-right"></span></a>
							<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<s:if test="0==#session.cando">
								<div><a class="button" href="<%=path%>/jsp/createCustomer.jsp">新建客户</a></div>
								</s:if>
								<div><a class="button" href="<%=path%>/jsp/showCustomer.jsp">客户查询</a></div>
							</div>
						</div>
					</li>
					<li role="presentation"><a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">价格管理<span
							class="glyphicon glyphicon-chevron-right"></span></a>
							<div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<div><a class="button" href="<%=path%>/doPriceList_list!list.do">价格配置查询</a></div>
								<div><a class="button" href="<%=path%>/jsp/priceList.jsp">创建价格配置</a></div>
							</div>
						</div>
					</li>
							<li role="presentation"><a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="true" aria-controls="collapseThree">折扣管理<span
							class="glyphicon glyphicon-chevron-right"></span></a>
							<div id="collapseThree" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<div>
						<ul id="mytab" class="nav nav-tabs nav-stacked" role="tablist">
					<li role="presentation"><a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="true" aria-controls="collapseFour">经常性折扣<span
							class="glyphicon glyphicon-chevron-right"></span></a>
							<div id="collapseFour" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<div><a class="button" href="<%=path%>/jsp/normalDiscountList.jsp">经常性折扣查询</a></div>
								<div><a class="button" href="<%= request.getContextPath() %>/doNormalDiscount_toadd!toadd.do">经常性折扣新增</a></div>
							</div>
						</div>
					</li> 
					</ul>
                                </div>
								   
								<div>
<ul id="mytab" class="nav nav-tabs nav-stacked" role="tablist">
					<li role="presentation"><a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="true" aria-controls="collapseFive">一次性折扣<span
							class="glyphicon glyphicon-chevron-right"></span></a>
							<div id="collapseFive" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<div><a class="button" href="<%=path%>/jsp/specialDiscountList.jsp">一次性折扣查询</a></div>
								<div><a class="button" href="<%=path%>/jsp/addSpecialDiscount.jsp">一次性折扣新增</a></div>
								<div><a class="button" href="<%=path%>/jsp/appliedRecordList.jsp">折扣应用记录</a></div>
							</div>
						</div>
					</li> 
					</ul></div>
							</div>
						</div>
					</li>
					<li role="presentation"><a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="true" aria-controls="collapseTwo">用户管理<span
							class="glyphicon glyphicon-chevron-right"></span></a>
							<div id="collapseSix" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">
								<div><a class="button" href="<%=path%>/jsp/createUser.jsp">新建用户</a></div>
								
								</div>
						</div>
								</li> 
				</ul>
			</div>
			<div class="kehuguanli">
				<div class="cust">
					<h3>PriceList管理</h3>
				</div>

				<div class="panel panel-info">
					<div class="panel-heading">
						<div>客户列表</div>
						
						<a class="btn btn-primary btn-md" name="add"
												href="<%= request.getContextPath() %>/doPriceList_toadd!toadd.do">新增配置</a>
<a class="btn btn-primary btn-md" name="add"
												href="<%= request.getContextPath() %>/doPriceList_toadd!toadd.do">查询配置</a>
												<a class="btn btn-primary btn-md" name="add"
												href="<%= request.getContextPath() %>/jsp/PriceListEdit.jsp">修改配置</a>
												<a class="btn btn-primary btn-md" name="add"
												href="<%= request.getContextPath() %>/jsp/layout.jsp">导入/导入excel表</a>
					</div>
					<div class="panel-body">
					<form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/doPriceList_add!add.do?" Method="post" name="loginForm">
                    
										<tr class="success">
							<td>
							<div class="form-group">
									<label class="col-md-4 control-label">客户简称:</label>
									<div class="col-md-4">
										<input type="text" value="GTW" name="cust_code" class="form-control" placeholder="请输入客户简称">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">类型：</label>
									<div class="col-md-4">
										<input type="text" name="type" value="STD"  class="form-control" placeholder="请输入客户类型">
									</div>
								</div>
					
        
                   
                    <div class="form-group">
                        <label class="col-md-4 control-label">客户名称：</label>
                        <div class="col-md-4">
                            <input type="text" name="cust_name" 
											class="form-control" placeholder="请输入客户名称">
                        </div>
                    </div>
								

										
                    <div class="form-group">
                        <label class="col-md-4 control-label">启用状态：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def1"
											class="form-control" value="全部" readonly="readonly" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">序号：</label>
                         <div class="col-md-4">
                            <input type="text" name="id" 
											class="form-control" placeholder="请输入序号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">字段名称：</label>
                         <div class="col-md-4">
                            <input type="text" name="display_name" 
											class="form-control" placeholder="请输入字段名称">
                        </div>
                    </div>
						<div class="table-responsive">
							<table
								class="table table-striped table-bordered table-hover table-condensed">
								<thead>
									<tr class="active">
										<th>PL_YH_ITEM</th>
										<th>有效日期从</th>
										<th>有效日期至</th>
										<th>user_def1</th>
										<th>user_def2</th>
										<th>user_def3</th>
										<th>user_def4</th>
										<th>user_def5</th>
									</tr>
								</thead>
								<tbody>

									<s:iterator  value="om_cust_price_list">
										<tr class="success">
											<td>
											<a class="btn btn-primary btn-sm" name="delet_id"
											href="<%= request.getContextPath() %>/doPriceList_toupdate!toupdate.do?delet_id=${discount_id}">编辑</a>
											<td align="center" name="id">${id}</td>
											<td align="center" name="PL_YH_ITEM">${PL_YH_ITEM}</td>
											<td align="center" name="effective_date_from">${effective_date_from}</td>
											<td align="center" name="effective_date_to">${effective_date_to}</td>
											<td align="center" name="user_def1">${user_def1}</td>
											<td align="center" name="user_def2">${user_def2}</td>
											<td align="center" name="user_def3">${user_def3}</td>
											<td align="center" name="user_def4">${user_def4}</td>
											<td align="center" name="user_def5">${user_def5}</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
					<div class="panel-footer">
						<div class="fenpage">
							<nav class="bottom_nav">
							
							</nav>
						</div>
					</div>
				</div>
	</div>
 	<script src="../js/jquery-2.1.4.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="AJAX.js"></script> 
</body>
</html>