package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.foursys.fourcamp.fourstore.model.Category;


public interface CategoryData extends JpaRepository<Category, Long> {

}
