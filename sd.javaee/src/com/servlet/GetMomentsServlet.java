package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MomentsDao;


@WebServlet("/getMoments")
public class GetMomentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MomentsDao dao = new MomentsDao();
		//��������������   ����� �ݴ��� tomcat �ڴ��� , ��������Ϻ� , �ÿռ����� , ��ͬ�� Sessoin ��  �г��ڱ������ . ����˲ʱ�� . һ�������ڵ� 
		request.setAttribute("moments", dao.getMoments());  
		
		request.getRequestDispatcher("moments.jsp").forward(request, response);
	}

}
