package com.ty.shoppingcart.online_cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.shoppingcart.online_cart.dto.Cart;
import com.ty.shoppingcart.online_cart.repo.CartRepository;

@Repository
public class CartDao {
	@Autowired
	private CartRepository cartRepository;


	public Cart saveCart( Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart getCartById(int id) {
		return cartRepository.findById(id).get();
	}

	public String deleteCart(int id) {

		cartRepository.deleteById(id);
		return "deleted";
	}
}
