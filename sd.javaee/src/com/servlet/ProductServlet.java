package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.model.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");

		if ("getProduct".equalsIgnoreCase(method)) {
			getProduct(request, response);
		}

	}

	/**
	 * 返回所有的 product 表 记录
	 */
	protected void getProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDao dao = new ProductDao();

		List<Product> products = dao.getProducts();
		
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("/product/getProduct.jsp").forward(request, response);
		
	}

}
