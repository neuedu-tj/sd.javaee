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
		//在请求作用域中   将结果 暂存在 tomcat 内存中 , 请求反馈完毕后 , 该空间会清空 , 不同于 Sessoin 的  中长期保存机制 . 而是瞬时的 . 一个请求内的 
		request.setAttribute("moments", dao.getMoments());  
		
		request.getRequestDispatcher("moments.jsp").forward(request, response);
	}

}
