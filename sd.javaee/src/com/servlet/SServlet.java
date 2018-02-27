package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet 单实例多线程带来的隐患 . 
 * 
 * */

@WebServlet("/s")
public class SServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String name;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		name = request.getParameter("name");
		
		System.out.println("name : " + name);
	}

}
