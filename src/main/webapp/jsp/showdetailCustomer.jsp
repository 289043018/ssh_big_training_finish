<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%String path = request.getContextPath(); %>
    <%@ page isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户详细信息</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" href="<%=path %>/css/style1.css">
 <link rel="stylesheet" href="<%=path %>/css/showdetail.css ">
 <script src="<%=path %>/js/jquery-2.1.4.min.js"></script>
 <script src="<%=path %>/js/bootstrap.min.js"></script> 

<script type="text/javascript">

 $(document).ready(function(){
/* 	alert("开始ajax"),
	alert($("input[name='show_id']").val()), */
	alert("正在加载数据，请稍后...."),
		$.ajax({
			   type: "POST",
			   url: "Text_showdetail!showdetail.do?cust_id="+$("input[name='show_id']").val(),
			   dataType:"json",
			   success:function(data) {
				  /*  加载客户信息 */
					$("input[name='customer_name']").val(data.customer_name);
					$("input[name='customer_code']").val(data.customer_code);
					$("input[name='type']").val(data.type);
					$("input[name='group_company']").val(data.group_company);
					$("input[name='corporation']").val(data.corporation);
					
					
					/* 加载地址信息 */
					$("input[name='country']").val(data.country);
					$("input[name='state']").val(data.state);
					$("input[name='city']").val(data.city);
					$("input[name='port_of_destination']").val(data.port_of_destination);
					$("input[name='address1']").val(data.address1);
					$("input[name='address2']").val(data.address2);
					$("input[name='postcode']").val(data.postcode);
					$("input[name='shipping_mark']").val(data.shipping_mark);
					$("input[name='status']").val(data.status);
					$("input[name='inactive_date']").val(data.inactive_date);
					
					
					
					/* 加载付款信息 */
					$("input[name='invoice_group']").val(data.invoice_group);
					$("input[name='markup_name']").val(data.markup_name);
					$("input[name='currency']").val(data.currency);
					$("input[name='payment_term']").val(data.payment_term);
					$("input[name='price_term1']").val(data.price_term1);
					$("input[name='price_term2']").val(data.price_term2);
					$("input[name='price_term3']").val(data.price_term3);
					$("input[name='discount_name']").val(data.discount_name);
					
					
					
					/* 加载组织信息 */
					$("input[name='market_area']").val(data.market_area);
					$("input[name='bussiness_manager']").val(data.bussiness_manager);
					$("input[name='bussiness_assistant']").val(data.bussiness_assistant);
					
					/* 加载联系人信息 */
					$("input[name='mailfrom']").val(data.mailfrom);
					$("input[name='prepr_mailto']").val(data.prepr_mailto);
					$("input[name='po_mailto']").val(data.po_mailto);
					$("input[name='ocpi_mailto']").val(data.ocpi_mailto);
					$("input[name='inv_pklist_mailto']").val(data.inv_pklist_mailto);

				}
			});
			alert("数据加载完毕！")
			
			$("#queren").click(
					function() {
						$.ajax({
							type : "POST",
							url: "Text_showdetail!showdetail.do?cust_id="+$("input[name='show_id']").val(),
							dataType : "json",
							success : function() {
								alert("保存成功");
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
						<div>客户详细信息</div>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<input id="cust_id" type=hidden value="${cust_id}" name="show_id"/> 
<!-- type=hidden  -->

<div class="customer" >

</div>
<form action="<%=path %>/Text_create_customer!create_customer.do" Method="POST">

								<div class="col-md-4">
									<label style="width: 70px">客户名称：</label> <input type="text"
										name="customer_name" class="required" readonly="readonly"/>

								</div>
								
								<div class="col-md-4">
									<label style="width: 70px">客户简称：</label> <input type="text"
										name="customer_code"  readonly="readonly"/>
								</div>
								<div class="col-md-4">
									<label style="width: 70px">类型：</label> <input type="text"
										name="type" readonly="readonly"/>
								</div>
								<div class="col-md-4">
									<label style="width: 70px">状态：</label> <input type="text"
										name="status"readonly="readonly"/>
								</div>
								<div class="col-md-4">
									<label style="width: 70px">集团公司：</label> <input type="text"
										name="group_company"  readonly="readonly"/>
								</div>
								<div class="col-md-4">
									<label style="width: 70px">总公司：</label> <input type="text"
										name="corporation"  readonly="readonly" />
								</div>
								<br>

								<div id="u4" class="ax_horizontal_line">
									<img alt="分割线" src="../img/u104_line.png" 
										height="5" width="900">
								</div>
								




								<label style="width: 70px">地址信息：</label> <br>

								<div >
									<label style="width: 70px" class="col-sm-offset-3">*国家：</label>
									<input type="text" name="country" readonly="readonly"
										class="required" />
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										州/省：</label> <input type="text" name="state" readonly="readonly" />
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3"> *
										城市：</label> <input type="text" name="city" readonly="readonly"
										class="required" />
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										*目的巷：</label> <input type="text" readonly="readonly"
										name="port_of_destination" class="required">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										*地址1：</label> <input readonly="readonly" type="text" name="address1"
										class="required">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">地址2：</label>
									<input type="text" readonly="readonly" name="address2">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">邮编：</label>
									<input type="text" readonly="readonly" name="postcode">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										*唛头：</label> <input type="text" readonly="readonly"
										name="shipping_mark" class="required">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										状态：</label> <input type="text" readonly="readonly" name="status"
										value="待确认" readonly="readonly">
										<s:if test='1==#session.cando'>
										<a class="btn btn-primary doit" href="Text_doit!doit.do?cust_id=${cust_id}">确认</a>
										</s:if>
										
										
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										失效日期：</label> <input type="text" name="inactive_date"
										readonly="readonly" >
								</div>
								<br>
								<div id="u4" class="ax_horizontal_line">
									<img alt="分割线" src="../img/u104_line.png" 
										height="5" width="900">
								</div>
								

							<label style="width: 70px">付款信息：</label>	<br>
								
								
							<div class="payment_info col-sm-offset-2">
							
							<div>
									<div class="payment_inline">
									<label style="width: 160px" >所属发票组：</label> 
										<input type="text" readonly="readonly" name="invoice_group">
									</div> 
									<div class="payment_inline">
									<label style="width: 160px">* 通用加价条款：</label> 
										<input type="text" readonly="readonly" name="markup_name" class="required"> 
									
									</div>
									
								</div>
							<div>
									<div class="payment_inline">
									<label style="width: 160px" > * 结算货币：</label> 
										<input type="text" readonly="readonly" name="currency" class="required" maxlength="3"> 
									</div> 
									<div class="payment_inline">
									<label style="width: 160px">  *一般折扣：</label> 
										<input type="text" readonly="readonly" name="discount_name" class="required"> 
									</div>
									
								</div>
							<div>
									<label style="width: 160px" >* 付款方法：</label> 
										<input type="text" readonly="readonly" name="payment_term" class="required" maxlength="3"> 
						
								</div>
							<div>
									<label style="width: 160px" >     价格条款1：</label> 
										<input type="text" readonly="readonly" name="price_term1"> 
								</div>
							<div>
									<label style="width: 160px" >      价格条款2：</label> 
										<input type="text" readonly="readonly" name="price_term2"> 
								</div>
							<div>
									<label style="width: 160px" >价格条款3：</label> 
										<input type="text" readonly="readonly" name="price_term3">
								</div>	
							
							
							
							</div>
							<br>		
								
							
		 
		 
		 <div id="u4" class="ax_horizontal_line">
        <img alt="分割线" src="../img/u104_line.png" height="5" width="900">
      </div>
		
			<label style="width: 70px">组织信息：</label> <br>
				<div class="col-sm-offset-2">
					<div>
									<label style="width: 160px" >* 所属TEAM：</label> 
										  <input type="text" name="market_area" readonly="readonly" class="required">  
								</div>	
					<div>
									<label style="width: 160px" >* 业务经理：</label> 
										 <input type="text" readonly="readonly" name="bussiness_manager" class="required">
								</div>	
					<div>
									<label style="width: 160px" >* 业务助理： </label> 
										  <input type="text" readonly="readonly" name="bussiness_assistant" class="required">
								</div>	
				
				
				</div><br>

		
		 			
		 
		    
		  
		 
		 <div id="u4" class="ax_horizontal_line">
        <img alt="分割线" src="../img/u104_line.png"  height="5" width="900">
      </div>
      
      
      <label style="width: 100px">联系人信息：</label> <br>
				<div class="col-sm-offset-2">
					<div>
									<label style="width: 160px" > 发件人邮箱：</label> 
										  <input type="text" readonly="readonly" name="mailfrom">
								</div>	
					<div>
									<label style="width: 160px" >Pre PO 收件人：</label> 
										 <input type="text" readonly="readonly" name="prepr_mailto"> 
								</div>	
					
					<div>
									<label style="width: 160px" >PO 收件人：</label> 
										  <input type="text" readonly="readonly" name="po_mailto"> 
								</div>	
					<div>
									<label style="width: 160px" >OC/PI收件人：</label> 
										  <input type="text" readonly="readonly" name="ocpi_mailto"> 
								</div>	
					<div>
									<label style="width: 160px" >INV/Packing list 收件：</label> 
										 <input type="text" readonly="readonly" name="inv_pklist_mailto"> 
								</div>	
				
				
				</div>
      
		 <br>
		  
		
		 
		   
		

	</form>

						</div>
					</div>
				</div>




			</div>
	</div>
	</div>








</body>
</html>