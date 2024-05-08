package com.descomplica.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.descomplica.aula.entities.Order;
import com.descomplica.aula.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getAll(){
		return orderRepository.findAll();
	}
	
	public Order getById(Integer id) {
		return orderRepository.findById(id).orElse(null) ;
	}
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public Boolean deleteOrder(Integer id) {
		Order pedido = orderRepository.findById(id).orElse(null);
		if(pedido != null) {
			orderRepository.delete(pedido);
			return true;
		}else {
			return false;
		}
	}
	
	public Order updateOrder(Integer id, Order order) {
		Order pedidoAtualizado = orderRepository.findById(id).orElse(null);
		if(pedidoAtualizado != null) {
			pedidoAtualizado.setOrderDate(order.getOrderDate());
			return orderRepository.save(pedidoAtualizado);
		}else {
			return null;
		}
	}
}