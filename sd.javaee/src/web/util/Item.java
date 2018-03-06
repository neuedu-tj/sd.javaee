package web.util;

import com.model.Product;

public class Item {
	
	private Product product;
	private int amount;
	
	public Item() {}
	
	public Item(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", amount=" + amount + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Item a = this;
		Item b = (Item)obj;
		
		return a.getProduct().getPid() == b.getProduct().getPid();
	}

	
	

}
