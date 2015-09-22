<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath(); %>
    <%@ page isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
 <link rel="stylesheet" href="<%=path %>/css/style1.css"> 
</head>
<body>


<div class="container">
		<div class="head">
			
		</div>
		<div class="body">
			<div class="menu">
				<ul id="mytab" class="nav nav-tabs nav-stacked" role="tablist">
					<li role="presentation"><a href="#">用户管理<span
							class="glyphicon glyphicon-chevron-right"></span></a></li>
					<li role="presentation"><a href="#">价格管理<span
							class="glyphicon glyphicon-chevron-right"></span></a></li>
							<li role="presentation"><a href="#">折扣管理<span
							class="glyphicon glyphicon-chevron-right"></span></a></li>
				</ul>
			</div>
			<div class="kehuguanli">
				<div class="panel panel-info loginform">
                <div class="panel-heading">
                 		   销售管理系统
                </div>
                 
                <div class="panel-body">
                   <form class="form-horizontal" role="form" action="<%= request.getContextPath()%>/Login_Login!Login.do" Method="post" name="loginForm">
                    <div class="form-group">
                        <label class="col-md-4 control-label">用户名：</label>
                        <div class="col-md-4">
                           <input type="text" name="uname" class="form-control" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">密码：</label>
                        <div class="col-md-4">
                             <input type="password" name="pword" class="form-control" placeholder="密码"> 
                        </div>
                    </div>

                         <h5 align="center">${login_message}</h5>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-md-4">
                       
                          <button type="submit" class="btn btn-default">登录</button>
                       <!--    <button type="submit" class="btn btn-default" onclick="chakan()">查看</button>
                          <span id="result"></span> -->
                        </div>
                    </div>
                </form>
                </div>
                
            </div>
			</div>
	</div>
	</div>



</body>
</html>