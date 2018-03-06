package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.model.Product;

import web.util.BuyCart;
import web.util.Item;

@WebServlet("/buycart")
public class BuyCartServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("addProduct".equalsIgnoreCase(method)) {
			addProduct(request , response);
		} else if("updateAmount".equalsIgnoreCase(method)) {
			
		}
		
	}
	
//	protected void updateAmount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		HttpSession session = request.getSession();
//		BuyCart buycart = (BuyCart) session.getAttribute("buycart");
//		
//	}
	
	protected void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product p = dao.getProductById(pid);
		
		int amount = 1;
		String temp = request.getParameter("amount");
		if(temp!=null && temp!= "") {
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		Item item = new Item( p  , amount );
		
	
		HttpSession session = request.getSession();
		BuyCart buycart;
		if(session.getAttribute("buycart")==null) {
			buycart = new BuyCart();
			session.setAttribute("buycart", buycart);
		} else {
			buycart = (BuyCart)session.getAttribute("buycart");
		}
		
		
		buycart.addItem(item);
		
		System.out.println("buycart : " + buycart);

		toView(request, response);
	}
	
	
	
	protected void toView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/buycart/buycart.jsp").forward(request, response);
	}

}
