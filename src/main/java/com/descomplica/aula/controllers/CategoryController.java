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

import com.descomplica.aula.entities.Category;
import com.descomplica.aula.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll(){
		List<Category> categorys = categoryService.getAll();
		if(!categorys.isEmpty())
			return new ResponseEntity<>(categorys, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable Integer id) {
		Category category = categoryService.getById(id);
		if(category != null)
			return new ResponseEntity<>(category, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
		Category categoryAtualizada = categoryService.updateCategory(id, category);
		if(categoryAtualizada != null)
			return new ResponseEntity<>(categoryAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCategory(@PathVariable Integer id) {
		if(categoryService.deleteCategory(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
