package com.dao;

import java.util.List;

import com.model.Product;

import jdbc.config.JDBCUtils;

public class ProductDao {
	
	JDBCUtils utils = new JDBCUtils();
	
	public List<Product> getProducts() {
		
		String sql = "select * from product";
		return (List<Product>) utils.findByType(sql, Product.class,null);
	}
	
	public List<Product> getProductsByPage () {
		return null;
	}

}
