package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.data.CategoryData;
import br.com.foursys.fourcamp.fourstore.model.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryData orderData;

	public List<Category> findAll() {
		return orderData.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = orderData.findById(id);
		return obj.get();
	}
}
