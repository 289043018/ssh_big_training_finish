package com.hand.action;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dao.CustomerDao;
import com.hand.dao.PageDao;
import com.hand.dao.UserDao;
import com.hand.model.Customer;
import com.hand.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String uname;
	private String pword;
	private int pagecount;

	
	

	@Autowired 
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
	/*CustomerDao customerDao =(CustomerDao) ac.getBean("customerDao");*/
	User user = (User) ac.getBean("user");
	UserDao userDao = (UserDao) ac.getBean("userDao");
	 
	public String Login() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(); 
/*		
		if(uname.equals("admin")){
			ServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			System.out.println("{\"uname\":\"" + uname  + "}");  
			out.print("{\"uname\":\"" + uname  + "}");  
	          
	        out.flush();  
	        out.close();  
		}
		*/

			 if (uname == null || uname.trim().equals("")||pword == null || pword.trim().equals(""))
		      {
		        	session.setAttribute("login_message", "用户名或者密码不能为空！");
		        	return "tologin";
		      }else{
		    	  
		 		 user.setUser_name(uname);
		 		 user.setUser_pwd(pword);
		 	        if(userDao.check(user)) {
		 	        	session.removeAttribute("login_message");
//		 	        	int pagecount = pageDao.getPageCount();
//		 	        	System.out.println("获得的总页数："+pagecount);
//		 	        	session.setAttribute("pagecount", pagecount);
		 	        	session.setAttribute("flag", "login_success");
//		 	        	user = userDao.findByName(uname);
//		 	        	String str = user.getRole();
//		 	        	System.out.println(str);
		 	        	String role = userDao.findRole(uname);
		 	        	System.out.println("该客户的权限为："+role);
		 	        	session.setAttribute("role", role);
		 	        	if(role.equals("财务人员")){
		 	        		session.setAttribute("cando", "1");
		 	        	}else{
		 	        		session.setAttribute("cando", "0");
		 	        	}
//		 	        	String str = (String) session.getAttribute("role");
//		 	        	System.out.println(str);
		 	        	String ch_name = userDao.findCh_Name(uname);
		 	        	System.out.println(ch_name+"欢迎使用系统");
		 	        	session.setAttribute("ch_name", ch_name);
		 	        	return SUCCESS;  
		 	        }
		 	        session.setAttribute("login_message", "用户名或者密码错误！");
		 	        return "tologin";
		      }
	}
	

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
}
