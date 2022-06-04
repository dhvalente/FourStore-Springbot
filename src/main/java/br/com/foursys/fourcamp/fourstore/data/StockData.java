package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.foursys.fourcamp.fourstore.model.Stock;

public interface StockData extends JpaRepository<Stock, Long> {

}
