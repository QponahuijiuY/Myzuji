package com.sram.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sram.beans.ZuJi;
import com.sram.dao.ZuJiDao;
import com.sram.dao.impl.ZuJiDaoImpl;

public class GetOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		ZuJiDao zuJiDao = new ZuJiDaoImpl();
		ZuJi zuJi = zuJiDao.getZuJi(Integer.parseInt(id));

		request.setAttribute("zuji", zuJi);

		request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
	}

}
