package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.controller.exception.DatabaseException;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.exception.ResourceNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductData productData;
	
	public Product insert(Product obj) {
		return productData.save(obj);
	}

	public List<Product> findAll() {
		return productData.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = productData.findById(id);
		return obj.get();
	}
	
	public void delete(Long id) {
		try {
			productData.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Product update(Long id, Product obj) {
		Product entity = productData.getReferenceById(id);
		updateData(entity, obj);
		return productData.save(entity);
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setColor(obj.getColor());
		entity.setSeason(obj.getSeason());
		entity.setSize(obj.getSize());
		entity.setPurchasePrice(obj.getPurchasePrice());
		entity.setSellPrice(obj.getSellPrice());
		
	}
}
