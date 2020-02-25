package com.sram.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sram.beans.ZuJi;
import com.sram.dao.ZuJiDao;
import com.sram.dao.impl.ZuJiDaoImpl;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ZuJiDao dao = new ZuJiDaoImpl();
		List<ZuJi> zujis = dao.getZuJis();
		request.setAttribute("zujis", zujis);
		
		if(zujis.size()!=0){
			request.setAttribute("zuji", zujis.get(0));
		}
		
		request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	}
}
