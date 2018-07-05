package com.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;
import com.service.UserService;
import com.service.UserServiceImpl;

public class UserAction extends HttpServlet {
	UserService service = new UserServiceImpl();
		/*protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	     doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    String name = req.getParameter("uname");
		   name = new String(name.getBytes("iso-8859-1"),"utf-8");
		   String pwd= req.getParameter("upwd");
		   //1.获取前端数据，进行封装
		   System.out.println("name:"+name+"pwd:"+pwd);
		   User u = new User();
		   u.setUname(name);
		   u.setUpwd(pwd);
		   List<User> list = new ArrayList<User>();
		   list.add(u);
		   
		   
		   HttpSession session = req.getSession();
		   if(service.doRegister(u)){
			   session.setAttribute("u", list);
			   resp.sendRedirect("index.jsp");
		   }else{
			   resp.sendRedirect("MyHtml.html");
		   }
		
		
		
		
	}
	
	

}
