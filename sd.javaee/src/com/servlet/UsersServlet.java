package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UsersDao;
import com.model.Users;

@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		System.out.println("name : " + name);
		
		
//		Users u = new Users(1, name , pwd);
//		
//		
//		UsersDao dao = new UsersDao();
//		
//		Users user = dao.checkUsers(u);
//		
//		if(user!=null) {
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
//		
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("/sd.javaee/login.html");
//		}
		
	}

       
 
       
}
