package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UsersDao;
import com.model.Users;

@WebServlet("/user")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("login".equalsIgnoreCase(method)) {
			login(request , response);
		} else if("check".equalsIgnoreCase(method)) {
			check(request , response);
		} else if("rememberme".equalsIgnoreCase(method)) {
			rememberme(request, response) ;
		}
	}
	
	
	protected void rememberme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("cookie");
		Cookie c = new Cookie("sd" , "1111111");
		c.setMaxAge(0);
		response.addCookie(c);
	
	}
	
	protected void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		
		
		PrintWriter out = response.getWriter();
		
		System.out.println("uname : " + uname);
		
		if("tom".equalsIgnoreCase(uname)) {
			out.print("0");
		} else {
			out.print("1");
		}
		
		out.flush();
		out.close();

	}
	
      
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if("sd".equalsIgnoreCase(cookie.getName())) {
				System.out.println("cookie value : " + cookie.getValue());
			}
				
		}
		
		
		
		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		
		Users u = new Users(1, name , pwd);
		
		
		UsersDao dao = new UsersDao();
		
		Users user = dao.checkUsers(u);
		
		if(user!=null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendRedirect("/sd.javaee/login.html");
		}
		
	}

       
 
       
}
