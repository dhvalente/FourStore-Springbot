package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.fourstore.model.Order;

public interface OrderData extends JpaRepository<Order, Long> {

}
