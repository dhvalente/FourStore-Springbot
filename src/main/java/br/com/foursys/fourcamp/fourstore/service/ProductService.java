package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductData productData;

	public List<Product> findAll() {
		return productData.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = productData.findById(id);
		return obj.get();
	}
}
