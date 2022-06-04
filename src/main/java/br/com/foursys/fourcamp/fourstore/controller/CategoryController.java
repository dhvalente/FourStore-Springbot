package br.com.foursys.fourcamp.fourstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.foursys.fourcamp.fourstore.model.Category;
import br.com.foursys.fourcamp.fourstore.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService clientService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = clientService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = clientService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}