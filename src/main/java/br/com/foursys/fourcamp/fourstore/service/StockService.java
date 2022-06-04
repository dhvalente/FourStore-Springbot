/*package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.controller.exception.DatabaseException;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.data.StockData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Stock;
import br.com.foursys.fourcamp.fourstore.service.exception.ResourceNotFoundException;

@Service
public class StockService {
	@Autowired
	private StockData stockData;

	public Stock insert(Stock obj) {
		return stockData.save(obj);
	}

	public List<Stock> findAll() {
		return stockData.findAll();
	}

	public Stock findById(Long id) {
		Optional<Stock> obj = stockData.findById(id);
		return obj.get();
	}

	public void delete(Long id) {
		try {
			stockData.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}*/

	/*
	 * public Stock buyProduct (Long id, Stock obj) { Stock entity =
	 * stockData.getReferenceById(id); buy(entity, obj); return
	 * stockData.save(entity); }
	 * 
	 * private void buy(Stock entity, Stock obj) {
	 * entity.setProduct(obj.getProduct()); entity.setQuantity(obj.getQuantity()); }
	 */
/*
	public void buyProduct(Stock product, Integer buyQuantity) {
		product.setQuantity(buyQuantity + product.getQuantity());
	}
}*/
