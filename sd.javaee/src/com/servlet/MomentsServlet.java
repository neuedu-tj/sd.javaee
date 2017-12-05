package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

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
		
		String mcontent = request.getParameter("mcontent");
		
		//��ȡ���ļ�
//		request.getPart("xxxx"); 
		
		
		Collection<Part> imgs = request.getParts();  //��õ������ύ�ı���  ���пؼ������� , �����ı�  , checkbox , file ......
		
		//����ƴ�� ·��
		StringBuilder urls = new StringBuilder("");
		
		for (Part part : imgs) {
			if("imgs".equalsIgnoreCase(part.getName())) {
				
				String path = request.getRealPath("storage") + "/" + part.getSubmittedFileName();   //c:/dev/.....tomcat/webapps/sd.javaee/storage/xxxx.jpg
				
				FileUtils.copyInputStreamToFile(part.getInputStream() , new File(path)); //����ÿһ���ļ� ��������
				
				String url = "/sd.javaee/storage/"+part.getSubmittedFileName();  // ��ȡÿһ���ļ������·�� (��·�����ڱ��浽 db ) :   sd.javaee/storage/xxx.jpg
				urls.append(url).append(";");
			}
		}
		
		urls.deleteCharAt(urls.length()-1); //ɾ�����һ������ķֺ�  " ; "
	
		Moments m = new Moments(mcontent , urls.toString());
	
		MomentsDao dao = new MomentsDao();
		dao.saveMoments(m);

		request.getRequestDispatcher("/getMoments").forward(request, response);
		
	}

}
