package com.servlet.lifecycle;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="life" , 
		urlPatterns= {"/life" , "/l"} , 
		loadOnStartup=5 ,
		initParams = {
				@WebInitParam(name="encoding" , value="utf-8"),
				@WebInitParam(name="loc" , value="zn")
				}
 )
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化数据如下 : ------------");
		System.out.println("encoding : " + config.getInitParameter("encoding"));
		System.out.println("loc : " + config.getInitParameter("loc"));
	}
	
    public LifeServlet() {//1
	      System.out.println("Servlet 创建........   ");
    }
    
    @Override
    public void destroy() {//4
    	System.out.println("destory ------------");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//3   repeat
		System.out.println("do get --------------------");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//4   repeat
		System.out.println("do post --------------------");
	}

}
