package com.ty.shoppingcart.online_cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.shoppingcart.online_cart.dto.Cart;
import com.ty.shoppingcart.online_cart.dto.Items;
import com.ty.shoppingcart.online_cart.repo.ItemsRepository;
@Repository
public class ItemsDao {
	@Autowired
	private ItemsRepository itemsRepository;
	
	
	public Items saveItems( Items items) {
		return itemsRepository.save(items);
	}

	public Items getItemsById(int id) {
		return itemsRepository.findById(id).get();
	}
	public String deleteItems(int id) {

		itemsRepository.deleteById(id);
		return "deleted";
	}
}
