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
import com.ty.shoppingcart.online_cart.service.Cartservice;
import com.ty.shoppingcart.online_cart.util.ResponseStructure;
@RestController
public class CartController {

	@Autowired
	private Cartservice cartservice;
	@PostMapping("cart")
	public ResponseStructure<Cart> saveCart(@RequestBody Cart cart) {
		return cartservice.saveCart(cart);
	}
	
	@GetMapping("getCart")
	public ResponseStructure<Cart> getStudent(@RequestParam int id) {
		return cartservice.getCartById(id);
	}
	
	@DeleteMapping("cartdelete/{id}")
	public ResponseStructure<String> deleteCart(@PathVariable int id) {
		
		return cartservice.deleteCart(id);
	}
	
    @PutMapping("updateCart")
    public ResponseStructure<Cart> updateStudent(@RequestBody Cart cart,@RequestParam int id) {
    	ResponseStructure<Cart> cart2 =cartservice.getCartById(id);
    	if(cart2!=null) {
    		cart.setId(id);
    		return cartservice.saveCart(cart);
    	}
    	return null;
    }
}
