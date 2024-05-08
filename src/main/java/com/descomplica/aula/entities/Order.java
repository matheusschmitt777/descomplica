package com.descomplica.aula.entities;

import java.time.LocalTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer id;

	@Column(name = "order_date")
	private LocalTime orderDate;

	@ManyToMany
	Set<Product> products;
	
	public Order() {
	}

	public Order(Integer id, LocalTime orderDate) {
		this.id = id;
		this.orderDate = orderDate;
	}

	public Integer getPedidoId() {
		return id;
	}

	public void setPedidoId(Integer id) {
		this.id = id;
	}

	public LocalTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalTime orderDate) {
		this.orderDate = orderDate;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
