package com.sram.servlet;

import com.jspsmart.upload.SmartUpload;
import com.sram.beans.ZuJi;
import com.sram.dao.ZuJiDao;
import com.sram.dao.impl.ZuJiDaoImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddServlet extends HttpServlet {

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
		//�����������ϴ�����
		SmartUpload su = new SmartUpload();
		//��ʼ���ϴ�����
		su.initialize(config, request, response);

		try {

			//ָ���ϴ�����
			//ָ���ļ���С
			//su.setMaxFileSize(10*1024*1024);//10M
			//ָ����������
			//su.setAllowedFilesList("txt,doc,jpg");
			//ָ������������
			su.setDeniedFilesList("html,doc,txt");

			su.upload();//�ϴ�����
			su.save("/image");

			String url = "image/"+su.getFiles().getFile(0).getFileName();
			
			String title = su.getRequest().getParameter("title");
			String jianjie = su.getRequest().getParameter("jianjie");
			String date = su.getRequest().getParameter("date");
			
			//yyyy-MM-dd HH:mm:ss
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = dateFormat.parse(date);
			
			//dateFormat.parse(date)//���ַ���ת��Ϊ����
			//dateFormat.format(date)//������ת��Ϊ�ַ���
			
			
			
			System.out.println(title+"~~"+jianjie+"~~"+date+"~~"+url);
			ZuJi zuJi = new ZuJi(title, jianjie, date2, url);
			ZuJiDao dao = new ZuJiDaoImpl();
			
			dao.addZuJi(zuJi);
			response.sendRedirect("MainServlet");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
