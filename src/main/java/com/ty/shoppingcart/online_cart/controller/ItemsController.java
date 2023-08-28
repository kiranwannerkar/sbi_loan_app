package com.ty.shoppingcart.online_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.shoppingcart.online_cart.dto.Cart;
import com.ty.shoppingcart.online_cart.dto.Items;
import com.ty.shoppingcart.online_cart.repo.ItemsRepository;
import com.ty.shoppingcart.online_cart.service.Cartservice;
import com.ty.shoppingcart.online_cart.service.ItemsService;
import com.ty.shoppingcart.online_cart.util.ResponseStructure;

@RestController
public class ItemsController {
	@Autowired
	ItemsService itemsService;

	@PostMapping("item")
	public ResponseStructure<Items> saveItems(@RequestBody Items items,@RequestParam int id) {
		return itemsService.saveItems(items,id);
	}

	@GetMapping("getItems")
	public ResponseStructure<Items> getItems(@RequestParam int id) {
		return itemsService.getItemsById(id);
	}

	@DeleteMapping("deleteItems/{id}")
	public ResponseStructure<String> deleteItems(@PathVariable int id) {

		return itemsService.deleteItems(id);
	}

	@PutMapping("updateItems")
	public ResponseStructure<Items> updateItems(@RequestBody Items items,@RequestParam int id) {
		ResponseStructure<Items> items2 =itemsService.getItemsById(id);
		if(items2!=null) {
			items.setId(id);
			return itemsService.saveItems(items,id);
		}
		return null;
	}

}

