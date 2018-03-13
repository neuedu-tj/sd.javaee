package test;

import java.util.List;

import org.junit.Test;

import com.dao.ProductDao;
import com.model.Product;

import web.util.PageBean;

public class TestProduct {
	
	
	
	@Test
	public void testGetProductById() {
		ProductDao dao = new ProductDao();
		Product p = dao.getProductById(3);
		System.out.println(" p："+p);
	}
	
	@Test
	public void testGetProducts() {
		
		ProductDao dao = new ProductDao();
		
		List<Product> products = dao.getProducts();
		
		for (Product p : products) {
			System.out.println(p);
		}

	}
	
	
	@Test
	public void testGetProductsByPage() {
		
		ProductDao dao = new ProductDao();
		
		PageBean page = dao.getProductsByPage(3,3);
		
		System.out.println("pageBean : " + page);

	}
	
	

}
