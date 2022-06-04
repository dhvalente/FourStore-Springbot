package br.com.foursys.fourcamp.fourstore.data;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.foursys.fourcamp.fourstore.model.Season;

public interface SeasonData extends JpaRepository<Season, Long>{

}
