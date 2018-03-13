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

@WebServlet("/moment")
@MultipartConfig
public class MomentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");

		if ("get".equalsIgnoreCase(method)) {
			get(request, response);
		} else if("add".equalsIgnoreCase(method)) {
			add(request , response);
		}

	}

	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mcontent = request.getParameter("mcontent");

		Collection<Part> imgs = request.getParts(); // 会得到本次提交的表单中 所有控件的内容 , 包括文本 , checkbox , file ......

		// 用于拼接 路径
		StringBuilder urls = new StringBuilder("");

		for (Part part : imgs) {
			if ("imgs".equalsIgnoreCase(part.getName())) {

				String path = request.getRealPath("storage") + "/" + part.getSubmittedFileName(); // c:/dev/.....tomcat/webapps/sd.javaee/storage/xxxx.jpg

				FileUtils.copyInputStreamToFile(part.getInputStream(), new File(path)); // 拷贝每一份文件 到服务器

				String url = "/sd.javaee/storage/" + part.getSubmittedFileName(); // 获取每一份文件的相对路径 (此路径用于保存到 db ) :
																					// sd.javaee/storage/xxx.jpg
				urls.append(url).append(";");
			}
		}

		urls.deleteCharAt(urls.length() - 1); // 删除最后一个多余的分号 " ; "

		Moments m = new Moments(mcontent, urls.toString());

		MomentsDao dao = new MomentsDao();
		dao.saveMoments(m);

		get(request  ,response);

	}

	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MomentsDao dao = new MomentsDao();

		request.setAttribute("moments", dao.getMoments());

		request.getRequestDispatcher("moments.jsp").forward(request, response);
	}

}
