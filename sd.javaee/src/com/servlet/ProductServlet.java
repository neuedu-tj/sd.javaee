package com.servlet;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import com.dao.ProductDao;
import com.model.Product;

import web.util.PageBean;
 
@WebServlet(urlPatterns = "/product" , asyncSupported = true , loadOnStartup = 1)   
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");

		if ("getProduct".equalsIgnoreCase(method)) {
			getProduct(request, response);
		} else if ("getProductByPage".equalsIgnoreCase(method)) {
			getProductByPage(request, response);
		} else if ("addProduct".equalsIgnoreCase(method)) {
			addProduct(request, response);
		} else if ("addProductVedio".equalsIgnoreCase(method)) {
			addProductVedio(request, response);
		} else {
			System.out.println("no handler ....");
		}

	}

	/* 处理视频上传 */
	protected void addProductVedio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Part vedio = request.getPart("vedio");
		System.out.println("vedio-size : "+ vedio.getSize()/1024/1024);
		String toServer = request.getRealPath("product/storage/vedio/")+vedio.getSubmittedFileName();	
		FileUtils.copyInputStreamToFile(vedio.getInputStream(), new File(toServer));
		
		
//		AsyncContext async = request.startAsync();
//		
//		async.addListener(new AsyncListener() {
//			
//			@Override
//			public void onTimeout(AsyncEvent arg0) throws IOException {}
//			@Override
//			public void onStartAsync(AsyncEvent arg0) throws IOException {
//				Part vedio;
//				try {
//					vedio = request.getPart("vedio");
//					String toServer = request.getRealPath("product/storage/vedio/")+vedio.getSubmittedFileName();	
//					FileUtils.copyInputStreamToFile(vedio.getInputStream(), new File(toServer));
//					System.out.println("人为延迟 2 秒 .  ");
//					Thread.sleep(2000);
//				} catch (Exception e) {
//					System.err.println("xxxxxxxxxx");
//					e.printStackTrace();
//				}
//					
//				
//			}
//			@Override
//			public void onError(AsyncEvent arg0) throws IOException {}
//			
//			@Override
//			public void onComplete(AsyncEvent event) throws IOException {
//				HttpServletResponse response = (HttpServletResponse) event.getAsyncContext().getResponse();
//				response.getWriter().println("上传完成 . . . . ");
//			}
//		});
//		
////		new Thread(new VedioUploadHandler(vedio.getInputStream(), new File(toServer)));
//		
//		PrintWriter out = response.getWriter();
//		
//		
//		out.println("正在处理视频上传 . . .  .");
		
		
	}

	/// 添加产品
	protected void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDao dao = new ProductDao();

		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String price = request.getParameter("price");

		// Part part = request.getPart("img"); //单文件 ✖

		Collection<Part> parts = request.getParts();

		StringBuilder pathToDb = new StringBuilder();

		for (Part part : parts) {
			if ("img".equalsIgnoreCase(part.getName())) {
				String toWebApp = request.getRealPath("product/storage/img/") + part.getSubmittedFileName();
				FileUtils.copyInputStreamToFile(part.getInputStream(), new File(toWebApp));

				String path = "/sd.javaee/product/storage/img/" + part.getSubmittedFileName();
				pathToDb.append(path).append(",");
			}
		}
		String realPath = pathToDb.deleteCharAt(pathToDb.length() - 1).toString(); // 得到了真正入库的路径
		// System.out.println("realPath : " + realPath);

		Product product = new Product(name, detail, new BigDecimal(price), realPath);
		//
		dao.addProduct(product);
		//
		getProductByPage(request, response);

	}

	protected void getProductByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDao dao = new ProductDao();
		int curr = 1;

		String curr_data = request.getParameter("curr");
		if (curr_data != null) {
			curr = Integer.parseInt(curr_data);
		}

		PageBean pageBean = dao.getProductsByPage(curr, 3);

		request.setAttribute("pageBean", pageBean);

		request.getRequestDispatcher("/product/getProductByPage.jsp").forward(request, response);
	}

	protected void getProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDao dao = new ProductDao();

		List<Product> products = dao.getProducts();

		request.setAttribute("products", products);

		request.getRequestDispatcher("/product/getProduct.jsp").forward(request, response);

	}

}
