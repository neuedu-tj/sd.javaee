package com.model;

import java.math.BigDecimal;

public class Product {
	
	private int pid;
	private String name;
	private String detail;
	private BigDecimal price;
	private String img;  //实际上 保存的是 图片的路径 ( 相对于服务器的路径  而非保存到服务器的绝对路径 )
	
	public Product() {
		
	}
	
	
	
	public Product(String name, String detail, BigDecimal price) {
		super();
		this.name = name;
		this.detail = detail;
		this.price = price;
	}



	public Product(String name, String detail, BigDecimal price, String img) {
		super();
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.img = img;
	}
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", detail=" + detail + ", price=" + price + ", img=" + img
				+ "]";
	}
	
	
	

}
