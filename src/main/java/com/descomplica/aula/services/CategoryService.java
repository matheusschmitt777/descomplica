package com.descomplica.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.descomplica.aula.entities.Category;
import com.descomplica.aula.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAll(){
		return categoryRepository.findAll();
	}
	
	public Category getById(Integer id) {
		return categoryRepository.findById(id).orElse(null) ;
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Integer id, Category category) {
		Category categoriaAtualizada = categoryRepository.findById(id).orElse(null);
		if(categoriaAtualizada != null) {
			categoriaAtualizada.setName(category.getName());
			return categoryRepository.save(categoriaAtualizada);
		}else {
			return null;
		}
	}

	public Boolean deleteCategory(Integer id) {
		Category categoria = categoryRepository.findById(id).orElse(null);
		if(categoria != null) {
			categoryRepository.delete(categoria);
			return true;
		}else {
			return false;
		}
	}
}