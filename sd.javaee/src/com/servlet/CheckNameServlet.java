package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
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

}
