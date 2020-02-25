package com.sram.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.sram.beans.ZuJi;
import com.sram.dao.ZuJiDao;
import com.sram.dao.impl.ZuJiDaoImpl;

public class UpdateServlet extends HttpServlet {

	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		super.init(config);
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建第三方上传对象
		SmartUpload su = new SmartUpload();
		//初始化上传对象
		su.initialize(config, request, response);

		try {

			//指定上传类型
			//指定文件大小
			//su.setMaxFileSize(10*1024*1024);//10M
			//指定允许类型
			//su.setAllowedFilesList("txt,doc,jpg");
			//指定不允许类型
			su.setDeniedFilesList("html,doc,txt");

			su.upload();//上传方法
			String url = "";
			//判断是否传递图片
			long num = su.getFiles().getSize();
			if(num == 0){
				url = su.getRequest().getParameter("url");
			}else{
				su.save("/image");
				url = "image/"+su.getFiles().getFile(0).getFileName();
			}
			
			
			String id = su.getRequest().getParameter("id");
			String title = su.getRequest().getParameter("title");
			String jianjie = su.getRequest().getParameter("jianjie");
			String date = su.getRequest().getParameter("date");
			
			//yyyy-MM-dd HH:mm:ss
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = dateFormat.parse(date);
			
			//dateFormat.parse(date)//把字符串转换为日期
			//dateFormat.format(date)//把日期转换为字符串
			
			
			//System.out.println(title+"~~"+jianjie+"~~"+date+"~~"+url);
			ZuJi zuJi = new ZuJi(Integer.parseInt(id),title, jianjie, date2, url);
			ZuJiDao dao = new ZuJiDaoImpl();
			dao.updateZuJi(zuJi);
			
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter writer = response.getWriter();
			writer.print("<script>alert('修改成功！')</script>");
			writer.print("<script>window.location.href = 'MainServlet'</script>");
			writer.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
