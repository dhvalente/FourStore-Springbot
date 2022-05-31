package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.data.OrderData;
import br.com.foursys.fourcamp.fourstore.model.Order;

@Service
public class OrderService {
	@Autowired
	private OrderData orderData;

	public List<Order> findAll() {
		return orderData.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = orderData.findById(id);
		return obj.get();
	}
}
