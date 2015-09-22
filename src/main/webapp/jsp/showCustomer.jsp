<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath(); %>
    <%@ page isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> 

 <link rel="stylesheet" href="<%=path %>/css/style1.css"> 
  <link rel="stylesheet" href="<%=path %>/css/CustomerShow.css"> 
 <script src="<%=path %>/js/jquery-2.1.4.min.js"></script>
 <script src="<%=path %>/js/bootstrap.min.js"></script> 
<script type="text/javascript">
/* $(document).ready(function(){
	$("#doit").attr({readonly:readonly});
});
 */

$(document).ready(function(){
	$("#btn").click(function(){
		   var str_data=$("#form1 input").map(function(){
				  return ($(this).attr("name")+'='+$(this).val());
				}).get().join("&");
		   /* alert( "Data Saved: " + str_data );
		alert("开始"); */
		  $("#customer").html("正在查找数据中....."); 
		$.ajax({
			   type: "POST",
			   url: "Text_findByName!findByName.do?"+str_data,
			   dataType:"json",
			   success:function(data) {
					var row="<tr><td>序号</td><td>客户名</td><td>客户代码</td><td>客户类型</td><td>市场区域</td><td>业务员</td><td>业务经理</td><td>状态</td><td>操作</td><td>确认</td></tr>";
					var i=0;
						 $("#customer").html(""); 
					/* alert("返回数据");  */
						
					 $.each(data,function(entryIndex,entry) {//遍历JSON
										row += "<tr><td>"
												+ i++
												+ "</td><td>"
												+ entry.customer_name
												+ "</td><td>"
												+ entry.customer_code
												+ "</td><td>"
												+ entry.Type
												+ "</td><td>"
												+ entry.market_area
												+ "</td><td>"
												+ entry.bussiness_assistant
												+ "</td><td>"
												+ entry.bussiness_manager
												+ "</td><td>"
												+ entry.status
												+ "</td><td>"
												+ "<a class='btn btn-primary' href='Text_toshowdetail!toshowdetail.do?cust_id="
												+entry.cust_id
												+"'>查看</a>"	
												+ "<s:if test='0==#session.cando'><a class='btn btn-primary' href='Text_toupdatedetail!toupdatedetail.do?cust_id="
												+entry.cust_id
												+"'>更新</a></s:if></td><td>"	
												+ "<s:if test='1==#session.cando'><a class='btn btn-primary doit' href='Text_doit!doit.do?cust_id="
												+entry.cust_id
												+"'>确认</a></s:if>"
												+ "</td></tr><br>";
									});
					 $("#customer").html(row);
				}
			});
	});
	
});


    </script>
	

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
					<h3>客户管理</h3>
				</div>

				<div class="panel panel-info">
					<div class="panel-heading">
						<div>客户查询</div>
					</div>
					<div class="panel-body">
						<div class="table-responsive">

							<form id="form1" Method="post">

								<div class="col-md-4">
									<label style="width: 70px">客户名称：</label>
									
										
									
									 <input type="text" name="customer_name" placeholder="客户名称" /> 

								</div>
								<div class="col-md-4">
									<label style="width: 70px">客户简称：</label> <input type="text"
										name="customer_code" placeholder="客户简称" />
								</div>
								<div class="col-md-4">
									<label style="width: 70px">类型：</label> <input type="text"
										name="type" placeholder="类型" />
								</div>
								<div class="col-md-4">
									<label style="width: 70px">状态：</label> <input type="text"
										name="status" placeholder="待确认" />
								</div>
								<div class="col-md-4">
									<label style="width: 70px">集团公司：</label> <input type="text"
										name="group_company" placeholder="集团公司" />
								</div>
								<div class="col-md-4">
									<label style="width: 70px">总公司：</label> <input type="text"
										name="corporation" placeholder="总公司" />
								</div>

							</form>
							<td><button id="btn" class="col-sm-offset-5">提交查询</button></td>


							 
							<table id="customer" class="table table-bordered table-hover table-condensed ">
							
						</table>
						</div>
					</div>
				</div>
			</div>
	</div>
	</div>



</body>
</html>