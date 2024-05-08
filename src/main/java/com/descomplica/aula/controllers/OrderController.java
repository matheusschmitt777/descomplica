package com.descomplica.aula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.descomplica.aula.entities.Order;
import com.descomplica.aula.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(){
		List<Order> orders = orderService.getAll();
		if(!orders.isEmpty())
			return new ResponseEntity<>(orders, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getById(@PathVariable Integer id) {
		Order order = orderService.getById(id);
		if(order != null)
			return new ResponseEntity<>(order, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order order) {
		Order orderAtualizada = orderService.updateOrder(id, order);
		if(orderAtualizada != null)
			return new ResponseEntity<>(orderAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteOrder(@PathVariable Integer id) {
		if(orderService.deleteOrder(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
