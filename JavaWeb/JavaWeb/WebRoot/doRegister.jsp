<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.pojo.User"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <!-- 
     request:1.接收前端传递的数据  2.跳转
     out:显示数据
     response：重定向
     session：会话
         
   -->
   <%
  
   //2.通过jdbc进行操作
   Class.forName("com.mysql.jdbc.Driver");
   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
   String sql="insert into myuser values(null,?,?)";
   PreparedStatement ps = conn.prepareStatement(sql);
   //ps.setString(1,u.getUname());
   //ps.setString(2,u.getUpwd());
   int row = ps.executeUpdate();
        // ps.close();
   //conn.close();
    //3.跳转
   if(row>0){
   //跳转到登录界面
   System.out.println("注册成功");
      response.sendRedirect("login.html");
   }else{//跳转到注册界面
    System.out.println("注册失败");
      request.getRequestDispatcher("MyHtml.html").forward(request,response);
   
   }
   
   
   
    %>
   
   
   
   
   
   
   
   
  </body>
</html>
