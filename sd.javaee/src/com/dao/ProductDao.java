package com.dao;

import java.sql.ResultSet;
import java.util.List;

import com.model.Product;

import jdbc.config.JDBCUtils;
import web.util.PageBean;

public class ProductDao {
	
	JDBCUtils utils = new JDBCUtils();
	
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
			System.err.println("获取总记录数时  出现异常.");
			e.printStackTrace();
		}
		
		
		return page;
	}

}
