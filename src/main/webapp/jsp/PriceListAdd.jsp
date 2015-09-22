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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
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
				href="<%= request.getContextPath() %>/logout.action">退出</a>
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
					<h3>priceList管理</h3>
			    </div>


            <div class="panel panel-info">
					<div class="panel-heading">
						<div>创建价格配置</div>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/doPriceList_add!add.do?" Method="post" name="loginForm">
                    
										<tr class="success">
							<td>
							<div class="form-group">
									<label class="col-md-4 control-label">PL_YH_ITEM:</label>
									<div class="col-md-4">
										<input type="text" name="delet_id" class="form-control" placeholder="请输入PL_YH_ITEM">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">effective_date_from：</label>
									<div class="col-md-4">
										<input type="text" name="effective_date_from"   class="form-control" placeholder="有效期从">
									</div>
								</div>
					
        
                   
                    <div class="form-group">
                        <label class="col-md-4 control-label">effective_date_to：</label>
                        <div class="col-md-4">
                            <input type="text" name="effective_date_to" 
											class="form-control" placeholder="有效期至">
                        </div>
                    </div>
								

										
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def1：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def1"
											class="form-control" placeholder="请输入配置字段1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def2：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def2" 
											class="form-control" placeholder="请输入配置字段2">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def3：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def3" 
											class="form-control" placeholder="请输入配置字段3">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-md-4 control-label">user_def4：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def4" 
											class="form-control" placeholder="请输入配置字段4">
                        </div>
                    </div>
                                         <div class="form-group">
                        <label class="col-md-4 control-label">user_def5：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def5" 
											class="form-control" placeholder="请输入配置字段5">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def6：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def6"
											class="form-control" placeholder="请输入配置字段6">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def7：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def7" 
											class="form-control" placeholder="请输入配置字段7">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def8：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def8" 
											class="form-control" placeholder="请输入配置字段8">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-md-4 control-label">user_def9：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def9"
											class="form-control" placeholder="请输入配置字段9">
                        </div>
                    </div>
                                         <div class="form-group">
                        <label class="col-md-4 control-label">user_def10：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def10" 
											class="form-control" placeholder="请输入配置字段10">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def11：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def11" 
											class="form-control" placeholder="请输入配置字段11">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def12：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def12" 
											class="form-control" placeholder="请输入配置字段12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def13：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def13" 
											class="form-control" placeholder="请输入配置字段13">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-md-4 control-label">user_def14：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def14" 
											class="form-control" placeholder="请输入配置字段14">
                        </div>
                    </div>
                                         <div class="form-group">
                        <label class="col-md-4 control-label">user_def15：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def15" 
											class="form-control" placeholder="请输入配置字段15">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def16：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def16" 
											class="form-control" placeholder="请输入配置字段16">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def17：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def17" 
											class="form-control" placeholder="请输入配置字段17">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def18：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def18" 
											class="form-control" placeholder="请输入配置字段18">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-md-4 control-label">user_def19：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def19" 
											class="form-control" placeholder="请输入配置字段19">
                        </div>
                    </div>
                                         <div class="form-group">
                        <label class="col-md-4 control-label">user_def20：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def20" 
											class="form-control" placeholder="请输入配置字段20">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def21：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def21" 
											class="form-control" placeholder="请输入配置字段21">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def22：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def22" 
											class="form-control" placeholder="请输入配置字段22">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def23：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def23" 
											class="form-control" placeholder="请输入配置字段23">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-md-4 control-label">user_def24：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def24" 
											class="form-control" placeholder="请输入配置字段24">
                        </div>
                    </div>
                                         <div class="form-group">
                        <label class="col-md-4 control-label">user_def25：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def25" 
											class="form-control" placeholder="请输入配置字段25">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def26：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def26"
											class="form-control" placeholder="请输入配置字段26">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def27：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def27" 
											class="form-control" placeholder="请输入配置字段27">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def28：</label>
                         <div class="col-md-4">
                            <input type="text" name="user_def28" 
											class="form-control" placeholder="请输入配置字段28">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-md-4 control-label">user_def29：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def29" 
											class="form-control" placeholder="请输入配置字段29">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">user_def30：</label>
                        <div class="col-md-4">
                            <input type="text" name="user-def30"
											class="form-control" placeholder="请输入配置字段30">
                        </div>
                    </div>
</td>
                    
                    </tr>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-md-4">
                            <button type="submit"
											class="btn btn-default">添加</button>
                            <button type="submit"
											class="btn btn-default">取消</button>
                        </div>
                    </div>
                
							</form>
							</div>
						</div>
					</div>
				</div>








			</div>
		</div>
	</div>
	
	<script src="../js/jquery-2.1.4.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="AJAX.js"></script>
</body>
</html>