package com.sram.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sram.beans.User;

public class MyFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest)request;
		request2.setCharacterEncoding("utf-8");
		HttpServletResponse response2 = (HttpServletResponse)response;
		User user = (User)request2.getSession().getAttribute("user");
		if(user!=null||login(request2)){
			chain.doFilter(request, response);//·ÅÐÐ
		}else{
			response2.sendRedirect("login.jsp");
		}
		
	}
	
	public boolean login(HttpServletRequest request){
		String url = request.getRequestURI();
		boolean flag = false;
		if(url.contains("login.jsp")){
			flag = true;
		}
		if(url.contains("LoginServlet")){
			flag = true;
		}
		if(url.endsWith(".css")){
			flag = true;
		}
		if(url.endsWith(".js")){
			flag = true;
		}
		if(url.endsWith(".png")){
			flag = true;
		}
		if(url.endsWith(".jpg")){
			flag = true;
		}
		return flag;
	}
	

	public void init(FilterConfig arg0) throws ServletException {
	}

}
