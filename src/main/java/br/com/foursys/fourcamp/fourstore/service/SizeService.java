package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.foursys.fourcamp.fourstore.controller.exception.DatabaseException;
import br.com.foursys.fourcamp.fourstore.data.SizeData;
import br.com.foursys.fourcamp.fourstore.model.Size;
import br.com.foursys.fourcamp.fourstore.service.exception.ResourceNotFoundException;

@Service
public class SizeService {

	@Autowired
	private SizeData sizeData;

	public List<Size> findAll() {
		return sizeData.findAll();
	}

	public Size findById(Long id) {
		Optional<Size> obj = sizeData.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Size insert(Size obj) {
		return sizeData.save(obj);
	}
	
	public void delete(Long id) {
		try {
			sizeData.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Size update(Long id, Size obj) {
		Size entity = sizeData.getReferenceById(id);
		updateData(entity, obj);
		return sizeData.save(entity);
	}

	private void updateData(Size entity, Size obj) {
		entity.setName(obj.getName());		
	}

}
