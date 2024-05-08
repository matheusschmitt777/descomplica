package com.descomplica.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.descomplica.aula.entities.Product;
import com.descomplica.aula.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	
	public Product getById(Integer id) {
		return productRepository.findById(id).orElse(null) ;
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Integer id, Product product) {
		Product produtoAtualizado = productRepository.findById(id).orElse(null);
		if(produtoAtualizado != null) {
			produtoAtualizado.setName(product.getName());
			produtoAtualizado.setCategory(product.getCategory());
			return productRepository.save(produtoAtualizado);
		}else {
			return null;
		}
	}

	public Boolean deleteProduct(Integer id) {
		Product product = productRepository.findById(id).orElse(null);
		if(product != null) {
			productRepository.delete(product);
			return true;
		}else {
			return false;
		}
	}
}