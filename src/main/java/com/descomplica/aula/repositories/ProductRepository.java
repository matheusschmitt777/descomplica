package com.descomplica.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.descomplica.aula.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
