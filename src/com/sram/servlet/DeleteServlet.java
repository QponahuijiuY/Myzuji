package com.sram.servlet;

import com.sram.dao.ZuJiDao;
import com.sram.dao.impl.ZuJiDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		//System.out.println(id);
		ZuJiDao zuJiDao = new ZuJiDaoImpl();
		
		zuJiDao.deleteZuJi(Integer.parseInt(id));
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		writer.print("<script>alert('É¾³ý³É¹¦£¡')</script>");
		writer.print("<script>window.location.href = 'MainServlet'</script>");
		writer.flush();
		
	}

}
