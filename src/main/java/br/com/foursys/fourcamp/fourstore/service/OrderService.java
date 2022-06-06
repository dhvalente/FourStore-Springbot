package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.controller.exception.DatabaseException;
import br.com.foursys.fourcamp.fourstore.data.OrderData;
import br.com.foursys.fourcamp.fourstore.data.SeasonData;
import br.com.foursys.fourcamp.fourstore.model.Order;
import br.com.foursys.fourcamp.fourstore.model.Season;
import br.com.foursys.fourcamp.fourstore.service.exception.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderData orderData;

	public List<Order> findAll() {
		return orderData.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = orderData.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Order insert(Order obj) {
		return orderData.save(obj);
	}
	
	public void delete(Long id) {
		try {
			orderData.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Order update(Long id, Order obj) {
		Order entity = orderData.getReferenceById(id);
		updateData(entity, obj);
		return orderData.save(entity);
	}

	private void updateData(Order entity, Order obj) {
			
	}
}
