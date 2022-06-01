package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.foursys.fourcamp.fourstore.model.Product;


public interface ProductData extends JpaRepository<Product, Long> {

}
