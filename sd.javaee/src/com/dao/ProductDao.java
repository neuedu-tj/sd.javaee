package com.dao;

import java.sql.ResultSet;
import java.util.List;

import com.model.Product;

import jdbc.config.JDBCUtils;
import web.util.PageBean;

public class ProductDao {
	
	JDBCUtils utils = new JDBCUtils();
	
	public Product getProductById(int pid) {
		
		String sql = "select * from product where pid =?";
		Object[] params = { pid } ;
		
		List<Product> products= (List<Product>) utils.findByType(sql, Product.class , params);
		
		if(products!=null && products.size() > 0 ) {
			return products.get(0);
		}
		
		return null;
	}
	
	
	
	public void addProduct(Product product) {
		
		String sql = "insert into product ( name , detail , price , img ) values ( ? , ? , ? , ? )";
		Object[] params = { product.getName() , product.getDetail() , product.getPrice() , product.getImg() };
		
		int row = utils.executeUpdate(sql, params);
	}
	
	
	public List<Product> getProducts() {
		
		String sql = "select * from product";
		return (List<Product>) utils.findByType(sql, Product.class,null);
	}
	
	
	/* 分页 */
	public PageBean getProductsByPage (int curr ,int size ) { 
		
		PageBean page = new PageBean();
		
		
		String sql = "select * from product limit ? , ?";   
		Object[] params = { (curr - 1) * size  , size };
		page.setData( (List<Product>) utils.findByType(sql, Product.class,params) );
		
		
		String sql_count = "select count(*) from product";
		ResultSet rs = utils.executeQuery(sql_count, null);
		
		try {
			if(rs.next()) {
				page.setTotalRows(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return page;
	}

}
