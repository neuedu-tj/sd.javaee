package web.util;

import java.util.ArrayList;
import java.util.List;

public class BuyCart {
	
	private List<Item> items = new ArrayList<Item>();

	public List<Item> getItems() {
		return items;
	}
	
	//��ӹ��ﳵ  
	public void addItem( Item item ) {
		items.add(item);    
	}
	


}
