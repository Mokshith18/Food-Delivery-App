package com.food.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	private Map<Integer,CartItem> items;
	
	public Cart() {
		this.items = new HashMap();
	}
	
	public void addItem(CartItem item) {
		int itemId = item.getItemId();
		if(items.containsKey(itemId)) {
			CartItem existingItem = items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+1);
		}
		else {
			items.put(itemId, item);
		}
	}
	public void updateItem(int itemId,int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity<=0) {
				items.remove(itemId);
			}
			else {
				items.get(itemId).setQuantity(quantity);
			}
		}
		
	}
	public void deleteItem(int itemId) {
		if(items.containsKey(itemId)) {
			items.remove(itemId);
		}
	}
	public Map<Integer,CartItem> getItems() {
		
		
		return items;
	}
}
