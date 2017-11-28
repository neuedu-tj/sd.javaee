package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MomentsDao;
import com.model.Moments;

@WebServlet("/moments")
@MultipartConfig
public class MomentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收 朋友圈内容  和  图片
		
		String mcontent = request.getParameter("mcontent");
		
		Moments m = new Moments(mcontent);
		
		MomentsDao dao = new MomentsDao();
		dao.saveMoments(m);
		
	}

}
