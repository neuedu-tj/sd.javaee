package web.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BuyCart {

	//购买项容器
	private List<Item> items = new ArrayList<Item>();

	public List<Item> getItems() {
		return items;
	}

	/* 添加购买项 加量或加项 */    
	public void addItem(Item item) {
		
		if(items.contains(item)) {
			for (Item i : items) {
				if(i.equals(item)) {
					i.setAmount( i.getAmount() + item.getAmount() );
				}
			}
		} else {
			items.add(item);
		}
		
	}
	
	public double getTotalPrice () {
		double sum = 0 ; 
		for (Item item : items) {
			
			sum +=  item.getProduct().getPrice().doubleValue() * item.getAmount();
		}
		
		return sum;
		
	}
	

	@Override
	public String toString() {
		return "BuyCart [items=" + items + "]";
	}

}
