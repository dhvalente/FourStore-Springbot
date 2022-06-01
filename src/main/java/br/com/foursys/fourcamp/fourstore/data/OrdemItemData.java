package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.fourstore.model.OrderItem;

public interface OrdemItemData extends JpaRepository<OrderItem, Long> {

}
