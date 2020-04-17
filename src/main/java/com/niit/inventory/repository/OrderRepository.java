package com.niit.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.inventory.model.Order1;
import com.niit.inventory.model.Product;


public interface OrderRepository extends JpaRepository<Order1, Long> {

	

}
