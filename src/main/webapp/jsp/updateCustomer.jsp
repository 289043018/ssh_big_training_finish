<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户详细信息</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/css/style1.css">
<link rel="stylesheet" href="<%=path%>/css/showdetail.css ">
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {
				/* 	alert("开始ajax"),
				 alert($("input[name='show_id']").val()), */
				alert("正在加载数据，请稍后...."), $.ajax({
					type : "POST",
					url : "Text_showdetail!showdetail.do?cust_id="
							+ $("input[name='cust_id']").val(),
					dataType : "json",
					success : function(data) {
						/*  加载客户信息 */
						$("input[name='customer_name']")
								.val(data.customer_name);
						$("select[name='customer_code']").val(
								data.customer_code);
						$("select[name='type']").val(data.type);
						$("input[name='group_company']")
								.val(data.group_company);
						$("input[name='corporation']").val(data.corporation);

						/* 加载地址信息 */
						$("input[name='address_id']").val(data.address_id);
						$("select[name='country']").val(data.country);
						$("input[name='state']").val(data.state);
						$("input[name='city']").val(data.city);
						$("input[name='port_of_destination']").val(
								data.port_of_destination);
						$("input[name='address1']").val(data.address1);
						$("input[name='address2']").val(data.address2);
						$("input[name='postcode']").val(data.postcode);
						$("input[name='shipping_mark']")
								.val(data.shipping_mark);
						$("input[name='status']").val(data.status);
						$("input[name='inactive_date']")
								.val(data.inactive_date);

						/* 加载付款信息 */
						$("input[name='payment_id']").val(data.payment_id);
						$("input[name='invoice_group']")
								.val(data.invoice_group);
						$("input[name='markup_name']").val(data.markup_name);
						$("input[name='currency']").val(data.currency);
						$("input[name='payment_term']").val(data.payment_term);
						$("input[name='price_term1']").val(data.price_term1);
						$("input[name='price_term2']").val(data.price_term2);
						$("input[name='price_term3']").val(data.price_term3);
						$("input[name='discount_name']")
								.val(data.discount_name);

						/* 加载组织信息 */
						$("input[name='org_id']").val(data.org_id);
						$("select[name='market_area']").val(data.market_area);
						$("input[name='bussiness_manager']").val(
								data.bussiness_manager);
						$("input[name='bussiness_assistant']").val(
								data.bussiness_assistant);

						/* 加载联系人信息 */
						$("input[name='cont_id']").val(data.cont_id);
						$("input[name='mailfrom']").val(data.mailfrom);
						$("input[name='prepr_mailto']").val(data.prepr_mailto);
						$("input[name='po_mailto']").val(data.po_mailto);
						$("input[name='ocpi_mailto']").val(data.ocpi_mailto);
						$("input[name='inv_pklist_mailto']").val(
								data.inv_pklist_mailto);

					}
				});
				alert("数据加载完毕！")
				/* 	alert($("#form1").serialize());  */

			});

	$(document).ready(
			function() {
				$("#save_cust").click(
						function() {
							alert($("#form_cust").serialize());

							$.ajax({
								type : "POST",
								url : "Text_updateCust!updateCust.do?"
										+ $("#form_cust").serialize(),
								dataType : "json",
								success : function() {
									alert("保存成功");
								}
							});

						});
			});

	$(document).ready(
			function() {
				$("#save_address").click(
						function() {
							alert($("#form_address").serialize());

							$.ajax({
								type : "POST",
								url : "Text_updateAddress!updateAddress.do?"
										+ $("#form_address").serialize(),
								dataType : "json",
								success : function() {
									alert("保存成功");
								}
							});

						});
			});

	$(document).ready(
			function() {
				$("#save_org").click(
						function() {
							alert($("#form_org").serialize());

							$.ajax({
								type : "POST",
								url : "Text_updateOrg!updateOrg.do?"
										+ $("#form_org").serialize(),
								dataType : "json",
								success : function(data) {
									alert("保存成功");
								}
							});

						});
			});

	$(document).ready(
			function() {
				$("#save_payment").click(
						function() {
							alert($("#form_payment").serialize());

							$.ajax({
								type : "POST",
								url : "Text_updatePayment!updatePayment.do?"
										+ $("#form_payment").serialize(),
								dataType : "json",
								success : function() {
									alert("保存成功");
								}
							});

						});
			});

	$(document).ready(
			function() {
				$("#save_cont").click(
						function() {
							alert($("#form_cont").serialize());

							$.ajax({
								type : "POST",
								url : "Text_updateCont!updateCont.do?"
										+ $("#form_cont").serialize(),
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
				href="<%=request.getContextPath()%>/Logout_Logout!Logout.do">退出</a>
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
						<div>更新客户信息</div>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<input id="cust_id" type=hidden value="${cust_id}" name="show_id" />
							<!-- type=hidden  -->


							<form id="form_cust">
								<input id="cust_id" type=hidden value="${cust_id}"
									name="cust_id" />


								<div class="col-md-4">
									<label style="width: 70px">客户名称：</label> <input type="text"
										name="customer_name" class="required" />

								</div>
								<div class="col-md-4">
									<label style="width: 70px">客户简称：</label> <select
										name="customer_code">
										<option value="ATW-J">ATW-J</option>
										<option value="ATW-M">ATW-M</option>
										<option value="ATW">ATW</option>
										<option value="GTW">GTW</option>
										<option value="GBH">GBH</option>

									</select>
								</div>
								<div class="col-md-4 ">
									<label style="width: 70px">类型：</label> <select name="type">
										<option value="GG20">GG20</option>
										<option value="STD">STD</option>
									</select>
								</div>

								<div class="col-md-4">
									<label style="width: 70px">集团公司：</label> <input type="text"
										name="group_company" maxlength="10">
								</div>
								<div class="col-md-4">
									<label style="width: 70px">总公司：</label> <input type="text"
										name="corporation" maxlength="10">
								</div>

								<div class="col-md-2 col-md-offset-8">
									<button class="btn btn-primary" type="button" id="save_cust">保存</button>
								</div>


							</form>
							<br>
							<div id="u4" class="ax_horizontal_line">
								<img alt="分割线" src="../img/u104_line.png" height="5" width="900">
							</div>



							<form id="form_address">
								<input id="cust_id" type=hidden value="${cust_id}"
									name="cust_id" /> <input id="address_id" type=hidden
									name="address_id" /> <label style="width: 70px">地址信息：</label>
								<br>

								<div>
									<label style="width: 70px" class="col-sm-offset-3">*国家：</label>
									<select name="country">
										<option value="Afghanistan">Afghanistan</option>
										<option value="Albania">Albania</option>
										<option value="Argentina">Argentina</option>
										<option value="Australia">Australia</option>
										<option value="Austria">Austria</option>
										<option value="Bahrain">Bahrain</option>
										<option value="Belgium">Belgium</option>
										<option value="Brazil">Brazil</option>
										<option value="Bulgaria">Bulgaria</option>
										<option value="Chile">Chile</option>
										<option value="China">China</option>
										<option value="Colombia">Colombia</option>
										<option value="Croatia">Croatia</option>
										<option value="Cyprus">Cyprus</option>
										<option value="Czech Republic">Czech Republic</option>
										<option value="Denmark">Denmark</option>
										<option value="Ecuador">Ecuador</option>
										<option value="Egypt">Egypt</option>
										<option value="El Salvador">El Salvador</option>
										<option value="Estonia">Estonia</option>
										<option value="Faroe Islands">Faroe Islands</option>
										<option value="Fiji">Fiji</option>
										<option value="Finland">Finland</option>
										<option value="FYROM">FYROM</option>
										<option value="Germany">Germany</option>
										<option value="Ghana">Ghana</option>
										<option value="Greece">Greece</option>
										<option value="Guatemala">Guatemala</option>
										<option value="Guernsey">Guernsey</option>
										<option value="Honduras">Honduras</option>
										<option value="Hong Kong">Hong Kong</option>
										<option value="Hungary">Hungary</option>
										<option value="Iceland">Iceland</option>
										<option value="India">India</option>
										<option value="Indonesia">Indonesia</option>
										<option value="Ireland">Ireland</option>
										<option value="Italy">Italy</option>
										<option value="Jamaica">Jamaica</option>
										<option value="Jersey">Jersey</option>
										<option value="Kenya">Kenya</option>
										<option value="Kuwait">Kuwait</option>
										<option value="Latvia">Latvia</option>
										<option value="Lithuania">Lithuania</option>
										<option value="France">France</option>
										<option value="Luxembourg">Luxembourg</option>
										<option value="Malaysia">Malaysia</option>
										<option value="Malta">Malta</option>
										<option value="Mexico">Mexico</option>
										<option value="Netherlands">Netherlands</option>
										<option value="New Zealand">New Zealand</option>
										<option value="Nicaragua">Nicaragua</option>
										<option value="Norway">Norway</option>
										<option value="Paraguay">Paraguay</option>
										<option value="Peru">Peru</option>
										<option value="Poland">Poland</option>
										<option value="Portugal">Portugal</option>
										<option value="Romania">Romania</option>
										<option value="Serbia">Serbia</option>
										<option value="Singapore">Singapore</option>
										<option value="Slovenia">Slovenia</option>
										<option value="South Africa">South Africa</option>
										<option value="Spain">Spain</option>
										<option value="Sri Lanka">Sri Lanka</option>
										<option value="Sweden">Sweden</option>
										<option value="Switzerland">Switzerland</option>
										<option value="Turkey">Turkey</option>
										<option value="United Kingdom">United Kingdom</option>
										<option value="Uruguay">Uruguay</option>
										<option selected value="USA">USA</option>
									</select>
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										州/省:</label> <input type="text" name="state" />
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3"> *
										城市:</label> <input type="text" name="city" class="required" />
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										*目的巷：</label> <input type="text" name="port_of_destination"
										class="required">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										*地址1：</label> <input type="text" name="address1" class="required">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">地址2：</label>
									<input type="text" name="address2">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">邮编：</label>
									<input type="text" name="postcode">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										*唛头：</label> <input type="text" name="shipping_mark" class="required">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										状态：</label> <input type="text" name="status" value="待确认"
										readonly="readonly">
								</div>
								<div>
									<label style="width: 70px" class="col-sm-offset-3">
										失效日期：</label> <input type="text" name="inactive_date">
								</div>
								<div class="col-md-2 col-md-offset-8">
									<button class="btn btn-primary" type="button" id="save_address">保存</button>
								</div>

							</form>
							<br>

							<div id="u4" class="ax_horizontal_line">
								<img alt="分割线" src="../img/u104_line.png" height="5" width="900">
							</div>


							<form id="form_payment">
								<label style="width: 70px">付款信息：</label> <br> <input
									id="payment_id" type=hidden name="payment_id" />
								<div class="payment_info col-sm-offset-2">

									<div>
										<div class="payment_inline">
											<label style="width: 160px">所属发票组：</label> <input type="text"
												name="invoice_group">
										</div>
										<div class="payment_inline">
											<label style="width: 160px">* 通用加价条款：</label> <input
												type="text" name="markup_name" class="required">

										</div>

									</div>
									<div>
										<div class="payment_inline">
											<label style="width: 160px"> * 结算货币：</label> <input
												type="text" name="currency" class="required" maxlength="3">
										</div>
										<div class="payment_inline">
											<label style="width: 160px"> *一般折扣：</label> <input
												type="text" name="discount_name" class="required">
										</div>

									</div>
									<div>
										<label style="width: 160px">* 付款方法：</label> <input type="text"
											name="payment_term" class="required" maxlength="3">

									</div>
									<div>
										<label style="width: 160px"> 价格条款1：</label> <input type="text"
											name="price_term1">
									</div>
									<div>
										<label style="width: 160px"> 价格条款2：</label> <input type="text"
											name="price_term2">
									</div>
									<div>
										<label style="width: 160px">价格条款3：</label> <input type="text"
											name="price_term3">
									</div>



								</div>
								<div class="col-md-2 col-md-offset-8">
									<button class="btn btn-primary" type="button" id="save_payment">保存</button>
								</div>

							</form>
							<br>




							<div id="u4" class="ax_horizontal_line">
								<img alt="分割线" src="../img/u104_line.png" height="5" width="900">
							</div>



							<form id="form_org">
								<input id="org_id" type=hidden name="org_id" /> <label
									style="width: 70px">组织信息：</label> <br>
								<div class="col-sm-offset-2">
									<div>
										<label style="width: 160px">* 所属TEAM：</label> <select
											name="market_area">
											<option value="德国">德国</option>
											<option value="亚太">亚太</option>
											<option value="欧洲1">欧洲1</option>
											<option value="美国">美国</option>
											<option value="欧洲2">欧洲2</option>
											<option value="OEM">OEM</option>
										</select>
									</div>
									<div>
										<label style="width: 160px">* 业务经理：</label> <input
											type="text" name="bussiness_manager" class="required">
									</div>
									<div>
										<label style="width: 160px">* 业务助理： </label> <input
											type="text" name="bussiness_assistant" class="required">
									</div>


								</div>
								<div class="col-md-2 col-md-offset-8">
									<button class="btn btn-primary" type="button" id="save_org">保存</button>
								</div>


							</form>
							<br>







							<div id="u4" class="ax_horizontal_line">
								<img alt="分割线" src="../img/u104_line.png" height="5" width="900">
							</div>




							<form id="form_cont">
								<input id="cont_id" type=hidden name="cont_id" /> <label
									style="width: 100px">联系人信息：</label> <br>
								<div class="col-sm-offset-2">
									<div>
										<label style="width: 160px"> 发件人邮箱：</label> <input
											type="text"  name="mailfrom">
									</div>
									<div>
										<label style="width: 160px">Pre PO 收件人：</label> <input
											type="text"  name="prepr_mailto">
									</div>

									<div>
										<label style="width: 160px">PO 收件人：</label> <input
											type="text" name="po_mailto">
									</div>
									<div>
										<label style="width: 160px">OC/PI收件人：</label> <input
											type="text" name="ocpi_mailto">
									</div>
									<div>
										<label style="width: 160px">INV/Packing list 收件：</label> <input
											type="text"  name="inv_pklist_mailto">
									</div>


								</div>
								<div class="col-md-2 col-md-offset-8">
									<button class="btn btn-primary" type="button" id="save_cont">保存</button>
								</div>

							</form>

							<br>


						</div>
					</div>
				</div>




			</div>
		</div>
	</div>




</body>
</html>