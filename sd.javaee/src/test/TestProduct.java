package test;

import java.util.List;

import org.junit.Test;

import com.dao.ProductDao;
import com.model.Product;

public class TestProduct {
	
	@Test
	public void testGetProducts() {
		
		ProductDao dao = new ProductDao();
		
		List<Product> products = dao.getProducts();
		
		for (Product p : products) {
			System.out.println(p);
		}
		
		
	}

}
