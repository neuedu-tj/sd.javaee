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
	
		ProductDao dao = new ProductDao();
		//根据用户传递的 产品  id , 查询出完整的产品信息
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product p = dao.getProductById(pid);
		
		//构造购物项
		Item item = new Item( p  , 1);
		
		//如果用户是第一次购买 , 那么 httpSession 中不会存在购物车实例 , 应立即创建 , 如果不是 , 则拿出已存在的购物车实例 , 添加产品即可 . 
		HttpSession session = request.getSession();
		BuyCart buycart = null;
		if(session.getAttribute("buycart")==null) {
			buycart = new BuyCart();
			session.setAttribute("buycart", buycart);
		} else {
			buycart = (BuyCart)session.getAttribute("buycart");
		}
		
		
		//将购物项 添加到购物车中 . .
		buycart.addItem(item);
		
		//跳转到显示页面
		toView(request, response);
		
	}
	
	protected void toView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/buycart/buycart.jsp").forward(request, response);
	}

}
