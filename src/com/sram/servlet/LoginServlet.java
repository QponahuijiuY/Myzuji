package com.sram.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sram.beans.User;
import com.sram.dao.UserDao;
import com.sram.dao.impl.UserDaoImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDaoImpl();
		User user = dao.login(username, password);
		if(user == null){
			System.out.println("用户名或密码错误！");
			
			//request可以给页面发送一些数据
			request.setAttribute("msg", "用户名或密码错误！");
			request.setAttribute("username", username);
			//request可以做页面跳转   转发
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}else{
			System.out.println("登陆成功");
			//重定向
			request.getSession().setAttribute("user", user);
			
			
			//1.第一张方式：登陆成功之后直接跳转到主页面
			//response.sendRedirect("MainServlet");
			
			
			//2.第二中方式：登陆成功之后，弹出提示框，显示登陆成功，然后再跳转到主页面
			//MIME
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter writer = response.getWriter();
			writer.print("<script>alert('登陆成功！')</script>");
			writer.print("<script>window.location.href = 'MainServlet'</script>");
			writer.flush();
		}
	}

}
