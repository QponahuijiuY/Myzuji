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
			System.out.println("�û������������");
			
			//request���Ը�ҳ�淢��һЩ����
			request.setAttribute("msg", "�û������������");
			request.setAttribute("username", username);
			//request������ҳ����ת   ת��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}else{
			System.out.println("��½�ɹ�");
			//�ض���
			request.getSession().setAttribute("user", user);
			
			
			//1.��һ�ŷ�ʽ����½�ɹ�֮��ֱ����ת����ҳ��
			//response.sendRedirect("MainServlet");
			
			
			//2.�ڶ��з�ʽ����½�ɹ�֮�󣬵�����ʾ����ʾ��½�ɹ���Ȼ������ת����ҳ��
			//MIME
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter writer = response.getWriter();
			writer.print("<script>alert('��½�ɹ���')</script>");
			writer.print("<script>window.location.href = 'MainServlet'</script>");
			writer.flush();
		}
	}

}
