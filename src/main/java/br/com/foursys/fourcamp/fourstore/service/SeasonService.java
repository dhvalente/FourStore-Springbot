package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.fourstore.controller.exception.DatabaseException;
import br.com.foursys.fourcamp.fourstore.data.SeasonData;
import br.com.foursys.fourcamp.fourstore.model.Season;
import br.com.foursys.fourcamp.fourstore.service.exception.ResourceNotFoundException;

@Service
public class SeasonService {

	@Autowired
	private SeasonData seasonData;

	public List<Season> findAll() {
		return seasonData.findAll();
	}

	public Season findById(Long id) {
		Optional<Season> obj = seasonData.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Season insert(Season obj) {
		return seasonData.save(obj);
	}
	
	public void delete(Long id) {
		try {
			seasonData.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Season update(Long id, Season obj) {
		Season entity = seasonData.getReferenceById(id);
		updateData(entity, obj);
		return seasonData.save(entity);
	}

	private void updateData(Season entity, Season obj) {
		entity.setName(obj.getName());		
	}

}
