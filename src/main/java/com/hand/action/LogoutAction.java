package com.hand.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LogoutAction extends ActionSupport{
	public String Logout() throws Exception {
	    HttpServletRequest request = ServletActionContext.getRequest();
	    HttpSession session = request.getSession();
	    session.invalidate();
		return "tologin";
	}
}
