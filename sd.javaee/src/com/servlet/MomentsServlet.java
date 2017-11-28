package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import com.dao.MomentsDao;
import com.model.Moments;

@WebServlet("/moments")
@MultipartConfig
public class MomentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//接收 朋友圈内容  和  图片
		
		String mcontent = request.getParameter("mcontent");
		Part imgs = request.getPart("imgs");
		
		//生成文件保存的真实路径 . . . 
		
		
		String url = "/sd.javaee/storage/"+imgs.getSubmittedFileName();
		
		Moments m = new Moments(mcontent , url);
		
		MomentsDao dao = new MomentsDao();
		dao.saveMoments(m);
		
		
		String path = request.getRealPath("storage") + "/" + imgs.getSubmittedFileName();
		
		FileUtils.copyInputStreamToFile(imgs.getInputStream() , new File(path));
		
		//都添加成功后 , 去哪 ?  ---> 去显示界面
		request.getRequestDispatcher("/getMoments").forward(request, response);
		
	}

}
