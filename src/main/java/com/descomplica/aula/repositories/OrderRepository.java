package com.descomplica.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.descomplica.aula.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
