package com.ty.shoppingcart.online_cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.shoppingcart.online_cart.dto.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
